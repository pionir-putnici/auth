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
import com.hellokoding.auth.model.VrsteMagacina;
//import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.MagaciniService;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.VrsteMagacinaService;
import com.hellokoding.auth.service.VrsteMagacinaService;
import com.hellokoding.auth.service.VrstePaletaService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;

@Controller
public class TypesOfWarehouseController {
	
	@Autowired
	private MagaciniService magaciniService;
	
	@Autowired
	private VrsteMagacinaService vrsteMagacinaService;

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
	

	@RequestMapping(value = "/warehouse_types.html")
	public String WarehouseTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Types of warehouse");
		request.setAttribute("new_item", "/warehouse_types_new.html");
		request.setAttribute("print_item", "/warehouse_types_pdf.html");
		return "list-items";
	}	

	@RequestMapping(value = "/warehouse_types_new.html", method = RequestMethod.GET)
	public ModelAndView newTypeWarehouse(Model model) { 
		model.addAttribute("title", "New Type of warehouse");
//		model.addAttribute("model_atribut", "vrsteMagacina");

		VrsteMagacina aa = new VrsteMagacina();
		// da bi default aktivan bio checked
	    aa.setAktivan(true);
	    Date date = new Date();
	    aa.setTimestamp(date);
	    
		return new ModelAndView("vrsteMagacinaForm", "vrsteMagacina", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}	

	@RequestMapping(value = "/save-vrste-magacina.html", method = RequestMethod.POST)
	public String addTypeWarehouse(@ModelAttribute("vrsteMagacina") @Valid VrsteMagacina vrsteMagacina, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "vrsteMagacinaForm";
		}

		// have to load warehouses
		vrsteMagacina.setMagacini(magaciniService.getAllMagacini());
		
		vrsteMagacinaService.save(vrsteMagacina);

     	model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Type of warehouse");
		model.addAttribute("new_warehouse_types", "/warehouse_types_new.html");
		model.addAttribute("print_warehouse_types", "/warehouse_types_pdf.html");
		// return "redirect:vrste-paleta.html"; 
		return "list-items"; 
	}
	
	@RequestMapping(value = "/u-vrste-magacina.html", method = RequestMethod.POST)
	public String udTypeWarehouse(@ModelAttribute("vrsteMagacina") @Valid VrsteMagacina vrsteMagacina, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrsteMagacina.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "vrsteMagacinaForm";
		}

		vrsteMagacinaService.setVrsteMagacinaInfoById(vrsteMagacina.getCode(),
				vrsteMagacina.getName(), vrsteMagacina.getId());

     	model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Type of warehouse");
		model.addAttribute("new_warehouse_types", "/warehouse_types_new.html");
		model.addAttribute("print_warehouse_types", "/warehouse_types_pdf.html");
		// return "redirect:vrste-paleta.html"; 
		return "list-items"; 
	}	
	
//	@RequestMapping(value = "/vrste-magacina.html", method = RequestMethod.GET)
//	public String typesPaletsForm(Model model) {
//		VrstePaletaDao vrsteMagacinaDao = null;
//		model.addAttribute("tasks", vrsteMagacinaDao.findAll());
//		model.addAttribute("mode", "MODE_TASKS");
//		model.addAttribute("title", "Type of pallets");
//		return "vrstePaletaForm";
//	}
//
	
    
    @RequestMapping(value = "/update-vrste-magacina.html")
	public String updateTypeWarehouse(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("vrsteMagacina", vrsteMagacinaService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update Type of warehouse");
		
		return "vrsteMagacinaForm";
	}
    

	@RequestMapping(value = "/delete-vrste-magacina.html")
	public String deleteTypeWarehouse(@RequestParam Long id, HttpServletRequest request) {

		vrsteMagacinaService.delete(id);
//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("title", "Types of warehouse");
//		request.setAttribute("new_warehouse_types", "/warehouse_types_new.html");
//		request.setAttribute("print_warehouse_types", "/warehouse_types_pdf.html");
//		return "list-items";
		return "redirect:warehouse_types.html";
	}
	
    @RequestMapping(path = "/warehouse_types_pdf.html", method = RequestMethod.GET)
    public ModelAndView reportTypesofwarehouse() {
        
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", vrsteMagacinaService.getAllVrsteMagacina());
        params.put("title", "Types of warehouse");
        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
