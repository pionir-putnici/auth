package com.hellokoding.auth.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.hellokoding.auth.dao.MagaciniDao;
import com.hellokoding.auth.dao.VrsteMagacinaDao;
//import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.VrsteMagacina;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.MagaciniService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;
// import com.mysql.jdbc.Connection;

@Controller
public class MagaciniController {
	
	@Autowired
	private MagaciniService magaciniService;
//	MagaciniService magaciniService = new MagaciniService();

	// @Autowired
	// private SecurityService securityService;

	@Autowired
	private MagaciniDao magaciniDao;
	
	@Autowired
	private VrsteMagacinaDao vrstemagacinaDao;

	@Autowired
	private CostumersRepository customersrepository;	
	
	@RequestMapping(value = "/magacini.html", method = RequestMethod.GET)
	public String helloForm(Model model) {
		model.addAttribute("tasks", magaciniDao.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "magacini");
		return "magaciniForm";
	}

	@RequestMapping(value = "/save-magacini.html", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("magacini") 
	@Valid Magacini magacini, 
			BindingResult result, Model model) { // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "magaciniUnosForm";
		}

//		if(id==1){
//			throw new EntityNotFoundException(id);
//			
			try {
				magaciniService.save(magacini);
			}
			catch (Exception e) {
				return "414";
			}
			
		// return "redirect:vrste-paleta.html"; 
		return "list-magacini"; 
	}

	@RequestMapping(value = "/new-magacini.html", method = RequestMethod.GET)
	public ModelAndView newTypePallet(HttpServletRequest request) { // HttpServletRequest request, Model model
		// model.addAttribute("tasks", vrstePaletaDao);
		// model.addAttribute("mode", "MODE_NEW");
		// model.addAttribute("title", "Type of pallets");
		// return "vrstePaletaUnosForm";
		
		Magacini aa = new Magacini();
		// da bi default aktivan bio checked
		aa.setAktivan(true);
		

		HttpSession sess = request.getSession();
//      System.out.println("Shashi");
      Map<Long, String> dept = new HashMap<>();
      Map<Long, String> deptpt = new HashMap<>();
      
      VrsteMagacina km = new VrsteMagacina();
      List<VrsteMagacina> deptList = vrstemagacinaDao.findAll(); 
      for (VrsteMagacina d : deptList) {
          dept.put(d.getId(), d.getName());
      }
      sess.setAttribute("eDept", dept);

      Partner pt = new Partner();
      List<Partner> ptList = customersrepository.findAll(); 
      for (Partner d : ptList) {
          deptpt.put(d.getId(), d.getName());
      }
      sess.setAttribute("eDeptPt", deptpt);      
      
		return new ModelAndView("magaciniUnosForm", "magacini", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}
	
//  
    @RequestMapping(value = "/update-magacini.html")
	public String updateTask(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("magacini", magaciniService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		
	      Map<Long, String> dept = new HashMap<>();
	      Map<Long, String> deptpt = new HashMap<>();
	  	  HttpSession sess = request.getSession();
	  	  
	      VrsteMagacina km = new VrsteMagacina();
	      List<VrsteMagacina> deptList = vrstemagacinaDao.findAll(); 
	      for (VrsteMagacina d : deptList) {
	          dept.put(d.getId(), d.getName());
	      }
	      sess.setAttribute("eDept", dept);

	      Partner pt = new Partner();
	      List<Partner> ptList = customersrepository.findAll(); 
	      for (Partner d : ptList) {
	          deptpt.put(d.getId(), d.getName());
	      }
	      sess.setAttribute("eDeptPt", deptpt);  		
		return "magaciniUnosForm";
	}
    
//	

	@RequestMapping(value = "/delete-magacini.html")
	public String deleteVrstePaleta(@RequestParam Long id, HttpServletRequest request) {
//      request.setAttribute("vrstePaleta", vrstePaletaDao.findByUid(id)); //  dao.getAllProdajeId("where id = " + sid));
//		vrstePaletaService.save(vrstePaleta);
		magaciniService.delete(id);
		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "magacini");
		// return "vrstePaletaForm";
		return "list-magacini";
	}
	
	public Map<String, String> vratiVrsteMagacina() {

        Map< String, String> kupci = new HashMap<>();
        
        kupci.put("1", "name");
        
//        try {
//            String query = "select * from kupac";
//            System.out.println(query);
//            Class.forName("com.mysql.jdbc.Driver");
//
//            try (Connection con = getDBConnection()) {
//                PreparedStatement preparedStatement = con.prepareStatement(query);
//                preparedStatement.executeQuery();
//                ResultSet rs = preparedStatement.executeQuery();
//                while (rs.next()) {
//                    kupci.put(rs.getString("id"), rs.getString("name"));
//                }
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            int i = 0;
//        }
        return kupci;
    }
	
}
