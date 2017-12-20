package com.hellokoding.auth.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.hellokoding.auth.dao.VrstePaletaDao;
import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.VrsteArtikala;
//import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.VrsteArtikalaService;
import com.hellokoding.auth.service.VrstePaletaService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;

@Controller
public class ItemsController {
	@Autowired
	private VrsteArtikalaService vrsteArtikalaService;

    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	// @Autowired
	// private SecurityService securityService;

//	@Autowired
//	private VrstePaletaValidator vrstePaletaValidator;
//	@Autowired
//	private VrstePaletaDao vrstePaletaDao;
	

	@RequestMapping(value = "/articles_types.html")
	public String AriclesTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Type of articles");
		request.setAttribute("new_item", "/articles_types_new.html");
		request.setAttribute("print_item", "/articles_types_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/articles_types_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model) { 
		model.addAttribute("title", "New Type of articles");
//		model.addAttribute("model_atribut", "vrsteArtikala");

		VrsteArtikala aa = new VrsteArtikala();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("itemForm", "vrsteArtikala", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save-vrste-artikala.html", method = RequestMethod.POST)
	public String addTypeAricles(@ModelAttribute("vrsteArtikala") @Valid VrsteArtikala vrsteArtikala, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "itemForm";
		}

		vrsteArtikalaService.save(vrsteArtikala);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_articles_types", "/articles_types_new.html");
//		request.setAttribute("print_articles_types", "/articles_types_pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Type of articles");
		model.addAttribute("new_articles_types", "/articles_types_new.html");
		model.addAttribute("print_articles_types", "/articles_types_pdf.html");
		// return "redirect:vrste-paleta.html"; 
		return "list-items"; 
	}
	
//	@RequestMapping(value = "/vrste-artikala.html", method = RequestMethod.GET)
//	public String typesPaletsForm(Model model) {
//		VrstePaletaDao vrsteArtikalaDao = null;
//		model.addAttribute("tasks", vrsteArtikalaDao.findAll());
//		model.addAttribute("mode", "MODE_TASKS");
//		model.addAttribute("title", "Type of pallets");
//		return "vrstePaletaForm";
//	}
//
	
    
    @RequestMapping(value = "/update-vrste-artikala.html")
	public String updateTypeAricles(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("vrsteArtikala", vrsteArtikalaService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update Type of articles");
		
		return "itemForm";
	}
    

	@RequestMapping(value = "/delete-vrste-artikala.html")
	public String deleteTypeAricles(@RequestParam Long id, HttpServletRequest request) {

		vrsteArtikalaService.delete(id);
//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Types of articles");
//		request.setAttribute("new_articles_types", "/articles_types_new.html");
//		request.setAttribute("print_articles_types", "/articles_types_pdf.html");
//		return "list-items";
		return "redirect:articles_types.html";
	}
	
    @RequestMapping(path = "/articles_types_pdf.html", method = RequestMethod.GET)
    public ModelAndView reportTypesofarticles() {
        
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", vrsteArtikalaService.getAllVrsteArtikala());
        params.put("title", "Types of articles");
        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
