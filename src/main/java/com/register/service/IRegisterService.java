package com.register.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.register.domain.Email;
import com.register.domain.Login;
import com.register.domain.Register;
import com.register.domain.Unlock;

@Service
public interface IRegisterService {
	
	public String findByEmail(String email);
	
	public boolean register(Register re);
	
	public Map<Integer, String> getContries();
	
	public Map<Integer, String> findAllByCountryId(Integer countryId);
	
	public Map<Integer, String> findAllByStateId(Integer stateId);
	
	public boolean validTempPwd(Unlock unlock);
	
	public Register loginAcc(Login login, Model model);
	
	public String forgetPwd(Email email);

}
