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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import com.hellokoding.auth.model.CompanyDetails;
import com.hellokoding.auth.model.Drzave;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.repository.DokumentRepository;
import com.hellokoding.auth.repository.DokumentStavkeRepository;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.repository.TypesOfDocumentsRepository;

@Controller
public class MmpController {
	@Autowired
	private DokumentRepository dokumentRepository;

	@Autowired
	private MagaciniRepository magaciniRepository;

	@Autowired
	private CostumersRepository partnerRepository;

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private CompanyDetails companyDetails;

	@Autowired
	private TypesOfDocumentsRepository typesOfDocumentsRepository;

	@Autowired
	private DokumentStavkeRepository dokumentStavkeRepository;

	@RequestMapping(value = "/mmp.html")
	public String MmpDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Medjumagacinski dokumenti");
		request.setAttribute("new_item", "/mmp_new.html");
		request.setAttribute("print_item", "/mmp_pdf.html");
		return "mmp";
	}

	@RequestMapping(value = "/mmp_new.html", method = RequestMethod.GET)
	public ModelAndView newMmp(Model model, HttpServletRequest request) {
		model.addAttribute("title", "New dokument");
		// model.addAttribute("model_atribut", "dokument");

		Dokument aa = new Dokument();
		// da bi default aktivan bio checked
		aa.setAktivan(true);
		Date date = new Date();
		aa.setDatumVreme(date);

		// partner
		Partner kmp = new Partner();
		List<Partner> partList = partnerRepository.findAll();

		Map<Long, String> deptp = new HashMap<>();
		HttpSession sess = request.getSession();

		for (Partner d : partList) {
			deptp.put(d.getId(), d.getName());
		}
		sess.setAttribute("ePartner", deptp);

		List<Magacini> deptList = magaciniRepository.findAll();

		Map<Long, String> dept = new HashMap<>();
		// HttpSession sess = request.getSession();

		for (Magacini d : deptList) {
			dept.put(d.getId(), d.getName());
		}

		sess.setAttribute("eMagacini", deptList);

		// Vrste dokumenata
		// TypesOfDocuments km = new TypesOfDocuments();
		List<TypesOfDocuments> tdList = typesOfDocumentsRepository.dokTypeIs2(); // .findAll();

		Map<Long, String> tdl = new HashMap<>();

		for (TypesOfDocuments d : tdList) {
			tdl.put(d.getId(), d.getName());
		}
		sess.setAttribute("eTypesOfDocuments", tdl);

		return new ModelAndView("mmpForm", "dokument", aa);

	}

	@RequestMapping(value = "/ozvanicenje_mmp.html")
	public String ozvanicenjeMmp(@RequestParam Long id, HttpServletRequest request) {

		Dokument d = dokumentRepository.findOne(id);
		Dokument aa = new Dokument();
		
		List<DokumentStavke> dd = dokumentStavkeRepository.findByIdDokument(d);

		// stavke dobijaju status 1
		for (DokumentStavke ds : dd) {			
			ds.setStatus(1);
			DokumentStavke myobjectStavke = dokumentStavkeRepository.saveAndFlush(ds);
			System.out.println(myobjectStavke);				
		}		
		
//		if (d.getTypesOfDocuments().getId()==6) {
			
			// aa.setId(null);

			TypesOfDocuments tod = d.getTypesofdocuments();
			Magacini mag = d.getMagacini();
			Partner part = d.getPartner();
			
			TypesOfDocuments tod2 = d.getTypesofdocuments2();
			Magacini mag2 = d.getMagacini2();
			Partner part2 = d.getPartner2();
			
			aa.setTypesOfDocuments(tod2);
			aa.setMagacini(mag2);
			aa.setPartner(part2);
			
			aa.setTypesofdocuments2(tod);
			aa.setMagacini2(mag);
			aa.setPartner2(part);
			
			aa.setAkcija(d.getAkcija());
			aa.setAktivan(d.getAktivan());
			aa.setBrojDokumenta(d.getBrojDokumenta());
			aa.setDatum(d.getDatum());
			aa.setInterniBrojDokumenta(d.getInterniBrojDokumenta());
			aa.setIznos(d.getIznos());
			aa.setIznos_bez_poreza(d.getIznos_bez_poreza());
			aa.setNapomena(d.getNapomena());
			aa.setOsnov(d.getOsnov());
			aa.setPorez(d.getPorez());
			aa.setPredao(d.getPredao());
			aa.setPrimio(d.getPrimio());
			aa.setVideo(d.getVideo());
			aa.setZvuk(d.getZvuk());
			aa.setSlika(d.getSlika());
			aa.setStatus(1);
			aa.setVeza(d.getId());
			
			Dokument myobject = dokumentRepository.saveAndFlush(aa);
			System.out.println(myobject);
			
			d.setVeza(myobject.getId());
			d.setStatus(1);
			Dokument myobject1 = dokumentRepository.saveAndFlush(d);
			System.out.println(myobject1);
			
			for (DokumentStavke ds : dd) {
				
				DokumentStavke ddd = new DokumentStavke();
				ddd.setAkcija(ds.getAkcija());
				ddd.setAktivan(ds.getAktivan());
				ddd.setArtikli(ds.getArtikli());
				ddd.setCena(ds.getCena());
				ddd.setDatum(ds.getDatum());
				ddd.setDuguje(ds.getDuguje());
				ddd.setHost(ds.getHost());
				ddd.setIdDokument(myobject);
				ddd.setIzlaz(ds.getIzlaz());
				ddd.setIznos(ds.getIznos());
				ddd.setKolicina(ds.getKolicina());
				ddd.setMagacini(myobject.getMagacini());
				ddd.setNapomena(ds.getNapomena());
				ddd.setPotrazuje(ds.getPotrazuje());
				ddd.setPovratna(ds.getPovratna());
				ddd.setStatus(ds.getStatus());
				ddd.setTypesOfDocuments(myobject.getTypesofdocuments());
				ddd.setUlaz(ds.getUlaz());
				ddd.setStatus(1);
				DokumentStavke myobjectStavke = dokumentStavkeRepository.saveAndFlush(ddd);
				System.out.println(myobjectStavke);				
			}
			
//		}

		return "redirect:mmp.html";
	}

	@RequestMapping(value = "/save_mmp.html", method = RequestMethod.POST)
	public String addMmp(@ModelAttribute("dokument") @Valid Dokument dokument, BindingResult result, Model model) { // ,
																													// @PathVariable
																													// int
																													// aktivan

		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "mmpForm";
		}

		// String rr = dokument.getName();

		Long tt = dokument.getId();
		
		// System.out.println("tt je  " + tt);

		if (tt == null) {
			Long ww = dokumentRepository.max_za_vrstu_dokumenta(dokument.getTypesOfDocuments().getId());
			System.out.println(ww);
			if (ww == null) {
				ww = (long) 1;
			}

			dokument.setInterniBrojDokumenta(ww);
		}

		// dokument.setPartner2(dokument.getPartner());
		// dokument.setTypesofdocuments2(dokument.getTypesOfDocuments());

		dokumentRepository.save(dokument);

		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Dokuments");
		model.addAttribute("new_mmp", "/mmp_new.html");
		model.addAttribute("print_mmp", "/mmp_pdf.html");

		return "redirect:mmp.html";

	}

	@RequestMapping(value = "/update_mmp.html")
	public String updateMmp(@RequestParam Long id, HttpServletRequest request) {

		request.setAttribute("dokument", dokumentRepository.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Update MMP dokument");

		// Dokument TT = dokumentRepository.findById(id);
		// request.setAttribute("dokument", dokumentRepository.findOne(id));
		// request.setAttribute("mode", "MODE_UPDATE");
		// request.setAttribute("title", "Update MMP dokument");

		// Magacini km = new Magacini();
		List<Magacini> deptList = magaciniRepository.findAll();

		Map<Long, String> dept = new HashMap<>();
		HttpSession sess = request.getSession();

		for (Magacini d : deptList) {
			dept.put(d.getId(), d.getName());
		}
		sess.setAttribute("eMagacini", deptList);

		List<TypesOfDocuments> tdList = typesOfDocumentsRepository.dokTypeIs2();
		Map<Long, String> tdl = new HashMap<>();

		for (TypesOfDocuments d : tdList) {
			tdl.put(d.getId(), d.getName());
		}
		sess.setAttribute("eTypesOfDocuments", tdl);

		// partner
		Partner kmp = new Partner();
		List<Partner> partList = partnerRepository.findAll();

		Map<Long, String> deptp = new HashMap<>();

		for (Partner d : partList) {
			deptp.put(d.getId(), d.getName());
			String tt = d.getName();
		}
		sess.setAttribute("ePartner", deptp);

		return "mmpForm";
	}

	@RequestMapping(value = "/delete_mmp.html")
	public String deleteMmp(@RequestParam Long id, HttpServletRequest request) {

		try {
			dokumentRepository.delete(id);
		} catch (Exception ex) {
			return "redirect:414.html?ops=Can't delete record!";
		}
		return "redirect:mmp.html";
	}

	@RequestMapping(path = "/mmp_pdf.html", method = RequestMethod.GET)
	public ModelAndView printMmpReport() {

		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:rpt_Items1.jrxml");
		view.setApplicationContext(appContext);

		Map<String, Object> params = new HashMap<>();
		params.put("datasource", dokumentRepository.findAllByOrderByIdDesc());
		params.put("title", "Dokuments - angular");

		params.put("company", companyDetails.companyDetails1);
		params.put("adress", companyDetails.companyDetails2);
		params.put("city", companyDetails.companyDetails3);
		return new ModelAndView(view, params);
	}
	
	@RequestMapping(value = "print_mmp.html")
	public ModelAndView selectTag(@RequestParam Long id, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("/printing/print_mmp");

		Dokument dokument = dokumentRepository.findOne(id);
		List<DokumentStavke> dokumentStavke = dokumentStavkeRepository.findByIdDokument(dokument);

		Map<String, String> phones = new HashMap<String, String>();
		phones.put("samsung", "SAMSUNG");
		phones.put("nokia", "NOKIA");
		phones.put("iphone", "IPHONE");


		mav.addObject("dokument", dokument);
		mav.addObject("dokumentStavke", dokumentStavke);

		// mav.addObject("smartphone", new Smartphone());

		return mav;
	}

	// @RequestMapping(path = "/printing/printDocument.html", method =
	// RequestMethod.GET)
	// public ModelAndView printMmpPOReport123() {
	//
	// JasperReportsPdfView view = new JasperReportsPdfView();
	// view.setUrl("classpath:rpt_Items1.jrxml");
	// view.setApplicationContext(appContext);
	//
	// Map<String, Object> params = new HashMap<>();
	// params.put("datasource", dokumentRepository.findAllByOrderByIdDesc());
	// params.put("title", "Dokuments - angular");
	//
	// params.put("company", companyDetails.companyDetails1);
	// params.put("adress", companyDetails.companyDetails2);
	// params.put("city", companyDetails.companyDetails3);
	// return new ModelAndView(view, params);
	// }

	// @RequestMapping(value = "printDocument.html")
	// public ModelAndView selectTag(@RequestParam Long id, HttpServletRequest
	// request) {
	// ModelAndView mav = new ModelAndView("/printing/printDocument");
	//
	// Dokument dokument = dokumentRepository.findOne(id);
	// List<DokumentStavke> dokumentStavke =
	// dokumentStavkeRepository.findByIdDokument(dokument);
	//
	// Map<String, String> phones = new HashMap<String, String>();
	// phones.put("samsung", "SAMSUNG");
	// phones.put("nokia", "NOKIA");
	// phones.put("iphone", "IPHONE");
	//
	// mav.addObject("dokument", dokument);
	// mav.addObject("dokumentStavke", dokumentStavke);
	//
	// // mav.addObject("smartphone", new Smartphone());
	//
	// return mav;
	// }
}