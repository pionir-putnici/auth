package com.hellokoding.auth.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hellokoding.auth.dao.VrstePaletaDao;
//import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.VrstePaletaService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;

@Controller
public class TypesOfPalletsController {
	@Autowired
	private VrstePaletaService vrstePaletaService;

	// @Autowired
	// private SecurityService securityService;

	@Autowired
	private VrstePaletaValidator vrstePaletaValidator;
	@Autowired
	private VrstePaletaDao vrstePaletaDao;

	
	@RequestMapping(path="/v", method=RequestMethod.GET)
	public List<VrstePaleta> getAllVrstePalets(){
//		List<VrstePaleta> aa = vrstePaletaDao.findAll();
//		return vrstePaletaDao.findAll(); // redirect:/	
		return vrstePaletaDao.findAll();		
	}	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testGet(Model model, String error, String logout) {
		model.addAttribute("tasks", vrstePaletaDao.findAll());
		model.addAttribute("mode", "MODE_HOME");
		model.addAttribute("title", "Evidence of pallets");
		return "list-pallets"; // redirect:/
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPost(Model model, String error, String logout) {
		model.addAttribute("mode", "MODE_HOME");
		model.addAttribute("title", "Evidence of pallets");
		return "index"; // redirect:/
	}

	@RequestMapping(value = "/vrste-paleta.html", method = RequestMethod.GET)
	public String typesPaletsForm(Model model) {
		model.addAttribute("tasks", vrstePaletaDao.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Type of pallets");
		return "vrstePaletaForm";
	}

//	@RequestMapping(value = "/save-vrste-paleta1.html", method = RequestMethod.POST)
//	public String savepallets(@ModelAttribute("vrstePaletaForm") VrstePaleta vrstePaletaForm,
//			BindingResult bindingResult, Model model, String error, String logout) {
//		vrstePaletaValidator.validate(vrstePaletaForm, bindingResult);
//
//		if (error != null)
//			model.addAttribute("error", "Your username and password is invalid.");
//
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("mode", "MODE_NEW");
//			model.addAttribute("error", "Error ...");
//			return "vrstePaletaUnosForm";
//		}

//		vrstePaletaService.save(vrstePaletaForm);
//
//		// securityService.autologin(vrstePaletaForm.getUsername(),
//		// vrstePaletaForm.getPasswordConfirm());
//
//		model.addAttribute("mode", "MODE_HOME");
//
//		return "vrstePaletaUnosForm";
//	}

	@RequestMapping(value = "/save-vrste-paleta.html", method = RequestMethod.POST)
	public String addType(@ModelAttribute("vrstePaleta") @Valid VrstePaleta vrstePaleta, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "vrstePaletaUnosFormNew";
		}

		vrstePaletaService.save(vrstePaleta);
		// return "redirect:vrste-paleta.html"; 
		return "list-pallets"; 
	}

	@RequestMapping(value = "/new-vrste-paleta.html", method = RequestMethod.GET)
	public ModelAndView newTypePallet() { // HttpServletRequest request, Model model
		// model.addAttribute("tasks", vrstePaletaDao);
		// model.addAttribute("mode", "MODE_NEW");
		// model.addAttribute("title", "Type of pallets");
		// return "vrstePaletaUnosForm";
		
		VrstePaleta aa = new VrstePaleta();
		// da bi default aktivan bio checked
		aa.setAktivan(true);
		return new ModelAndView("vrstePaletaUnosFormNew", "vrstePaleta", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}
	
//    @RequestMapping(value = "/update-vrste-paleta.html", 
//    		method = RequestMethod.GET)
//    public String updateTask(@ModelAttribute("vrstePaleta"), @RequestParam int id, HttpServletRequest request
//    ) {
////       VrstePaletaDao dao = new VrstePaletaDao();
////        String sid = Integer.toString(id);
//        request.setAttribute("vrstePaleta", vrstePaletaDao.findByUid(id)); //  dao.getAllProdajeId("where id = " + sid));
//		vrstePaletaService.save(vrstePaleta);
////        request.setAttribute("mode", "MODE_UPDATE");
//        return "evidencijaPrikaz";
//    }
    
    @RequestMapping(value = "/update-vrste-paleta.html")
	public String updateTypePallet(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("vrstePaleta", vrstePaletaService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "vrstePaletaUnosFormNew";
	}
    

	@RequestMapping(value = "/delete-vrste-paleta.html")
	public String deleteTypePallet(@RequestParam Long id, HttpServletRequest request) {
//      request.setAttribute("vrstePaleta", vrstePaletaDao.findByUid(id)); //  dao.getAllProdajeId("where id = " + sid));
//		vrstePaletaService.save(vrstePaleta);
		try {
		vrstePaletaService.delete(id);
		
    }
	catch (Exception ex)
	{
	    return "redirect:414.html?ops=Can't delete record!";
	}
		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Types of pallets");
		// return "vrstePaletaForm";
		return "list-pallets";
	}	
	
}
