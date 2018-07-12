package com.hellokoding.auth.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.Drzave;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.repository.ArtikliRepository;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.repository.DokumentRepository;
import com.hellokoding.auth.repository.DokumentStavkeRepository;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.repository.TypesOfDocumentsRepository;

@Controller
public class DokumentStavkeMmpController {

	@Autowired
	private DokumentStavkeRepository dokumentStavkeRepository;

	@Autowired
	private MagaciniRepository magaciniRepository;
	@Autowired
	private ArtikliRepository artikliRepository;

	@Autowired
	private CostumersRepository partnerRepository;

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private CompanyDetails companyDetails;

	@Autowired
	private TypesOfDocumentsRepository typesOfDocumentsRepository;

	@Autowired
	private DokumentRepository dokumentRepository;

	@RequestMapping(value = "/dokumentStavkeMmp.html")
	public String dokumentStavkeMmp(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Dokument Items");
		request.setAttribute("new_item", "/dokumentStavkeMmp_new.html");
		request.setAttribute("print_item", "/dokumentStavkeMmp_pdf.html");
		return "dokumentStavkeMmp";
	}

	@RequestMapping(value = "/dokumentStavkeMmp_new.html", method = RequestMethod.GET)
	public ModelAndView dokumentStavkeMmp_new(Model model, @RequestParam Long brDokumenta, HttpServletRequest request) {

		model.addAttribute("title", "New dokumentStavkeMmp");

		request.setAttribute("new_item", "/dokumentStavkeMmp_new.html");
		request.setAttribute("print_item", "/dokumentStavkeMmp_pdf.html");
		request.setAttribute("brDokumenta", "brDokumenta");

		// model.addAttribute("model_atribut", "dokumentStavke");

		DokumentStavke aa = new DokumentStavke();
		// da bi default aktivan bio checked

		aa.setAktivan(true);
		Date date = new Date();
		aa.setDatum(date);

		// List<DokumentStavke> aa =
		// dokumentStavkeRepository.findByIdDokument(dokumentRepository.findOne(rr2));

		// priprema podredjenih objekata
		// *******************************************************
		aa.setIdDokument(dokumentRepository.findOne(brDokumenta));

		aa.setMagacini(dokumentRepository.findOne(brDokumenta).getMagacini());
		aa.setTypesOfDocuments(dokumentRepository.findOne(brDokumenta).getTypesOfDocuments());

		Artikli km = new Artikli();
		List<Artikli> deptList = artikliRepository.findAll();

		Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();

		for (Artikli d : deptList) {
			dept.put(d.getId(), d.getName());
		}
		sess.setAttribute("eArtikli", dept);

		List<TypesOfDocuments> tdList = typesOfDocumentsRepository.dokTypeIs2(); // .findAll();
		Map<Long, String> tdl = new HashMap<>();

		for (TypesOfDocuments d : tdList) {
			tdl.put(d.getId(), d.getName());
		}
		sess.setAttribute("eTypesOfDocuments", tdl);

		List<Magacini> mList = magaciniRepository.findAll();
		Map<Long, String> ml = new HashMap<>();

		for (Magacini d : mList) {
			ml.put(d.getId(), d.getName());
		}
		sess.setAttribute("eMagacini", ml);

		return new ModelAndView("dokumentStavkaMmpForm", "dokumentStavke", aa);
	}

	@RequestMapping(value = "/delete_dokumentStavkeMmp.html")
	public String delete_dokumentStavkeMmp(@RequestParam Long id, @RequestParam Long brDokumenta,
			HttpServletRequest request) {
		try {
			dokumentStavkeRepository.delete(id);
		} catch (Exception ex) {
			return "redirect:414.html?ops=Can't delete record!";
		}
		// Long tt = id; // dokumentStavke.getId();
		Dokument idDokument;
		idDokument = dokumentRepository.findOne(brDokumenta);

		idDokument.setIznos(dokumentStavkeRepository.sum_zaglavlje(brDokumenta));

		dokumentRepository.save(idDokument);

		// dokumentStavke.setIdDokument(idDokument);

		// Long rr2 = null;
		//
		// Dokument rr = brDokumenta; // dokumentStavke.getIdDokument();
		//
		// if (rr !=null)
		//// if (rr.getId() != null)
		// rr2 = rr.getId();
		//
		// System.out.println("Broj dokumenta u zaglavlju " + rr2);
		//
		// BigDecimal eee = dokumentStavkeRepository.sum_zaglavlje(rr2);
		// System.out.println("Suma " + eee);
		//
		// rr.setIznos(dokumentStavkeRepository.sum_zaglavlje(rr2));

		return "redirect:dokumentStavkefinalmmp.html?id=" + brDokumenta;
	}

