package com.register.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.register.constants.Constants;
import com.register.domain.Email;
import com.register.domain.Login;
import com.register.domain.Register;
import com.register.domain.Unlock;
import com.register.entity.CityEntity;
import com.register.entity.CountryEntity;
import com.register.entity.RegisterEntity;
import com.register.entity.StateEntity;
import com.register.repo.CityRepo;
import com.register.repo.CountryRepo;
import com.register.repo.RegisterRepository;
import com.register.repo.StateRepo;
import com.register.util.EmailUtils;
import com.register.util.PwdUtils;
import com.register.util.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private RegisterRepository repo;
	
	@Autowired
	private CountryRepo corepo;
	
	@Autowired
	private StateRepo srepo;
	
	@Autowired
	private CityRepo crepo;
	
	@Autowired
	EmailUtils eu;
	
	@Autowired
	TwilioConfig tc;
	
	@Override
	public String findByEmail(String email) {
				
		RegisterEntity re=repo.findByEmail(email);
		if(null!=re) {
			return "Duplicate";
		}
		return "Unique";
	}
	
	@Override
	public boolean register(Register r) {
		r.setUserPwd(PwdUtils.genrateTempPwd(Constants.PWD_LEN));
		r.setAccountStatus(Constants.LOCK_STR);
		RegisterEntity re = new RegisterEntity();
		BeanUtils.copyProperties(r, re);
		RegisterEntity re1 = repo.save(re);
		if(re1.getRegisterId() != null) {
			return eu.sendEmailNew(r);
		}
		return false;
	}

	@Override
	public Map<Integer, String> getContries() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		List<CountryEntity> list=corepo.findAll();
		list.forEach(CountryEntity->{
			map.put(CountryEntity.getCountryId(), CountryEntity.getCountryName());
		});
		
		return map;
	}

	@Override
	public Map<Integer, String> findAllByCountryId(Integer countryId) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		List<StateEntity> list=srepo.findAllByCountryId(countryId);
		list.forEach(StateEntity->{
			map.put(StateEntity.getStateId(), StateEntity.getStateName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> findAllByStateId(Integer stateId) {
	Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		List<CityEntity> list=crepo.findAllByStateId(stateId);
		list.forEach(CityEntity->{
			map.put(CityEntity.getCityId(), CityEntity.getCityName());
		});
		return map;
	}

	@Override
	public boolean validTempPwd(Unlock unlock) {
		RegisterEntity r=repo.findByEmail(unlock.getEmail());
		Register re = new Register();
		if(r.getUserPwd().equals(unlock.getTemPwd())) {
			r.setAccountStatus("UNLOCK");
			r.setUserPwd(unlock.getCnfPwd());
			BeanUtils.copyProperties(r, re);
			repo.saveAndFlush(r);
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Register loginAcc(Login login, Model model) {
		RegisterEntity re = repo.findByEmail(login.getEmail());
		if(re.getUserPwd().equals(login.getUserPwd())) {
			if(re.getAccountStatus().equalsIgnoreCase("UNLOCK")) {
				Register r=new Register();
			BeanUtils.copyProperties(re, r);
			return r;
			}
			else {
				model.addAttribute("errMsg", "Account is locked, Please check mail to unlock");
				return null;
			}
		}
		else {
			model.addAttribute("errMsg", "InCorrect EmailId or Password");
			return null;
		}
	}

	@Override
	public String forgetPwd(Email email) {
		RegisterEntity r=repo.findByEmail(email.getEmail());
		String phone=r.getPhNo();
		String num=phone.substring(6, 9);
		String pwd = r.getUserPwd();
		if(email.getEmail().equals(r.getEmail())) {
			if(r.getAccountStatus().equalsIgnoreCase("UNLOCK")) {
			PhoneNumber to = new PhoneNumber(phone);
			PhoneNumber from = new PhoneNumber(tc.getTrialNumber());
			String message = "Hi Your Password is" + pwd;
			MessageCreator creator = Message.creator(to,from,message);
			creator.create();
			return "SMS sent to *******"+num;
			}
			else return "lock";
		}
			
		else return "false";
	}

}
