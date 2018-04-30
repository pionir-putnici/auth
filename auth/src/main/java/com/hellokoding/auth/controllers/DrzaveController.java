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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.Drzave;
import com.hellokoding.auth.repository.DrzaveRepository;
import com.hellokoding.auth.model.PttBrojevi;

@Controller
public class DrzaveController {
	@Autowired
	private DrzaveRepository statesRepository;

    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	
//	@Autowired
//	private PttBrojevi pttBrojevi;
	
	@RequestMapping(value = "/states.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "States");
		request.setAttribute("new_item", "/states_new.html");
		request.setAttribute("print_item", "/states_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/states_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model) { 
		model.addAttribute("title", "New states");
//		model.addAttribute("model_atribut", "states");

		Drzave aa = new Drzave();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("statesForm", "states", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_states.html", method = RequestMethod.POST)
	public String addTypeMeasure(@ModelAttribute("states") @Valid Drzave states, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "statesForm";
		}

		String rr = states.getName();
		Long tt = states.getId();
		
//		if (states.getId() != null) {
//			PttBrojevi pttBrojevi = new PttBrojevi();
//			pttBrojevi.setDrzave(states);
//		}
		statesRepository.save(states);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_states ", "/states _new.html");
//		request.setAttribute("print_states ", "/states _pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "States");
		model.addAttribute("new_states", "/states_new.html");
		model.addAttribute("print_states", "/states_pdf.html");

		return "redirect:states.html";

	}
	
    
    @RequestMapping(value = "/update_states.html")
	public String updateTypeMeasure(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("states", statesRepository.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update states");	
		return "statesForm";
	}
    

	@RequestMapping(value = "/delete_states.html")
	public String deleteTypeMeasure(@RequestParam Long id, HttpServletRequest request) {

		statesRepository.delete(id);

		return "redirect:states.html";
	}
	
    @RequestMapping(path = "/states_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypeMeasureReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", statesRepository.findAllByOrderByIdDesc());
        params.put("title", "States");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }

    
//    @RequestMapping(path = "/print_states.html", method = RequestMethod.GET)
//    public ModelAndView printStates() {
//
//        return new ModelAndView(view, params);
//    }
//    
    
    @RequestMapping(value="/printCodebook.html")
    public String selectTag(HttpServletRequest request) {
      //  ModelAndView mav = new ModelAndView("/printing/printCodebook");
         
        List<Drzave> states = statesRepository.findAll();      
		request.setAttribute("states", states);
        // mav.addObject("states", states);
         
        return "/printing/printCodebook";    
    }    
    
    
}
