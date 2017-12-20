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
import com.hellokoding.auth.model.JediniceMera;
//import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.JediniceMeraService;
import com.hellokoding.auth.service.VrstePaletaService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;

@Controller
public class JediniceMeraController {
	@Autowired
	private JediniceMeraService jediniceMeraService;

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
	

	@RequestMapping(value = "/units_of_measure.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Units of measure");
		request.setAttribute("new_item", "/units_of_measure_new.html");
		request.setAttribute("print_item", "/units_of_measure_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/units_of_measure_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model) { 
		model.addAttribute("title", "New units of measure");
//		model.addAttribute("model_atribut", "jediniceMera");

		JediniceMera aa = new JediniceMera();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("unitsOfMeasureForm", "jediniceMera", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_units_of_measure.html", method = RequestMethod.POST)
	public String addTypeMeasure(@ModelAttribute("jediniceMera") @Valid JediniceMera jediniceMera, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "unitsOfMeasureForm";
		}

		jediniceMeraService.save(jediniceMera);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_units_of_measure ", "/units_of_measure _new.html");
//		request.setAttribute("print_units_of_measure ", "/units_of_measure _pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Units of measure");
		model.addAttribute("new_units_of_measure", "/units_of_measure_new.html");
		model.addAttribute("print_units_of_measure", "/units_of_measure_pdf.html");

		return "redirect:units_of_measure.html";
//		return "list-items"; 
	}
	
//	@RequestMapping(value = "/vrste-artikala.html", method = RequestMethod.GET)
//	public String typesPaletsForm(Model model) {
//		VrstePaletaDao jediniceMeraDao = null;
//		model.addAttribute("tasks", jediniceMeraDao.findAll());
//		model.addAttribute("mode", "MODE_TASKS");
//		model.addAttribute("title", "Type of pallets");
//		return "vrstePaletaForm";
//	}
//
	
    
    @RequestMapping(value = "/update_units_of_measure.html")
	public String updateTypeMeasure(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("jediniceMera", jediniceMeraService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update units of measure");
		
		return "unitsOfMeasureForm";
	}
    

	@RequestMapping(value = "/delete_units_of_measure.html")
	public String deleteTypeMeasure(@RequestParam Long id, HttpServletRequest request) {

		jediniceMeraService.delete(id);
//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Types of articles");
//		request.setAttribute("new_units_of_measure ", "/units_of_measure _new.html");
//		request.setAttribute("print_units_of_measure ", "/units_of_measure _pdf.html");
//		return "list-items";
		return "redirect:units_of_measure.html";
	}
	
    @RequestMapping(path = "/units_of_measure_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypeMeasureReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", jediniceMeraService.getAllJediniceMera());
        params.put("title", "Jedinice Mera");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
