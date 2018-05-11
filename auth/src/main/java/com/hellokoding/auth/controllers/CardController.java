package com.hellokoding.auth.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

	// ArtikliService artikliService = new ArtikliService();

	// @Autowired
	// private SecurityService securityService;

	// @Autowired
	// private ArtikliDao artikliDao;

	@Autowired
	private VrsteArtikalaService vrsteArtikalaService;

	@Autowired
	private PoreskeGrupeService poreskeGrupeService;

	@Autowired
	private KlasifikacijeService klasifikacijeService;

	@Autowired
	private JediniceMeraService jediniceMeraService;

	// @Autowired
	// private VrsteArtikalaDao vrsteartikalaDao;

	@RequestMapping(value = "/find_article_for_warehouse.html")

	// public String fafw(@RequestParam Long id_roba, @RequestParam Long id_magacin,
	// @RequestParam String action, HttpServletRequest request)
	
	public String fafw(@RequestParam String action, 
//			@RequestParam(value = "select2") Optional<String[]> select2,
//			@RequestParam(value = "select1") Optional<String[]> select1,			
			@RequestParam (value="select2", required=false) String[] select2,
			@RequestParam (value="select1", required=false) String[] select1,	
			@RequestParam (value="oddana", required=false) String oddana,
			@RequestParam (value="dodana", required=false) String dodana,			
//          @RequestParam String[] select1 , 
			HttpServletRequest request)

	{
		
		HttpSession session = request.getSession();
		
		if (action.equals("cancel-warehouse")) {
			
			List<Magacini> aa = (List<Magacini>) session.getAttribute("izabraneVrednostiMagacini");


			int count = 0;

			try {

				for (String mId : select1) {

					Long mIdl = Long.parseLong(mId);
					count = 0;
					for (Magacini magacini : aa) {

						if (magacini.getId().equals(mIdl)) { // == mIdl
							// aa.remove(artikli);
							aa.remove(count);
							// artikli.setAktivan(false);
						}

						count++;
					}

				}

			} catch (Exception x) {

			}

			System.out.println("Ispis bez uklonjenog" + aa.toString());

			return "redirect:find_all_articles.html";

		} else if (action.equals("cancel-article")) {

			// System.out.print("cancel article");
			// System.out.print(select2);
			// System.out.println(Arrays.toString(select2));
			//

			// Enumeration e = (Enumeration) (session.getAttributeNames());
			//
			// while ( e.hasMoreElements())
			// {
			// Object tring;
			// if((tring = e.nextElement())!=null)
			// {
			// System.out.println(e.toString());
			// System.out.println(session.getValue((String) tring));
			// System.out.println("<br/>");
			// }
			//
			// }

			List<Artikli> aa = (List<Artikli>) session.getAttribute("izabraneVrednostiArtikli");

			System.out.println(aa.toString());

			int count = 0;

			try {

				for (String mId : select2) {

					Long mIdl = Long.parseLong(mId);
					count = 0;
					for (Artikli artikli : aa) {

						if (artikli.getId().equals(mIdl)) { // == mIdl
							// aa.remove(artikli);
							aa.remove(count);
							// artikli.setAktivan(false);
						}

						count++;
					}

				}

			} catch (Exception x) {

			}

			System.out.println("Ispis bez uklonjenog" + aa.toString());

			return "redirect:find_all_articles.html";
			
		} else if (action.equals("main-submit")) {
			
			request.setAttribute("title", "Update dokumentStavke");
			request.setAttribute("oddana", oddana);
			request.setAttribute("dodana", dodana);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			request.setAttribute("currentdate", dateFormat.format(date));

			List<Magacini> magkart = (List<Magacini>) session.getAttribute("izabraneVrednostiMagacini");
			request.setAttribute("magkart", magkart);

			List<Artikli> artkart = (List<Artikli>) session.getAttribute("izabraneVrednostiArtikli");
			request.setAttribute("artkart", artkart);
			
			String conditions = null;
			boolean firstTime= true;
			
			for (Magacini magacini : magkart) {
				
				if (firstTime) {
					
				conditions = " magacin IN (" + (magacini.getId());
				}
				else
				{
				conditions = " AND " + 	(magacini.getId());
				}
				
				firstTime=false;
								
				}
			
			conditions = conditions + ")";
			
//			for (Artikli artikli  : artkart) {
//				String conditions = null;
//				List<DokumentStavke> stavkart = dokumentStavkeRepository.upitKonacni(conditions);	
//				request.setAttribute("stavkart", stavkart);
//				return ("/printing/card");

			
			}
			
			// return ("/printing/card");
			
		// }

		return ("/printing/card");
		
		// System.out.print("Roba je: " + id_roba);
		// List<DokumentStavke> dd =
		// dokumentStavkeRepository.findArticleInWarehouse(id_magacin, id_roba);
		// System.out.print(dd.toString());

		// request.setAttribute("stavke", dd);

	}

	@RequestMapping(value = "/find_all_articles.html")
	public String faa(HttpServletRequest request) {

		List<Artikli> dd = artikliRepository.findAllByOrderByNameAsc();
		System.out.println("Svi artikli " + dd.toString());
		List<Magacini> dd1 = magaciniRepository.findAllByOrderByNameAsc();
		request.setAttribute("allArticles", dd);
		request.setAttribute("allWarehouses", dd1);
		return ("cardForm");

	}

	@RequestMapping(value = "/add_article_session_parameter.html")
	public String asp(@RequestParam Long id_roba, HttpServletRequest request) {

		// request.setAttribute("allArticles", dd);
		// request.setAttribute("allWarehouses", dd1);

		HttpSession sess = request.getSession();
		Map<Long, String> dept = new HashMap<>();

		Artikli km = new Artikli();
		Artikli deptList = artikliService.findByOne(id_roba);
		// for (VrsteArtikala d : deptList) {
		// dept.put(d.getId(), d.getName());
		// }

		izabraneVrednostiArtikli.add(deptList);
		// dept.put(deptList.getId(), deptList.getCode() + "*" + deptList.getName());
		sess.setAttribute("izabraneVrednostiArtikli", izabraneVrednostiArtikli);
		// request.setAttribute("izabraneVrednosti", izabraneVrednosti);

		// return ("cardForm");
		return "redirect:find_all_articles.html";

	}

	@RequestMapping(value = "/add_warehouse_session_parameter.html")
	public String awp(@RequestParam Long id_magacin, HttpServletRequest request) {

		HttpSession sess = request.getSession();
		Map<Long, String> dept = new HashMap<>();

		Magacini km = new Magacini();
		Magacini deptList = magaciniService.findByOne(id_magacin);
		// for (VrsteArtikala d : deptList) {
		// dept.put(d.getId(), d.getName());
		// }

		izabraneVrednostiMagacini.add(deptList);
		// dept.put(deptList.getId(), deptList.getCode() + "*" + deptList.getName());
		sess.setAttribute("izabraneVrednostiMagacini", izabraneVrednostiMagacini);
		// request.setAttribute("izabraneVrednosti", izabraneVrednosti);

		// return ("cardForm");
		return "redirect:find_all_articles.html";

	}

}
