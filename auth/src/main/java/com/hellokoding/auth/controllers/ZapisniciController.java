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
	
	@RequestMapping(value = "/lista-zapisnika.html")
	public String MeasureTypesDisplay(HttpServletRequest request) {

		request.setAttribute("mode", "MODE_TASKS");
		request.setAttribute("title", "Zapisnici");
		request.setAttribute("zapisnici_unos", "/zapisnici-unos.html");
		request.setAttribute("zapisnici_pdf", "/zapisnici-pdf.html");
		return "reklamacioni-zapisnici";
	}
	
	@RequestMapping(value = "/zapisnici-unos.html", method = RequestMethod.GET)
	public ModelAndView newTypeArticles(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Novi reklamacioni zapisnik");

		Zapisnici aa = new Zapisnici();
		// da bi default aktivan bio checked
		aa.setAktivan(true);
		Date date = new Date();
		//aa.setDatumVreme(date);

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
}
