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

import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.PoreskeGrupe;
import com.hellokoding.auth.service.PoreskeGrupeService;
import com.hellokoding.auth.validator.UserValidator;


@Controller
public class PoreskeGrupeController {
	@Autowired
	private PoreskeGrupeService poreskeGrupeService;

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
	

	@RequestMapping(value = "/poreskeGrupe.html")
	public String poreskeGrupeDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Poreske grupe");
		request.setAttribute("new_item", "/poreskeGrupe_new.html");
		request.setAttribute("print_item", "/poreskeGrupe_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/poreskeGrupe_new.html", method = RequestMethod.GET)
	public ModelAndView newporeskeGrupe(Model model) { 
		model.addAttribute("title", "New Poreske grupe");
//		model.addAttribute("model_atribut", "poreskeGrupe");

		PoreskeGrupe aa = new PoreskeGrupe();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("poreskeGrupeForm", "poreskeGrupe", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save-poreskeGrupe.html", method = RequestMethod.POST)
	public String addPoreskeGrupe(@ModelAttribute("poreskeGrupe") @Valid PoreskeGrupe poreskeGrupe, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "poreskeGrupeForm";
		}

		poreskeGrupeService.save(poreskeGrupe);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_poreskeGrupe", "/poreskeGrupe_new.html");
//		request.setAttribute("print_poreskeGrupe", "/poreskeGrupe_pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Poreske grupe");
		model.addAttribute("new_poreskeGrupe", "/poreskeGrupe_new.html");
		model.addAttribute("print_poreskeGrupe", "/poreskeGrupe_pdf.html");
		// return "redirect:vrste-paleta.html"; 
		return "list-items"; 
	}
	
//	@RequestMapping(value = "/vrste-artikala.html", method = RequestMethod.GET)
//	public String typesPaletsForm(Model model) {
//		VrstePaletaDao poreskeGrupeDao = null;
//		model.addAttribute("tasks", poreskeGrupeDao.findAll());
//		model.addAttribute("mode", "MODE_TASKS");
//		model.addAttribute("title", "Type of pallets");
//		return "vrstePaletaForm";
//	}
//
	
	
    @RequestMapping(value = "/update-poreskeGrupe.html")
	public String updatePoreskeGrupenn(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("poreskeGrupe", poreskeGrupeService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update PoreskeGrupe");
		
		return "poreskeGrupeForm";
	}
    

	@RequestMapping(value = "/delete-poreskeGrupe.html")
	public String deletePoreskeGrupe(@RequestParam Long id, HttpServletRequest request) {

		poreskeGrupeService.delete(id);
//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "PoreskeGrupe");
//		request.setAttribute("new_poreskeGrupe", "/poreskeGrupe_new.html");
//		request.setAttribute("print_poreskeGrupe", "/poreskeGrupe_pdf.html");
//		return "list-items";
		return "redirect:poreskeGrupe.html";
	}
	
    @RequestMapping(path = "/poreskeGrupe_pdf.html", method = RequestMethod.GET)
    public ModelAndView reportPoreskeGrupe() {
        
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", poreskeGrupeService.getAllPoreskeGrupe());
        params.put("title", "Poreske Grupe");
        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
