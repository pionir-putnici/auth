package com.hellokoding.auth.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

// import com.hellokoding.auth.dao.ArtikliDao;
// import com.hellokoding.auth.dao.VrsteArtikalaDao;
// import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.JediniceMera;
import com.hellokoding.auth.model.Klasifikacije;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.PoreskeGrupe;
import com.hellokoding.auth.model.VrsteArtikala;
import com.hellokoding.auth.repository.ArtikliRepository;
import com.hellokoding.auth.repository.DokumentStavkeRepository;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.VrsteArtikalaService;
import com.hellokoding.auth.service.ArtikliService;
import com.hellokoding.auth.service.JediniceMeraService;
import com.hellokoding.auth.service.KlasifikacijeService;
import com.hellokoding.auth.service.MagaciniService;
import com.hellokoding.auth.service.PoreskeGrupeService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;
// import com.mysql.jdbc.Connection;

@Controller
public class CardController {
	
	public ArrayList<Artikli> izabraneVrednostiArtikli = new ArrayList<Artikli>();
	public ArrayList<Magacini> izabraneVrednostiMagacini = new ArrayList<Magacini>();	
	@Autowired
	private ArtikliService artikliService;
	
	@Autowired
	private MagaciniService magaciniService;	
	
    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	
	@Autowired
	private DokumentStavkeRepository dokumentStavkeRepository;
	
	@Autowired
	private ArtikliRepository artikliRepository;
	
	@Autowired
	private MagaciniRepository magaciniRepository;	
	
//	ArtikliService artikliService = new ArtikliService();

	// @Autowired
	// private SecurityService securityService;

//	@Autowired
//	private ArtikliDao artikliDao;

	@Autowired
	private VrsteArtikalaService vrsteArtikalaService;

	@Autowired
	private PoreskeGrupeService poreskeGrupeService;
	
	@Autowired
	private KlasifikacijeService klasifikacijeService;
	
	@Autowired
	private JediniceMeraService jediniceMeraService;
	
//	@Autowired
//	private VrsteArtikalaDao vrsteartikalaDao;

	
    @RequestMapping(value = "/find_article_for_warehouse.html")
    // public String controllerMethod(@RequestParam(value="select2") List<Long> myParam,  HttpServletRequest request)
	 public String fafw(@RequestParam Long id_roba, @RequestParam Long id_magacin,  HttpServletRequest request)
    
    {
    	
    	System.out.print("Roba je: " + id_roba);    	
    	List<DokumentStavke> dd = dokumentStavkeRepository.findArticleInWarehouse(id_magacin, id_roba);
    	System.out.print(dd.toString());
    	// List<DokumentStavke> dd = dokumentStavkeRepository.findArticleInWarehouse(id_magacin, id_roba);
    	
		request.setAttribute("stavke", dd);
		request.setAttribute("title", "Update dokumentStavke");
		
		return ("/printing/card");
		
	}	
	

    @RequestMapping(value = "/find_all_articles.html")
	public String faa(HttpServletRequest request){
    	 	
		List<Artikli> dd = artikliRepository.findAllByOrderByNameAsc();
		System.out.println("Svi artikli " + dd.toString());
		List<Magacini> dd1 = magaciniRepository.findAllByOrderByNameAsc();
    	request.setAttribute("allArticles", dd);
    	request.setAttribute("allWarehouses", dd1);
		return ("cardForm");
		
	}	    

        

    @RequestMapping(value = "/add_article_session_parameter.html")
	public String asp(@RequestParam Long id_roba, HttpServletRequest request){
    	 	
//    	request.setAttribute("allArticles", dd);
//    	request.setAttribute("allWarehouses", dd1);
    	
		HttpSession sess = request.getSession();
        Map<Long, String> dept = new HashMap<>();
        
      Artikli km = new Artikli();
      Artikli deptList = artikliService.findByOne(id_roba); 
//      for (VrsteArtikala d : deptList) {
//          dept.put(d.getId(), d.getName());
//      }
      
      izabraneVrednostiArtikli.add(deptList);
      // dept.put(deptList.getId(), deptList.getCode() + "*" +  deptList.getName());
      sess.setAttribute("izabraneVrednostiArtikli", izabraneVrednostiArtikli);
      // request.setAttribute("izabraneVrednosti", izabraneVrednosti);
      
// 		return ("cardForm");
		return "redirect:find_all_articles.html";

		
	}    

    @RequestMapping(value = "/add_warehouse_session_parameter.html")
	public String awp(@RequestParam Long id_magacin, HttpServletRequest request){
    	 	
		HttpSession sess = request.getSession();
        Map<Long, String> dept = new HashMap<>();
        
      Magacini km = new Magacini();
      Magacini deptList = magaciniService.findByOne(id_magacin); 
//      for (VrsteArtikala d : deptList) {
//          dept.put(d.getId(), d.getName());
//      }
      
      izabraneVrednostiMagacini.add(deptList);
      // dept.put(deptList.getId(), deptList.getCode() + "*" +  deptList.getName());
      sess.setAttribute("izabraneVrednostiMagacini", izabraneVrednostiMagacini);
      // request.setAttribute("izabraneVrednosti", izabraneVrednosti);
      
// 		return ("cardForm");
		return "redirect:find_all_articles.html";

		
	}    
    
    
}
