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
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.repository.DokumentRepository;
import com.hellokoding.auth.repository.DokumentStavkeRepository;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.repository.TypesOfDocumentsRepository;

@Controller
public class DokumentController {
	@Autowired
	private DokumentRepository dokumentRepository;

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
	
	@Autowired
	private DokumentStavkeRepository dokumentStavkeRepository;
	
	@RequestMapping(value = "/dokument.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Dokuments");
		request.setAttribute("new_item", "/dokument_new.html");
		request.setAttribute("print_item", "/dokument_pdf.html");
		return "dokument";
	}	

	@RequestMapping(value = "/dokument_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model, HttpServletRequest request) { 
		model.addAttribute("title", "New dokument");
//		model.addAttribute("model_atribut", "dokument");

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
		      
	      
		return new ModelAndView("dokumentForm", "dokument", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_dokument.html", method = RequestMethod.POST)
	public String addTypeMeasure(@ModelAttribute("dokument") @Valid Dokument dokument, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "dokumentForm";
		}

//		String rr = dokument.getName();
		
		Long tt = dokument.getId();
		System.out.println("tt je  " + tt);
		
//		if (dokument.getId() != null) {
//			PttBrojevi pttBrojevi = new PttBrojevi();
//			pttBrojevi.setDokument(dokument);
//		}
		
		if (tt == null) {
		Long ww = dokumentRepository.max_za_vrstu_dokumenta(dokument.getTypesOfDocuments().getId());
		System.out.println(ww);
		if (ww == null) {
			ww=(long) 1;
		}
		
		dokument.setInterniBrojDokumenta(ww);
		}
		
		dokumentRepository.save(dokument);

//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Vrste artikala");
//		request.setAttribute("new_dokument ", "/dokument _new.html");
//		request.setAttribute("print_dokument ", "/dokument _pdf.html");
		
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Dokuments");
		model.addAttribute("new_dokument", "/dokument_new.html");
		model.addAttribute("print_dokument", "/dokument_pdf.html");

		return "redirect:dokument.html";

	}
	
    
    @RequestMapping(value = "/update_dokument.html")
	public String updateTypeMeasure(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("dokument", dokumentRepository.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update dokument");	
		
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
	      
		    // partner
		    Partner kmp = new Partner();
		      List<Partner> partList = partnerRepository.findAll(); 
		      
		    Map<Long, String> deptp = new HashMap<>();
			// HttpSession sess = request.getSession();
			
			for (Partner d : partList) {
		          deptp.put(d.getId(), d.getName());
		      }
		      sess.setAttribute("ePartner", deptp);	
		      
		return "dokumentForm";
	}
    

	@RequestMapping(value = "/delete_dokument.html")
	public String deleteTypeMeasure(@RequestParam Long id, HttpServletRequest request) {

		dokumentRepository.delete(id);

		return "redirect:dokument.html";
	}
	
    @RequestMapping(path = "/dokument_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypeMeasureReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", dokumentRepository.findAllByOrderByIdDesc());
        params.put("title", "Dokuments - angular");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }

    @RequestMapping(path = "/printing/printDocument.html", method = RequestMethod.GET)
    public ModelAndView printDocumentReport() {

    	
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       
        Map<String, Object> params = new HashMap<>();
        params.put("datasource", dokumentRepository.findAllByOrderByIdDesc());
        params.put("title", "Dokuments - angular");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
    

    	

    @RequestMapping(value="printDocument.html")
    public ModelAndView selectTag(@RequestParam Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/printing/printDocument");
         
        Dokument dokument = dokumentRepository.findOne(id);
        List<DokumentStavke> dokumentStavke = dokumentStavkeRepository.findByIdDokument(dokument);
        
        Map< String, String > phones = new HashMap<String, String>();
        phones.put("samsung", "SAMSUNG");
        phones.put("nokia", "NOKIA");
        phones.put("iphone", "IPHONE");
         
        mav.addObject("dokument", dokument);
        mav.addObject("dokumentStavke", dokumentStavke);
        
        // mav.addObject("smartphone", new Smartphone());
         
        return mav;    
    }
}