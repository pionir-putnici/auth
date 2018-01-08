package com.hellokoding.auth.controllers;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model, HttpServletRequest request) {
    	Principal uu = request.getUserPrincipal();
    //	String ss = request.uu.getName();
    	boolean isAdmin = request.isUserInRole("ADMIN");
    //	 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        model.addAttribute("mode", "MODE_HOME");
        
        return "redirect:/";  //index
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
  //      return "redirect:/";  //index
        
        return "login";
    }
 

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";

    }
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(Model model, HttpServletResponse response, HttpServletRequest request) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
    	new SecurityContextLogoutHandler().logout(request, response, auth);
    	request.getSession().invalidate();
    }
        return "redirect:/";

    }
    
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }

    @RequestMapping(value="/404")
    public String Error404(){
        return "404";
    }
    
    @RequestMapping(value="/414.html")
    public String Error414(){
        return "414";
    }
    
    private String getLoggedUserName(ModelMap model) {
    	
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (principal instanceof User) {
    		return ((User) principal).getUsername();
    	}
    	return principal.toString();
    }
}
