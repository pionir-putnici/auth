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
import com.hellokoding.auth.model.Klasifikacije;
//import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.KlasifikacijeService;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.KlasifikacijeService;
import com.hellokoding.auth.service.VrstePaletaService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;


@Controller
public class ClassificationsController {
	@Autowired
	private KlasifikacijeService classificationsService;

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
	

	@RequestMapping(value = "/classifications.html")
	public String classificationsDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Classifications");
		request.setAttribute("new_item", "/classifications_new.html");
		request.setAttribute("print_item", "/classifications_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/classifications_new.html", method = RequestMethod.GET)
	public ModelAndView newclassifications(Model model) { 
		model.addAttribute("title", "New Classifications");
//		model.addAttribute("model_atribut", "klasifikacije");

		Klasifikacije aa = new Klasifikacije();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("classificationForm", "klasifikacije", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save-classifications.html", method = RequestMethod.POST)
	public String addClassifications(@ModelAttribute("klasifikacije") @Valid Klasifikacije klasifikacije, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "classificationForm";
		}

		classificationsService.save(klasifikacije);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_classifications", "/classifications_new.html");
//		request.setAttribute("print_classifications", "/classifications_pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Classifications");
		model.addAttribute("new_classifications", "/classifications_new.html");
		model.addAttribute("print_classifications", "/classifications_pdf.html");
		// return "redirect:vrste-paleta.html"; 
		return "list-items"; 
	}
	
//	@RequestMapping(value = "/vrste-artikala.html", method = RequestMethod.GET)
//	public String typesPaletsForm(Model model) {
//		VrstePaletaDao klasifikacijeDao = null;
//		model.addAttribute("tasks", klasifikacijeDao.findAll());
//		model.addAttribute("mode", "MODE_TASKS");
//		model.addAttribute("title", "Type of pallets");
//		return "vrstePaletaForm";
//	}
//
	
	
    @RequestMapping(value = "/update-classifications.html")
	public String updateClassificationsnn(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("klasifikacije", classificationsService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update Classifications");
		
		return "classificationForm";
	}
    

	@RequestMapping(value = "/delete-classifications.html")
	public String deleteClassifications(@RequestParam Long id, HttpServletRequest request) {

		classificationsService.delete(id);
//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Classifications");
//		request.setAttribute("new_classifications", "/classifications_new.html");
//		request.setAttribute("print_classifications", "/classifications_pdf.html");
//		return "list-items";
		return "redirect:classifications.html";
	}
	
    @RequestMapping(path = "/classifications_pdf.html", method = RequestMethod.GET)
    public ModelAndView reportClassifications() {
        
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", classificationsService.getAllKlasifikacije());
        params.put("title", "Classifications");
        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