	@RequestMapping(value = "/save_dokumentStavkeMmp.html", method = RequestMethod.POST)
	public String savedokumentStavkeMmp(@ModelAttribute("dokumentStavke") @Valid DokumentStavke dokumentStavke,
			BindingResult result, Model model) { // , @PathVariable int aktivan

//		System.out.println("Save stavke ");

		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "dokumentStavkaMmpForm";
		}

		// String rr = dokumentStavke.getName();

		Long tt = dokumentStavke.getId();
		Dokument idDokument;
		// dokumentStavke.setIdDokument(idDokument);

		Long rr2 = null;

		Dokument rr = dokumentStavke.getIdDokument();

		if (rr != null)
			// if (rr.getId() != null)
			rr2 = rr.getId();

		System.out.println("Broj dokumenta u zaglavlju " + rr2);

		BigDecimal eee = dokumentStavkeRepository.sum_zaglavlje(rr2);
		System.out.println("Suma  " + eee);

		rr.setIznos(dokumentStavkeRepository.sum_zaglavlje(rr2));

		// provera podredjenih objekata koji su pripremljeni u /dokumentStavke_new.html
		// *****************************************************************************

		dokumentStavke.setTypesOfDocuments(rr.getTypesOfDocuments()); // posto nije moglo preko jsp page
		dokumentStavke.setMagacini(rr.getMagacini());

		TypesOfDocuments rr1 = dokumentStavke.getTypesOfDocuments();
		Magacini rr3 = dokumentStavke.getMagacini();

		dokumentStavke.setDatum(dokumentStavke.getIdDokument().getDatum());
		dokumentStavke.setDatumvreme(new Date());
		dokumentStavke.setIznos(dokumentStavke.getKolicina().multiply(dokumentStavke.getCena()));

		if (rr1.getStrana() == 1) {
			dokumentStavke.setUlaz(dokumentStavke.getKolicina());
			dokumentStavke.setDuguje(dokumentStavke.getIznos());
		} else {
			dokumentStavke.setIzlaz(dokumentStavke.getKolicina());
			dokumentStavke.setPotrazuje(dokumentStavke.getIznos());
		}

		// dokumentStavke.setIdDokument(rr.setIznos(new BigDecimal("100.00")));
		// .setIdDokument(idDokument.setIznos(new BigDecimal("100.00")));

		// kraj punjenja podredjenih objekata

		// if (dokumentStavke.getId() != null) {
		// PttBrojevi pttBrojevi = new PttBrojevi();
		// pttBrojevi.setDokument(dokumentStavke);
		// }

		dokumentStavkeRepository.save(dokumentStavke);

		rr.setIznos(dokumentStavkeRepository.sum_zaglavlje(rr2));
		dokumentRepository.save(rr);

		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Dokument Items");

		// List<DokumentStavke> aa =
		// dokumentStavkeRepository.findByIdDokument(dokumentRepository.findOne(rr2));
		// model.addAtributte("dokumentStavke", aa);

		model.addAttribute("new_dokumentStavkeMmp", "/dokumentStavkeMmp_new.html");
		model.addAttribute("print_dokumentStavkeMmp", "/dokumentStavkeMmp_pdf.html");

