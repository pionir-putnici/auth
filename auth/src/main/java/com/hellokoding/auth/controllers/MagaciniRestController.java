package com.hellokoding.auth.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import com.example.model.Employee;
// import com.example.service.EmployeeService;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.service.MagaciniService;

@RestController
public class MagaciniRestController {
	
	@Autowired
	private MagaciniService magaciniService;
	
	@RequestMapping(path="/magacini", method=RequestMethod.GET)
	public List<Magacini> getAllMagacini(){
		
		List<Magacini> aa = (List<Magacini>) magaciniService.findMagacinisWithoutRelations();
		
//		List<Magacini> aa = magaciniService.getAllMagacini();
//	
//		 for (Iterator<Magacini> iterator = aa.iterator(); iterator.hasNext();) {
//			Magacini magacini = (Magacini) iterator.next();
//			System.out.println(magacini.getVrsteMagacina().getName());
//			System.out.println(magacini.getName());
//			System.out.println(magacini.getVrste_magacina_naziv());
//			magacini.setAkcija("<a href=\"update-magacini.html?id=" + magacini.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
//					+ "            <a href=\"delete-magacini.html?id=" + magacini.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		}
		

//		List<Magacini> cusList = new ArrayList<Magacini>();
//
//		for(Object o: aa){        
//		    cusList.add((Magacini)o);        
//		}
//
//		return cusList; 
//		List<Object> aab = (List<Object>) magaciniService.findMagacinisWithoutRelations();
//	
//		List<Magacini> cusList = new ArrayList<Magacini>();
//
//		
		 for (Iterator<Magacini> iterator = aa.iterator(); iterator.hasNext();) {
			 
			Magacini magacini = iterator.next();
//			System.out.println(magacini.getVrsteMagacina().getName());
//			System.out.println(magacini.getName());
//			System.out.println(magacini.getVrste_magacina_naziv());
			magacini.setVrste_magacina_naziv(magacini.getVrsteMagacina().getName());
			magacini.setAkcija("<a href=\"update-magacini.html?id=" + magacini.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-magacini.html?id=" + magacini.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
		}	
		
//		Magacini m = new Magacini();
//		m=magaciniService.findByOne(1L);
//		m.setAkcija("<a href=\"update-magacini.html?id=" + m.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
//				+ "            <a href=\"delete-magacini.html?id=" + m.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		aa.set(0, m);
		 
		return aa; // vrstePaletaService.getAllVrstePaleta();
		

//		for (int i = 0; i < aab.size(); i++) {
//			System.out.println(aab.get(i));
//		}
//		
//		return aab; // vrstePaletaService.getAllVrstePaleta();
	}
//    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
//	public Employee getEmployeeById(@PathVariable("id") long id){
//		return employeeService.getEmployeeById(id);
//	}

}
