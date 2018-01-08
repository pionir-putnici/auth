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
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.repository.DokumentRepository;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.repository.TypesOfDocumentsRepository;

@Controller
public class DokumentStavkeController {
	@Autowired
	private DokumentRepository dokumentStavkeRepository;

	@Autowired
	private MagaciniRepository magaciniRepository;

	@Autowired
	private CostumersRepository partnerRepository;
	
	@Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	
	@Autowired
	private TypesOfDocumentsRepository typesOfDocumentsRepository;
	
	
	
	@RequestMapping(value = "/dokumentStavke.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Dokument Items");
		request.setAttribute("new_item", "/dokumentStavke_new.html");
		request.setAttribute("print_item", "/dokumentStavke_pdf.html");
		return "dokumentStavke";
	}	

	@RequestMapping(value = "/dokumentStavke_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model, HttpServletRequest request) { 
		model.addAttribute("title", "New dokumentStavke");
//		model.addAttribute("model_atribut", "dokumentStavke");

		Dokument aa = new Dokument();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setDatumVreme(date);

	    // partner
	    Partner kmp = new Partner();
	      List<Partner> partList = partnerRepository.findAll(); 
	      
	    Map<Long, String> deptp = new HashMap<>();
		HttpSession sess = request.getSession();
		
		for (Partner d : partList) {
	          deptp.put(d.getId(), d.getName());
	      }
	      sess.setAttribute("ePartner", deptp);	
	      
	    // magacini
	    Magacini km = new Magacini();
	      List<Magacini> deptList = magaciniRepository.findAll(); 
	      
	    Map<Long, String> dept = new HashMap<>();
//		HttpSession sess = request.getSession();
		
		for (Magacini d : deptList) {
	          dept.put(d.getId(), d.getName());
	      }
	      sess.setAttribute("eMagacini", dept);	 
	      
	      // Vrste dokumenata
	      // TypesOfDocuments km = new TypesOfDocuments();
		    List<TypesOfDocuments> tdList = typesOfDocumentsRepository.findAll(); 

		    Map<Long, String> tdl = new HashMap<>();
			
			for (TypesOfDocuments d : tdList) {
		          tdl.put(d.getId(), d.getName());
		      }
		      sess.setAttribute("eTypesOfDocuments", tdl);	 
		      
	      
		return new ModelAndView("dokumentStavkeForm", "dokumentStavke", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_dokumentStavke.html", method = RequestMethod.POST)
	public String addTypeMeasure(@ModelAttribute("dokumentStavke") @Valid Dokument dokumentStavke, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "dokumentStavkeForm";
		}

//		String rr = dokumentStavke.getName();
		Long tt = dokumentStavke.getId();
		
//		if (dokumentStavke.getId() != null) {
//			PttBrojevi pttBrojevi = new PttBrojevi();
//			pttBrojevi.setDokument(dokumentStavke);
//		}
		dokumentStavkeRepository.save(dokumentStavke);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_dokumentStavke ", "/dokumentStavke _new.html");
//		request.setAttribute("print_dokumentStavke ", "/dokumentStavke _pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Dokument Items");
		model.addAttribute("new_dokumentStavke", "/dokumentStavke_new.html");
		model.addAttribute("print_dokumentStavke", "/dokumentStavke_pdf.html");

		return "redirect:dokumentStavke.html";

	}
	
    
    @RequestMapping(value = "/update_dokumentStavke.html")
	public String updateTypeMeasure(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("dokumentStavke", dokumentStavkeRepository.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update dokumentStavke");	
		
		Magacini km = new Magacini();
	      List<Magacini> deptList = magaciniRepository.findAll(); 
	      
	    Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();
		
		for (Magacini d : deptList) {
	          dept.put(d.getId(), d.getName());
	      }
	      sess.setAttribute("eMagacini", dept);	 
	      
	      List<TypesOfDocuments> tdList = typesOfDocumentsRepository.findAll(); 	      
		    Map<Long, String> tdl = new HashMap<>();
			
		for (TypesOfDocuments d : tdList) {
		          tdl.put(d.getId(), d.getName());
		      }
	      sess.setAttribute("eTypesOfDocuments", tdl);	 
	      
	      
		return "dokumentStavkeForm";
	}
    

	@RequestMapping(value = "/delete_dokumentStavke.html")
	public String deleteTypeMeasure(@RequestParam Long id, HttpServletRequest request) {

		dokumentStavkeRepository.delete(id);

		return "redirect:dokumentStavke.html";
	}
	
    @RequestMapping(path = "/dokumentStavke_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypeMeasureReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", dokumentStavkeRepository.findAllByOrderByIdDesc());
        params.put("title", "Dokument Items - angular");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
