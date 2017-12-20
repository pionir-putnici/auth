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
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.repository.ZipCodesRepository;


@Controller
public class PttBrojeviController {
	@Autowired
	private ZipCodesRepository zipCodesRepository;

    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	

	@RequestMapping(value = "/zipCodes.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Zip Codes");
		request.setAttribute("new_item", "/zipCodes_new.html");
		request.setAttribute("print_item", "/zipCodes_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/zipCodes_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model) { 
		model.addAttribute("title", "New zipCodes");
//		model.addAttribute("model_atribut", "zipCodes");

		PttBrojevi aa = new PttBrojevi();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("zipCodesForm", "zipCodes", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_zipCodes.html", method = RequestMethod.POST)
	public String addTypeMeasure(@ModelAttribute("zipCodes") @Valid PttBrojevi zipCodes, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "zipCodesForm";
		}

		zipCodesRepository.save(zipCodes);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_zipCodes ", "/zipCodes _new.html");
//		request.setAttribute("print_zipCodes ", "/zipCodes _pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "ZipCodes");
		model.addAttribute("new_zipCodes", "/zipCodes_new.html");
		model.addAttribute("print_zipCodes", "/zipCodes_pdf.html");

		return "redirect:zipCodes.html";

	}
	
    
    @RequestMapping(value = "/update_zipCodes.html")
	public String updateTypeMeasure(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("zipCodes", zipCodesRepository.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update zipCodes");	
		return "zipCodesForm";
	}
    

	@RequestMapping(value = "/delete_zipCodes.html")
	public String deleteTypeMeasure(@RequestParam Long id, HttpServletRequest request) {

		zipCodesRepository.delete(id);

		return "redirect:zipCodes.html";
	}
	
    @RequestMapping(path = "/zipCodes_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypeMeasureReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", zipCodesRepository.findAllByOrderByIdDesc());
        params.put("title", "ZipCodes");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
