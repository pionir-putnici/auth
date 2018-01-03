package com.hellokoding.auth.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.hellokoding.auth.model.Drzave;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.repository.ZipCodesRepository;


@Controller
public class PartnerController {
	@Autowired
	private CostumersRepository partnerRepository;

	@Autowired
	private ZipCodesRepository zipCodesRepository;
	
	@Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;

	
	@RequestMapping(value = "/partner.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Partners");
		request.setAttribute("new_item", "/partner_new.html");
		request.setAttribute("print_item", "/partner_pdf.html");
		return "partner";
	}	

	@RequestMapping(value = "/partner_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model, HttpServletRequest request) { 
		model.addAttribute("title", "New partner");
//		model.addAttribute("model_atribut", "partner");

		Partner aa = new Partner();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
	      PttBrojevi km = new PttBrojevi();
	      List<PttBrojevi> deptList = zipCodesRepository.findAll(); 
	      
	    Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();
		
		for (PttBrojevi d : deptList) {
	          dept.put(d.getId(), d.getName());
	      }
	      sess.setAttribute("eDept", dept);	 
	      
		return new ModelAndView("partnerForm", "partner", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_partner.html", method = RequestMethod.POST)
	public String addTypeMeasure(@ModelAttribute("partner") @Valid Partner partner, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "partnerForm";
		}

		String rr = partner.getName();
		Long tt = partner.getId();
		
//		if (partner.getId() != null) {
//			PttBrojevi pttBrojevi = new PttBrojevi();
//			pttBrojevi.setPartner(partner);
//		}
		partnerRepository.save(partner);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_partner ", "/partner _new.html");
//		request.setAttribute("print_partner ", "/partner _pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Partners");
		model.addAttribute("new_partner", "/partner_new.html");
		model.addAttribute("print_partner", "/partner_pdf.html");

		return "redirect:partner.html";

	}
	
    
    @RequestMapping(value = "/update_partner.html")
	public String updateTypeMeasure(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("partner", partnerRepository.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update partner");	
		return "partnerForm";
	}
    

	@RequestMapping(value = "/delete_partner.html")
	public String deleteTypeMeasure(@RequestParam Long id, HttpServletRequest request) {

		partnerRepository.delete(id);

		return "redirect:partner.html";
	}
	
    @RequestMapping(path = "/partner_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypeMeasureReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", partnerRepository.findAllByOrderByIdDesc());
        params.put("title", "Partners - angular");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
