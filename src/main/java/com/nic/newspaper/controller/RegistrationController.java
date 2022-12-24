package com.nic.newspaper.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nic.newspaper.entity.User;
import com.nic.newspaper.service.UserService;
import com.nic.newspaper.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
    @Autowired
    private UserService userService;
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("crmUser", new CrmUser());
		
		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String userEmail = theCrmUser.getEmail();
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 return "registration-form";
	        }

		// check the database if user already exists
        User existing = userService.findByUserEmail(userEmail);
        if (existing != null){
        	theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "Указанный email уже существует.");

        	return "registration-form";
        }
        
        // create user account        						
        userService.save(theCrmUser);
        
        return "registration-confirmation";		
	}
}
