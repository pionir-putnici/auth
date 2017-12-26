package com.hellokoding.auth.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import com.example.model.Employee;
// import com.example.service.EmployeeService;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.VrstePaletaService;

@RestController
public class VrstePaletaRestController {
	
	@Autowired
	private VrstePaletaService vrstePaletaService;
	
//	@RequestMapping(path="/vrstepaleta", method=RequestMethod.GET)
//	public List<VrstePaleta> getAllEmployees(){
//		List<VrstePaleta> aa = vrstePaletaService.getAllVrstePaleta();
//	
//		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
//			VrstePaleta vrstePaleta = (VrstePaleta) iterator.next();
//			vrstePaleta.setAkcija("<a href=\"update-vrste-paleta.html?id=" + vrstePaleta.getUid() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
//					+ "            <a href=\"delete-vrste-paleta.html?id=" + vrstePaleta.getUid() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		}
////			vrstePaleta.setAkcija("<a href=\"update-vrste-paleta.html?id=" + vrstePaleta.getUid() + "\"> " + "<img src=\"http://www.ethicalsuperstore.com/images/icons/icon-parent-organic.png\" width=\"40\" height=\"30\" ></a>");
//
//
//
//
//		
//		return aa; // vrstePaletaService.getAllVrstePaleta();
//	}
//    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
//	public Employee getEmployeeById(@PathVariable("id") long id){
//		return employeeService.getEmployeeById(id);
//	}

}