		return "redirect:dokumentStavkefinalmmp.html?id=" + rr2;

	}

	@RequestMapping(value = "/update_dokumentStavkeMmp.html")
	public ModelAndView updatedokumentStavkeMmp(@RequestParam Long id, @RequestParam Long brDokumenta,
			HttpServletRequest request) {

		DokumentStavke dd = dokumentStavkeRepository.findOne(id);

		Dokument rr = dd.getIdDokument();

		Long rr2 = null;

		if (rr != null)
			rr2 = rr.getId();

		// provera podredjenih objekata koji su pripremljeni u /dokumentStavke_new.html
		// *****************************************************************************

		// dd.setTypesOfDocuments(rr.getTypesOfDocuments()); // posto nije moglo preko
		// jsp page
		// dd.setMagacini(rr.getMagacini());
		//
		// TypesOfDocuments rr1 = dd.getTypesOfDocuments();
		// Magacini rr3 = dd.getMagacini();
		// kraj punjenja podredjenih objekata

		// request.setAttribute("dokumentStavke", rr);

		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update dokumentStavkeMmp");

		Artikli km = new Artikli();
		List<Artikli> deptList = artikliRepository.findAll();

		Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();

		for (Artikli d : deptList) {
			dept.put(d.getId(), d.getName());
		}
		sess.setAttribute("eArtikli", dept);

		List<TypesOfDocuments> tdList = typesOfDocumentsRepository.dokTypeIs2(); // .findAll();
		Map<Long, String> tdl = new HashMap<>();

		for (TypesOfDocuments d : tdList) {
			tdl.put(d.getId(), d.getName());
		}
		sess.setAttribute("eTypesOfDocuments", tdl);

		List<Magacini> mList = magaciniRepository.findAll();
		Map<Long, String> ml = new HashMap<>();

		for (Magacini d : mList) {
			ml.put(d.getId(), d.getName());
		}
		sess.setAttribute("eMagacini", ml);

		// return "dokumentStavkaForm";
		return new ModelAndView("dokumentStavkaMmpForm", "dokumentStavke", dd);
	}

	@RequestMapping(path = "/dokumentStavkeMmp_pdf.html", method = RequestMethod.GET)
	public ModelAndView dokumentStavkeMmp_pdf() {

		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:rpt_Items1.jrxml");
		view.setApplicationContext(appContext);

		Map<String, Object> params = new HashMap<>();
		params.put("datasource", dokumentStavkeRepository.findAllByOrderByIdDesc());
		params.put("title", "Dokument Items - angular");

		params.put("company", companyDetails.companyDetails1);
		params.put("adress", companyDetails.companyDetails2);
		params.put("city", companyDetails.companyDetails3);
		return new ModelAndView(view, params);
	}



	@RequestMapping(value = "/view_dokumentStavkeMmp.html")
	public String viewdokumentStavkeMmp(@RequestParam Long id, HttpServletRequest request) {

		Dokument aa1 = dokumentRepository.findOne(id);

		// netreba definisati findByIdDokument u querijima defoltno postoji
		List<DokumentStavke> aa = dokumentStavkeRepository.findByIdDokument(aa1);

		request.setAttribute("data", aa); // dokumentStavke
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update dokumentStavkeMmp");

		Magacini km = new Magacini();
		List<Magacini> deptList = magaciniRepository.findAll();

		Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();

		for (Magacini d : deptList) {
			dept.put(d.getId(), d.getName());
		}
		sess.setAttribute("eMagacini", dept);

		List<TypesOfDocuments> tdList = typesOfDocumentsRepository.dokTypeIs2(); // .findAll();
		Map<Long, String> tdl = new HashMap<>();

		for (TypesOfDocuments d : tdList) {
			tdl.put(d.getId(), d.getName());
		}
		sess.setAttribute("eTypesOfDocuments", tdl);

		return "dokumentStavkeMmp";
	}

	// prikaz stavki dokumenta
	@RequestMapping(path = "/dokumentStavkefinalmmp.html", method = RequestMethod.GET)
	public String dokumentStavkeMmpfinal(Model model, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "0") Long id) {

		// dokumentRepository.findById(id);
		Dokument ee = dokumentRepository.findOne(id);
		Dokument ee1 = dokumentRepository.getOne(id);
		// Dokument ss = dokumentRepository.findById(id);
		List<DokumentStavke> aa = dokumentStavkeRepository.findByIdDokument(dokumentRepository.findOne(id));
		List<DokumentStavke> aa1 = dokumentStavkeRepository.findByIdDokument(ee1);
		// Page<DokumentStavke> mm = dokumentStavkeRepository.findAll(new
		// PageRequest(page,4));
		model.addAttribute("dokumentStavke", aa);
		model.addAttribute("title", "Stavke mmp dokumenta");
		model.addAttribute("new_item", "/dokumentStavkeMmp_new.html");
//		request.setAttribute("print_item", "/dokumentStavkeMmp_pdf.html");

		return "dokumentStavkaMmp";
	}


	@RequestMapping(value = "/dokumentStavkeMmp_back.html")
	public String DokumentStavkeMmpBack(HttpServletRequest request) {
		request.getHeader("REFERRER");
		// return "dokumentStavke";
		request.getHeader("REFERRER");
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

}
