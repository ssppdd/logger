package com.register.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.register.domain.Email;
import com.register.domain.Login;
import com.register.domain.Register;
import com.register.domain.Unlock;
import com.register.service.IRegisterService;

@Controller
public class RegisterController {
	
	@Autowired
    private IRegisterService service;
	
	@GetMapping(value = { "/", "/register" })
	public String loadForm(Model model) {
		Register r = new Register();
		model.addAttribute("register", r);
		Map<Integer, String> map=service.getContries();
		model.addAttribute("countryMap", map);
		return "register";
	}
	@GetMapping("/getstate")
	@ResponseBody
	public Map<Integer, String> getState(@RequestParam("cid") Integer countryId){
		return service.findAllByCountryId(countryId);
	}
	@GetMapping("/getcity")
	@ResponseBody
	public Map<Integer, String> getCity(@RequestParam("sid") Integer stateId){
		return service.findAllByStateId(stateId);
	}
	
	   @GetMapping("/validateEmail")
	   @ResponseBody
	   public String validateEmail(@RequestParam String email ){

	     String emailStatus =  service.findByEmail(email);

		 return emailStatus;

	   }
	   @PostMapping(value = "/register1")
		public String handleSubmitBtn(@ModelAttribute("register") Register re, RedirectAttributes attribut) {
		  	boolean isSaved = service.register(re);
			if(isSaved) {
				return "registersuccess";
			}else {
				attribut.addFlashAttribute("errMsg", "Registration Faild");
				return "redirect:/register";
			}
		}
	   @GetMapping("/unlockAcc")
	   public String unLockAcc(@RequestParam("email") String email, Model model) {
		   Unlock unlock= new Unlock();
		   unlock.setEmail(email);
		   model.addAttribute("unlock", unlock);
		   return "unlock";
	   }
	   @PostMapping("/unlock")
	   public String unlock(@ModelAttribute("unlock") Unlock unlock, Model model, RedirectAttributes attribut) {
		   
		   boolean flag=service.validTempPwd(unlock);
		   if(flag==true) {
			   return "redirect:/login";
		   }
		   else {
			   attribut.addFlashAttribute("errMsg", "InCorrect Temporary Password");
			   return "redirect:/unlock";
		   }
	   }
	   @GetMapping("/login")
	   public String loginPage(Model model) {
		   Login login = new Login();
		   model.addAttribute("login", login);
		   return "login";
	   }
	   @PostMapping("/login")
	   public String login(@ModelAttribute("login") Login login, Model model) {
		   Register r = service.loginAcc(login, model);
		   if(r != null) {
			   model.addAttribute("userInfo", r);
			   return "dashboard";
		   }
		   else {
			   return "login";
		   }
	   }
	   @GetMapping("/forgetpwd")
		public String forget(Model model) {
			Email e = new Email();
			model.addAttribute("email",e);
			return "forgetpwd";
	   }
	   @PostMapping("/forgetpwd")
	   public String forgetPwd(@ModelAttribute("email") Email email, Model model) {
		   String flag=service.forgetPwd(email);
		   if(flag.equals("lock")) {
			   model.addAttribute("errMsg", "Your Account is Locked, Please check Email to unlock");
			   return "forgetpwd";
		   }else if(flag != "false") {
			   model.addAttribute("Msg", flag);
			   return "forgetpwd";
		   }
		   else {
			   model.addAttribute("errMsg", "Invalid Email");
			   return "forgetpwd";
		   }
	   }
	   
	}



