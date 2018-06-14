package com.hellokoding.auth.controllers;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.PoreskeGrupe;
import com.hellokoding.auth.model.SumMagacinArtikal;
import com.hellokoding.auth.model.VrsteArtikala;
import com.hellokoding.auth.repository.ArtikliRepository;
import com.hellokoding.auth.repository.CostumersRepository;
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
	public ArrayList<Partner> izabraneVrednostiPartneri = new ArrayList<Partner>();	
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

	@Autowired
	private CostumersRepository costumerRepository;
	
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
			// @RequestParam(value = "select2") Optional<String[]> select2,
			// @RequestParam(value = "select1") Optional<String[]> select1,

			@RequestParam(value = "select2", required = false) String[] select2,
			@RequestParam(value = "select1", required = false) String[] select1,
			@RequestParam(value = "oddana", required = false) String oddana,
			@RequestParam(value = "dodana", required = false) String dodana,
			// @RequestParam String[] select1 ,
			HttpServletRequest request
//			BindingResult result, Model model
			)

	{

		HttpSession session = request.getSession();

		if (action.equals("cancel-warehouse")) {

			try {
				if (select1.length == 0) {
					return "redirect:find_all_articles.html";
				}

			} catch (Exception x) {
				
//				String s = "Hi";
//				Object a =s;
//				
//				result.addError((ObjectError) a);
//				
//				if (result.hasErrors()) {
//					model.addAttribute("error", "error");
//					return "redirect:find_all_articles.html";
//				}		
				

				
				String ev="Odaberite magacin ....";
				session.setAttribute("ev", ev);				
				
				return "redirect:find_all_articles.html";
			}

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
		}
			else if (action.equals("cancel-partner")) {

				try {
					if (select1.length == 0) {
						return "redirect:find_all_articles_partners.html";
					}

				} catch (Exception x) {
					
//					String s = "Hi";
//					Object a =s;
//					
//					result.addError((ObjectError) a);
//					
//					if (result.hasErrors()) {
//						model.addAttribute("error", "error");
//						return "redirect:find_all_articles.html";
//					}		
					

					
					String ev="Odaberite magacin ....";
					session.setAttribute("ev", ev);				
					
					return "redirect:find_all_articles_partners.html";
				}

				List<Partner> aa = (List<Partner>) session.getAttribute("izabraneVrednostiPartneri");

				int count = 0;

				try {

					for (String mId : select1) {

						Long mIdl = Long.parseLong(mId);
						count = 0;
						for (Partner magacini : aa) {

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

				return "redirect:find_all_articles_partners.html";						
			
		} else if (action.equals("cancel-article")) {

			try {
				if (select2.length == 0) {
					return "redirect:find_all_articles.html";
				}

			} catch (Exception x) {
				String ev="Odaberite artikal ....";
				session.setAttribute("ev", ev);				
				return "redirect:find_all_articles.html";
			}

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

		} else if (action.equals("cancel-articlep")) {

			try {
				if (select2.length == 0) {
					return "redirect:find_all_articles_partners.html";
				}

			} catch (Exception x) {
				String ev="Odaberite artikal ....";
				session.setAttribute("ev", ev);				
				return "redirect:find_all_articles_partners.html";
			}

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

			return "redirect:find_all_articles_partners.html";			
			
		} else if (action.equals("main-submit")) {

			try {
				if (select1.length == 0) {
					return "redirect:find_all_articles.html";
				}
				if (select2.length == 0) {
					String ev="Popunite polje artikli ....";
					session.setAttribute("ev", ev);	
					return "redirect:find_all_articles.html";
				}
				if (oddana.isEmpty()) {
					String ev="Popunite polje od dana ....";
					session.setAttribute("ev", ev);	
					return "redirect:find_all_articles.html";
				}
				if (dodana.isEmpty()) {
					String ev="Popunite polje do dana ....";
					session.setAttribute("ev", ev);	
					return "redirect:find_all_articles.html";
				}

			} catch (Exception x) {
				String ev="Popunite obavezna polja  ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles.html";
			}

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

			List<Long> ids_magacin = new ArrayList<Long>(); // this should be your id column's type

			for (Magacini magacini : magkart) {
				ids_magacin.add(magacini.getId());
			}

			List<Long> ids_artikli = new ArrayList<Long>(); // this should be your id column's type

			for (Artikli artikli : artkart) {
				ids_artikli.add(artikli.getId());
			}

			TreeMap<Integer, SumMagacinArtikal> kontrola = new TreeMap<>();
			kontrola.put(1, new SumMagacinArtikal(new Long(1), new Long(15), new Long(7), new BigDecimal(10.00)));

			System.out.println("Kontrola " + kontrola);
			request.setAttribute("kontrola", kontrola);
			
			System.out.println("Datum string je " + oddana);
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date oddanad = null;
			try {
				oddanad = formatter.parse(oddana);
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			Date dodanad = null;
			try {
				dodanad = formatter.parse(dodana);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Datum date je " + oddanad + " " + dodanad);
			
			List<DokumentStavke> stavkart = dokumentStavkeRepository.k1(ids_magacin, ids_artikli, oddanad, dodanad);

			// List<DokumentStavke> stavkart = dokumentStavkeRepository.k2(ids_magacin, ids_artikli, oddana, dodana);
			
//			LocalDate t = LocalDate.now();
//			List<DokumentStavke> stavkart = dokumentStavkeRepository.k3(ids_magacin, ids_artikli, t, t);			
			
			System.out.println("Stavka kard " + stavkart);

			
			request.setAttribute("stavkart", stavkart);
			
			return ("/printing/card");

			// String conditions = null;
			// boolean firstTime= true;
			//
			// for (Magacini magacini : magkart) {
			//
			// if (firstTime) {
			//
			// conditions = " magacin IN (" + (magacini.getId());
			// }
			// else
			// {
			// conditions = " AND " + (magacini.getId());
			// }
			//
			// firstTime=false;
			//
			// }
			//
			// conditions = conditions + ")";

			// for (Artikli artikli : artkart) {
			// String conditions = null;
			// List<DokumentStavke> stavkart =
			// dokumentStavkeRepository.upitKonacni(conditions);
			// request.setAttribute("stavkart", stavkart);
			// return ("/printing/card");

		}

		
		
		
	 else if (action.equals("main-submit-artical-partner")) {

		try {
			if (select1.length == 0) {
				return "redirect:find_all_articles_partners.html";
			}
			if (select2.length == 0) {
				String ev="Popunite polje artikli ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles_partners.html";
			}
			if (oddana.isEmpty()) {
				String ev="Popunite polje od dana ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles_partners.html";
			}
			if (dodana.isEmpty()) {
				String ev="Popunite polje do dana ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles_partners.html";
			}

		} catch (Exception x) {
			String ev="Popunite obavezna polja  ....";
			session.setAttribute("ev", ev);	
			return "redirect:find_all_articles_partners.html";
		}

		request.setAttribute("title", "Update dokumentStavke");
		request.setAttribute("oddana", oddana);
		request.setAttribute("dodana", dodana);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		request.setAttribute("currentdate", dateFormat.format(date));

		List<Partner> magkart = (List<Partner>) session.getAttribute("izabraneVrednostiPartneri");
		request.setAttribute("magkart", magkart);
		
		List<Artikli> artkart = (List<Artikli>) session.getAttribute("izabraneVrednostiArtikli");
		request.setAttribute("artkart", artkart);
		
		

		List<Long> ids_magacin = new ArrayList<Long>(); // this should be your id column's type

		for (Partner magacini : magkart) {
			ids_magacin.add(magacini.getId());
		}

		List<Long> ids_artikli = new ArrayList<Long>(); // this should be your id column's type

		for (Artikli artikli : artkart) {
			ids_artikli.add(artikli.getId());
		}

		TreeMap<Integer, SumMagacinArtikal> kontrola = new TreeMap<>();
		kontrola.put(1, new SumMagacinArtikal(new Long(1), new Long(15), new Long(7), new BigDecimal(10.00)));

		System.out.println("Kontrola " + kontrola);
		request.setAttribute("kontrola", kontrola);
		
		System.out.println("Datum string je " + oddana);
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date oddanad = null;
		try {
			oddanad = formatter.parse(oddana);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		Date dodanad = null;
		try {
			dodanad = formatter.parse(dodana);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Datum date je " + oddanad + " " + dodanad);
		
		List<DokumentStavke> stavkart = dokumentStavkeRepository.k1p(ids_magacin, ids_artikli, oddanad, dodanad);

		// List<DokumentStavke> stavkart = dokumentStavkeRepository.k2(ids_magacin, ids_artikli, oddana, dodana);
		
//		LocalDate t = LocalDate.now();
//		List<DokumentStavke> stavkart = dokumentStavkeRepository.k3(ids_magacin, ids_artikli, t, t);			
		
		System.out.println("Stavka kard " + stavkart);

		
		request.setAttribute("stavkart", stavkart);
		
		return ("/printing/cardp");
	}		
	 else if (action.equals("main-submit-artical-partner-magacin")) {

		try {
			if (select1.length == 0) {
				return "redirect:find_all_articles_partners.html";
			}
			if (select2.length == 0) {
				String ev="Popunite polje artikli ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles_partners.html";
			}
			if (oddana.isEmpty()) {
				String ev="Popunite polje od dana ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles_partners.html";
			}
			if (dodana.isEmpty()) {
				String ev="Popunite polje do dana ....";
				session.setAttribute("ev", ev);	
				return "redirect:find_all_articles_partners.html";
			}

		} catch (Exception x) {
			String ev="Popunite obavezna polja  ....";
			session.setAttribute("ev", ev);	
			return "redirect:find_all_articles_partners.html";
		}

		request.setAttribute("title", "Cards");
		request.setAttribute("oddana", oddana);
		request.setAttribute("dodana", dodana);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		request.setAttribute("currentdate", dateFormat.format(date));

		List<Partner> partkart = (List<Partner>) session.getAttribute("izabraneVrednostiPartneri");
		request.setAttribute("partkart", partkart);

		List<Magacini> magkart = magaciniRepository.partnerZaMagacin(partkart);
		request.setAttribute("magkart", magkart );		
		 sdfgsdf
		List<Artikli> artkart = (List<Artikli>) session.getAttribute("izabraneVrednostiArtikli");
		request.setAttribute("artkart", artkart);
		
		List<Long> ids_magacin = new ArrayList<Long>(); // this should be your id column's type

		for (Partner magacini : partkart) {
			ids_magacin.add(magacini.getId());
		}

		List<Long> ids_artikli = new ArrayList<Long>(); // this should be your id column's type

		for (Artikli artikli : artkart) {
			ids_artikli.add(artikli.getId());
		}

		TreeMap<Integer, SumMagacinArtikal> kontrola = new TreeMap<>();
		kontrola.put(1, new SumMagacinArtikal(new Long(1), new Long(15), new Long(7), new BigDecimal(10.00)));

		System.out.println("Kontrola " + kontrola);
		request.setAttribute("kontrola", kontrola);
		
		System.out.println("Datum string je " + oddana);
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date oddanad = null;
		try {
			oddanad = formatter.parse(oddana);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		Date dodanad = null;
		try {
			dodanad = formatter.parse(dodana);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Datum date je " + oddanad + " " + dodanad);
		
		List<DokumentStavke> stavkart = dokumentStavkeRepository.k1pm(ids_magacin, ids_artikli, oddanad, dodanad);

		System.out.println("Stavka kard " + stavkart); 

		
		request.setAttribute("stavkart", stavkart);
		
		return ("/printing/cardpm");
	}

		return ("/printing/card");

	}

	@RequestMapping(value = "/find_all_articles.html")
	public String faa(HttpServletRequest request) {

		List<Artikli> dd = artikliRepository.findAllByOrderByNameAsc();
		System.out.println("Svi artikli " + dd.toString());
		List<Magacini> dd1 = magaciniRepository.findAllByOrderByNameAsc();
		request.setAttribute("allArticles", dd);
		request.setAttribute("allWarehouses", dd1);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		request.setAttribute("currentdate", dateFormat.format(date));

		return ("cardForm");

	}

	@RequestMapping(value = "/find_all_articles_partners.html")
	public String faap(HttpServletRequest request) {

		List<Artikli> dd = artikliRepository.findAllByOrderByNameAsc();
		System.out.println("Svi artikli " + dd.toString());
		List<Partner> dd1 = costumerRepository.findAllByOrderByNameAsc();
		request.setAttribute("allArticles", dd);
		request.setAttribute("allWarehouses", dd1);
		System.out.println("Svi partneri " + dd1.toString());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		request.setAttribute("currentdate", dateFormat.format(date));

		return ("cardFormPartneri");

	}	
	
	@RequestMapping(value = "/find_all_articles_partners_magacini.html")
	public String faapm(HttpServletRequest request) {

		List<Artikli> dd = artikliRepository.findAllByOrderByNameAsc();
		System.out.println("Svi artikli " + dd.toString());
		List<Partner> dd1 = costumerRepository.findAllByOrderByNameAsc();
		request.setAttribute("allArticles", dd);
		request.setAttribute("allWarehouses", dd1);
		System.out.println("Svi partneri " + dd1.toString());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		request.setAttribute("currentdate", dateFormat.format(date));

		return ("cardFormPartneriMagacini");

	}	
	
	@RequestMapping(value = "/add_article_session_parameter.html")
	public String asp(@RequestParam Long id_roba, HttpServletRequest request) {

		HttpSession sess = request.getSession();
		Map<Long, String> dept = new HashMap<>();
		try {
			Artikli km = new Artikli();
			Artikli deptList = artikliService.findByOne(id_roba);
			// for (VrsteArtikala d : deptList) {
			// dept.put(d.getId(), d.getName());
			// }

			izabraneVrednostiArtikli.add(deptList);
			// dept.put(deptList.getId(), deptList.getCode() + "*" + deptList.getName());
			sess.setAttribute("izabraneVrednostiArtikli", izabraneVrednostiArtikli);
			// request.setAttribute("izabraneVrednosti", izabraneVrednosti);
		} catch (Exception e) {
			return "redirect:find_all_articles.html";
		}
		// return ("cardForm");
		return "redirect:find_all_articles.html";

	}

	@RequestMapping(value = "/add_warehouse_session_parameter.html")
	public String awp(@RequestParam Long id_magacin, HttpServletRequest request) {

		HttpSession sess = request.getSession();
		Map<Long, String> dept = new HashMap<>();

		Magacini km = new Magacini();
		try {
			Magacini deptList = magaciniService.findByOne(id_magacin);

			izabraneVrednostiMagacini.add(deptList);
			// dept.put(deptList.getId(), deptList.getCode() + "*" + deptList.getName());
			sess.setAttribute("izabraneVrednostiMagacini", izabraneVrednostiMagacini);
			// request.setAttribute("izabraneVrednosti", izabraneVrednosti);
		} catch (Exception e) {
			return "redirect:find_all_articles.html";
		}
		// return ("cardForm");
		return "redirect:find_all_articles.html";

	}

	
	@RequestMapping(value = "/add_partner_session_parameter.html")
	public String awpp(@RequestParam Long id_magacin, HttpServletRequest request) {

		HttpSession sess = request.getSession();
		Map<Long, String> dept = new HashMap<>();

		Partner km = new Partner();
		try {
			Partner deptList = costumerRepository.findOne(id_magacin);

			// for (VrsteArtikala d : deptList) {
			// dept.put(d.getId(), d.getName());
			// }

			izabraneVrednostiPartneri.add(deptList);
			// dept.put(deptList.getId(), deptList.getCode() + "*" + deptList.getName());
			sess.setAttribute("izabraneVrednostiPartneri", izabraneVrednostiPartneri);
			// request.setAttribute("izabraneVrednosti", izabraneVrednosti);
		} catch (Exception e) {
			return "redirect:find_all_articles_partners.html";
		}
		// return ("cardForm");
		return "redirect:find_all_articles_partners.html";

	}
	
	@RequestMapping(value = "/add_articlep_session_parameter.html")
	public String aspp(@RequestParam Long id_roba, HttpServletRequest request) {

		// request.setAttribute("allArticles", dd);
		// request.setAttribute("allWarehouses", dd1);

		HttpSession sess = request.getSession();
		Map<Long, String> dept = new HashMap<>();
		try {
			Artikli km = new Artikli();
			Artikli deptList = artikliService.findByOne(id_roba);
			// for (VrsteArtikala d : deptList) {
			// dept.put(d.getId(), d.getName());
			// }

			izabraneVrednostiArtikli.add(deptList);
			// dept.put(deptList.getId(), deptList.getCode() + "*" + deptList.getName());
			sess.setAttribute("izabraneVrednostiArtikli", izabraneVrednostiArtikli);
			// request.setAttribute("izabraneVrednosti", izabraneVrednosti);
		} catch (Exception e) {
			return "redirect:find_all_articles_partners.html";
		}
		// return ("cardForm");
		return "redirect:find_all_articles_partners.html";

	}	
	
}
