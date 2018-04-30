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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.repository.TypesOfDocumentsRepository;



@Controller
public class TypesOfDocumentsController {
	@Autowired
	private TypesOfDocumentsRepository typesOfDocumentsRepository;


	
    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	

	@RequestMapping(value = "/typesOfDocuments.html")
	public String typesOfDocuments1(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Type of Documents");
		request.setAttribute("new_item", "/typesOfDocuments_new.html");
		request.setAttribute("print_item", "/typesOfDocuments_pdf.html");
		
		return "typesOfDocuments";
	}	

	@RequestMapping(value = "/typesOfDocuments_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model, HttpServletRequest request) { 
		model.addAttribute("title", "New typesOfDocuments");
//		model.addAttribute("model_atribut", "typesOfDocuments");

		TypesOfDocuments aa = new TypesOfDocuments();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date); 
	    
		return new ModelAndView("typesOfDocumentsForm", "typesOfDocuments", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save_typesOfDocuments.html", method = RequestMethod.POST)
	public String addTypetypeOfDocuments(@ModelAttribute("typesOfDocuments") @Valid TypesOfDocuments typesOfDocuments, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "typesOfDocumentsForm";
		}

		typesOfDocumentsRepository.save(typesOfDocuments);


		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Type of Documents");
		model.addAttribute("new_typesOfDocuments", "/typesOfDocuments_new.html");
		model.addAttribute("print_typesOfDocuments", "/typesOfDocuments_pdf.html");

		return "redirect:typesOfDocuments.html";

	}
	
    
    @RequestMapping(value = "/update_typesOfDocuments.html")
	public ModelAndView updateTypetypeOfDocuments(@RequestParam Long id, HttpServletRequest request){
    	
    	ModelAndView mav = new ModelAndView("typesOfDocumentsForm");
    	
        Map< String, String > phones = new HashMap<String, String>();
        phones.put("samsung", "SAMSUNG");
        phones.put("nokia", "NOKIA");
        phones.put("iphone", "IPHONE");
         
        mav.addObject("phonesMap", phones);
        mav.addObject("typesOfDocuments", typesOfDocumentsRepository.findOne(id));
        mav.addObject("mode", "MODE_UPDATE");
        mav.addObject("title", "Update typesOfDocuments");
                
//		request.setAttribute("typesOfDocuments", typesOfDocumentsRepository.findOne(id));
//		request.setAttribute("mode", "MODE_UPDATE");
//		request.setAttribute("title", "Update typesOfDocuments");	
		
//		Magacini km = new Magacini();
//	      List<Magacini> deptList = magaciniRepository.findAll(); 
	      
	    Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();
		
//		for (Magacini d : deptList) {
//	          dept.put(d.getId(), d.getName());
//	      }
		
		dept.put(1L,"Ulaz");
		dept.put(2L,"Izlaz");
	    sess.setAttribute("eStrana", dept);	 		
		
		
		return mav;
	}
    
//    @ControllerAdvice
//    class GlobalControllerExceptionHandler {
//   //     @ResponseStatus(HttpStatus.CONFLICT)  // 409
//        @ExceptionHandler(DataIntegrityViolationException.class)
//        public void handleConflict() {
//        	redirect:404.html;
//        }
//    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
   //   logger.error("Request: " + req.getRequestURL() + " raised " + ex);

      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", ex);
      mav.addObject("url", req.getRequestURL());
      mav.setViewName("error");
      return mav;
    }
    
	@RequestMapping(value = "/delete_typesOfDocuments.html")
	public String deleteTypeDocuments(@RequestParam Long id, HttpServletRequest request) {

		try {
			typesOfDocumentsRepository.delete(id);
		}
		catch (Exception ex)
		{
//			request.setAttribute("error", "Greska");
//		      ModelAndView mav = new ModelAndView();
//		      mav.addObject("exception", ex);
//		      mav.addObject("url", req.getRequestURL());
//		      mav.setViewName("error");
//		      return mav;
		      return "redirect:414.html";
		}
		
		return "redirect:typesOfDocuments.html";
	}
	
    @RequestMapping(path = "/typesOfDocuments_pdf.html", method = RequestMethod.GET)
    public ModelAndView printTypetypeOfDocumentsReport() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", typesOfDocumentsRepository.findAllByOrderByIdDesc());
        params.put("title", "Type of Documents");

        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
