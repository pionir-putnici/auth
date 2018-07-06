package com.hellokoding.auth.controllers;

import java.util.Collection;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.model.Zapisnici;
import com.hellokoding.auth.repository.ZapisniciRepository;
import com.hellokoding.auth.repository.DokumentRepository;

@Controller
public class ZapisniciController {

	@Autowired
	private DokumentRepository dokumentRepository;

	@Autowired
	private ZapisniciRepository zapisniciRepository;

	@RequestMapping(value = "/lista-zapisnika.html")
	public String ZapisniciDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Zapisnici");
		request.setAttribute("zapisnici_unos", "/zapisnici-unos.html");
		request.setAttribute("zapisnici_pdf", "/zapisnici-pdf.html");
		return "reklamacioni-zapisnici";
	}

	@RequestMapping(value = "/zapisnici-unos.html", method = RequestMethod.GET)
	public ModelAndView newZapisnici(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Novi reklamacioni zapisnik");

		Zapisnici aa = new Zapisnici();
		// da bi default aktivan bio checked
		aa.setAktivan(true);
		Date date = new Date();
		// aa.setDatumVreme(date);

		// dokument
		Dokument kmp = new Dokument();
		List<Dokument> dokList = dokumentRepository.findAll(); // tu sam stao

		Map<Long, String> dokMap = new HashMap<>();
		HttpSession sess = request.getSession();

		for (Dokument d : dokList) {
			dokMap.put(d.getId(), d.getBrojDokumenta());
		}
		sess.setAttribute("eDokument", dokMap);

		return new ModelAndView("zapisniciForm", "zapisnici", aa);
	}

	// save zapisnik
	@RequestMapping(value = "/zapisnici-save", method = RequestMethod.POST)
	public String addZapisnici(@ModelAttribute("zapisnici") @Valid Zapisnici zapisnici, BindingResult result,
			Model model) { // , @PathVariable int aktivan

		// if (aktivan == 1) {
		// vrstePaleta.setAktivan(true);
		// } else {
		// vrstePaleta.setAktivan(false);
		// }

		if (result.hasErrors()) {
			model.addAttribute("error", "error");
			return "zapisniciForm";
		}

		// String rr = dokument.getName();

		Long tt = zapisnici.getId();
		System.out.println("tt je  " + tt);

		// if (dokument.getId() != null) {
		// PttBrojevi pttBrojevi = new PttBrojevi();
		// pttBrojevi.setDokument(dokument);
		// }

		zapisniciRepository.save(zapisnici);

		// request.setAttribute("mode", "MODE_TASKS");
		// request.setAttribute("title", "Vrste artikala");
		// request.setAttribute("new_dokument ", "/dokument _new.html");
		// request.setAttribute("print_dokument ", "/dokument _pdf.html");

		model.addAttribute("mode", "MODE_TASKS");
		model.addAttribute("title", "Dokuments");
		model.addAttribute("new_dokument", "/dokument_new.html");
		model.addAttribute("print_dokument", "/dokument_pdf.html");

		return "redirect:lista-zapisnika.html";

	}
	// end save zapisnik

	// edit zapisnik
	@RequestMapping(value = "/zapisnici-update.html")
	public String updateZapisnici(@RequestParam Long id, HttpServletRequest request) {
		
		request.setAttribute("zapisnici", zapisniciRepository.findById(id));
		request.setAttribute("mode", "MODE_UPDATE");
		request.setAttribute("title", "Izmeni zapisnik");

				List<Dokument> dokList = dokumentRepository.findAll();

				Map<Long, String> dokMap = new HashMap<>();
				HttpSession sess = request.getSession();

				for (Dokument d : dokList) {
					dokMap.put(d.getId(), d.getBrojDokumenta());
				}
				sess.setAttribute("eDokument", dokMap);

				return "zapisniciForm";

	}
	
@PreAuthorize("hasAnyRole('ADMIN')")
    
	@RequestMapping(value = "/zapisnici-delete.html")
	public String deleteZapisnici(@RequestParam Long id, HttpServletRequest request) {

		Zapisnici aa = zapisniciRepository.findById(id);
		
//		if (!aa.getDokument().isEmpty()) {	
//			return "redirect:414.html?ops=Article items exist in card report, can't delete article!";
//		}
		
		zapisniciRepository.delete(aa);
		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Artikli");

		return "redirect:lista-zapisnika.html"; 

	}
		
	// end edit zapisnik
}
