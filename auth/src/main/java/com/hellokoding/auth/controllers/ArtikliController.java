package com.hellokoding.auth.controllers;

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
import com.hellokoding.auth.model.JediniceMera;
import com.hellokoding.auth.model.Klasifikacije;
import com.hellokoding.auth.model.PoreskeGrupe;
import com.hellokoding.auth.model.VrsteArtikala;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.VrsteArtikalaService;
import com.hellokoding.auth.service.ArtikliService;
import com.hellokoding.auth.service.JediniceMeraService;
import com.hellokoding.auth.service.KlasifikacijeService;
import com.hellokoding.auth.service.PoreskeGrupeService;
import com.hellokoding.auth.validator.UserValidator;
import com.hellokoding.auth.validator.VrstePaletaValidator;
// import com.mysql.jdbc.Connection;

@Controller
public class ArtikliController {
	
	@Autowired
	private ArtikliService artikliService;
	
    @Autowired
    private ApplicationContext appContext;
    
	@Autowired
	private CompanyDetails companyDetails;
	
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

	
	@RequestMapping(value = "/list-artikli.html", method = RequestMethod.GET)
	public String articliForm(Model model) {
		model.addAttribute("tasks", artikliService.getAllArtikli());
		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Artikli");
		return "list-artikli";
	}

	@RequestMapping(value = "/save-artikli.html", method = RequestMethod.POST)
	public String addArtikli(@ModelAttribute("artikli") 
	@Valid Artikli artikli, BindingResult result, Model model) 
	
	{ // , @PathVariable int aktivan

//        if (aktivan == 1) {
//        	vrstePaleta.setAktivan(true);
//        } else {
//        	vrstePaleta.setAktivan(false);
//        }
        
		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "artikliUnosForm";
		}

		artikliService.save(artikli);
		// return "redirect:vrste-paleta.html"; /list-artikli.html
		return "list-artikli"; 
	}

	@RequestMapping(value = "/new-artikli.html", method = RequestMethod.GET)
	public ModelAndView newArtikli(HttpServletRequest request) { // HttpServletRequest request, Model model
		// model.addAttribute("tasks", vrstePaletaDao);
		// model.addAttribute("mode", "MODE_NEW");
		// model.addAttribute("title", "Type of pallets");
		// return "vrstePaletaUnosForm";
		
		Artikli aa = new Artikli();
		// da bi default aktivan bio checked
		aa.setAktivan(true);
		

		HttpSession sess = request.getSession();		
        Map<Long, String> dept = new HashMap<>();
  
      
      VrsteArtikala km = new VrsteArtikala();
      List<VrsteArtikala> deptList = vrsteArtikalaService.getAllVrsteArtikala(); 
      for (VrsteArtikala d : deptList) {
          dept.put(d.getId(), d.getName());
      }
      sess.setAttribute("eDept", dept);
      
      Map<Long, String> pgm = new HashMap<>(); 
      PoreskeGrupe pg = new PoreskeGrupe();
      List<PoreskeGrupe> pgList = poreskeGrupeService.getAllPoreskeGrupe(); 
      for (PoreskeGrupe d : pgList) {
          pgm.put(d.getId(), d.getName());
      }
      sess.setAttribute("ePg", pgm);
      
      Map<Long, String> pjm = new HashMap<>(); 
      JediniceMera pj = new JediniceMera();
      List<JediniceMera> pjmList = jediniceMeraService.getAllJediniceMera(); 
      for (JediniceMera d : pjmList) {
          pjm.put(d.getId(), d.getName());
      }
      sess.setAttribute("ePjm", pjm);
      
      Map<Long, String> pkl = new HashMap<>(); 
      Klasifikacije pk = new Klasifikacije();
      List<Klasifikacije> pklList = klasifikacijeService.getAllKlasifikacije(); // .getAllKlasifikacijeOrderByCode();
      for (Klasifikacije d : pklList) {
          pkl.put(d.getId(), d.getName());
      }
      sess.setAttribute("ePkl", pkl);     
      
		return new ModelAndView("artikliUnosForm", "artikli", aa);
		// return new ModelAndView("vrstePaletaUnosForm", "vrstePaleta", new VrstePaleta());
	}
	
//  
    @RequestMapping(value = "/update-artikli.html")
	public String updateArtikli(@RequestParam Long id, HttpServletRequest request){
		request.setAttribute("artikli", artikliService.findByOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		
		HttpSession sess = request.getSession();		
        Map<Long, String> dept = new HashMap<>();
  
      
      VrsteArtikala km = new VrsteArtikala();
      List<VrsteArtikala> deptList = vrsteArtikalaService.getAllVrsteArtikala(); 
      for (VrsteArtikala d : deptList) {
          dept.put(d.getId(), d.getName());
      }
      sess.setAttribute("eDept", dept);
      
      Map<Long, String> pgm = new HashMap<>(); 
      PoreskeGrupe pg = new PoreskeGrupe();
      List<PoreskeGrupe> pgList = poreskeGrupeService.getAllPoreskeGrupe(); 
      for (PoreskeGrupe d : pgList) {
          pgm.put(d.getId(), d.getName());
      }
      sess.setAttribute("ePg", pgm);
      
      Map<Long, String> pjm = new HashMap<>(); 
      JediniceMera pj = new JediniceMera();
      List<JediniceMera> pjmList = jediniceMeraService.getAllJediniceMera(); 
      for (JediniceMera d : pjmList) {
          pjm.put(d.getId(), d.getName());
      }
      sess.setAttribute("ePjm", pjm);
      
      Map<Long, String> pkl = new HashMap<>(); 
      Klasifikacije pk = new Klasifikacije();
      List<Klasifikacije> pklList = klasifikacijeService.getAllKlasifikacije(); // .getAllKlasifikacijeOrderByCode();
      for (Klasifikacije d : pklList) {
          pkl.put(d.getId(), d.getName());
      }
      sess.setAttribute("ePkl", pkl);     				
		
	  return "artikliUnosForm";
	}
    
//	
    
@PreAuthorize("hasAnyRole('ADMIN')")
    
	@RequestMapping(value = "/delete-artikli.html")
	public String deleteArtikli(@RequestParam Long id, HttpServletRequest request) {
//      request.setAttribute("vrstePaleta", vrstePaletaDao.findByUid(id)); //  dao.getAllProdajeId("where id = " + sid));
//		vrstePaletaService.save(vrstePaleta);
 //      	boolean tt = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
      	Authentication tt1 = SecurityContextHolder.getContext().getAuthentication();
Collection<? extends GrantedAuthority> qq = tt1.getAuthorities();
       	//    	if (principal instanceof User) {
//    		return ((User) principal).getUsername();
//    	}
//    	return principal.toString();
		artikliService.delete(id);
		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Artikli");
		// return "vrstePaletaForm";
		return "redirect:list-artikli.html"; //list-artikli.html
		// return "list-artikli";
	}
	
	public Map<String, String> vratiVrsteArtikala() {

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
	
    @RequestMapping(path = "/artikli_pdf.html", method = RequestMethod.GET)
    public ModelAndView reportPoreskeGrupe() {
        
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Items1.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", artikliService.getAllArtikli());
        params.put("title", "Artikli");
        params.put("company",  companyDetails.companyDetails1);
        params.put("adress",  companyDetails.companyDetails2);
        params.put("city",  companyDetails.companyDetails3);
        return new ModelAndView(view, params);
    }
	
}
