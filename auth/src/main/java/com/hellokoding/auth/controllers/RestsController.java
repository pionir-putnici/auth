package com.hellokoding.auth.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hellokoding.auth.model.Artikli;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.model.Drzave;
import com.hellokoding.auth.model.JediniceMera;
import com.hellokoding.auth.model.Klasifikacije;
import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.model.Partner;
import com.hellokoding.auth.model.PoreskeGrupe;
import com.hellokoding.auth.model.PttBrojevi;
import com.hellokoding.auth.model.TypesOfDocuments;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.VrsteArtikala;
import com.hellokoding.auth.model.VrsteMagacina;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.model.Zapisnici;
import com.hellokoding.auth.repository.CostumersRepository;
import com.hellokoding.auth.repository.DokumentRepository;
import com.hellokoding.auth.repository.DokumentStavkeRepository;
import com.hellokoding.auth.repository.DrzaveRepository;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.repository.TypesOfDocumentsRepository;
import com.hellokoding.auth.repository.ZapisniciRepository;
import com.hellokoding.auth.repository.ZipCodesRepository;
import com.hellokoding.auth.service.ArtikliService;
import com.hellokoding.auth.service.JediniceMeraService;
import com.hellokoding.auth.service.KlasifikacijeService;
import com.hellokoding.auth.service.PoreskeGrupeService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.service.VrsteArtikalaService;
import com.hellokoding.auth.service.VrsteMagacinaService;
import com.hellokoding.auth.service.VrstePaletaService;
import com.ibm.icu.text.SimpleDateFormat;

@RestController
public class RestsController {
	
	@Autowired
	private VrstePaletaService vrstePaletaService;
	@Autowired
	private VrsteArtikalaService vrsteArtikalaService;
	@Autowired
	private KlasifikacijeService klasifikacijeService;
	@Autowired
	private JediniceMeraService jediniceMeraService;
	@Autowired
	private PoreskeGrupeService poreskeGrupeService;	
	@Autowired
	private ArtikliService artikliService;	
	@Autowired
	private VrsteMagacinaService vrsteMagacinaService;
	@Autowired
	private UserService userService;
	@Autowired
	private DrzaveRepository drzaveRepository;
	@Autowired
	private ZipCodesRepository zipCodesRepository;
	@Autowired
	private CostumersRepository costumersRepository;
	@Autowired
	private DokumentRepository dokumentRepository;
	@Autowired
	private MagaciniRepository magaciniRepository;
	
	@Autowired
	private ZapisniciRepository zapisniciRepository;
	
	@Autowired
	private DokumentStavkeRepository dokumentStavkeRepository;
	
	@Autowired
	private TypesOfDocumentsRepository typesOfDocumentsRepository;
	
	@RequestMapping(path="/vrstepaleta", method=RequestMethod.GET)
	public List<VrstePaleta> getAllPalletsTypes(){
		
		List<VrstePaleta> aa = vrstePaletaService.getAllVrstePaleta();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			VrstePaleta vrstePaleta = (VrstePaleta) iterator.next();
			vrstePaleta.setAkcija("<a href=\"update-vrste-paleta.html?id=" + vrstePaleta.getUid() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-vrste-paleta.html?id=" + vrstePaleta.getUid() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
		}

		return aa; 
	}
	
	@RequestMapping(path="/vrsteartikala", method=RequestMethod.GET)
	public List<VrsteArtikala> getJsonArticlesTypes(){
		
		List<VrsteArtikala> aa = vrsteArtikalaService.getAllVrsteArtikala();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			VrsteArtikala vrsteArtikala = (VrsteArtikala) iterator.next();
			vrsteArtikala.setAkcija("<a href=\"update-vrste-artikala.html?id=" + vrsteArtikala.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-vrste-artikala.html?id=" + vrsteArtikala.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
		}

		return aa; 
	}
	
	@RequestMapping(path="/jedinicemera", method=RequestMethod.GET)
	public List<JediniceMera> getJsonUnitsOfMeasure(){
		
		List<JediniceMera> aa = jediniceMeraService.getAllJediniceMera();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 JediniceMera jediniceMera = (JediniceMera) iterator.next();
			 jediniceMera.setAkcija("<a href=\"update_units_of_measure.html?id=" + jediniceMera.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_units_of_measure.html?id=" + jediniceMera.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S");
//		        Date tt = jediniceMera.getTimestamp();
//		        jediniceMera.setTimestamp(simpleDateFormat.format(tt));
//		        System.out.println(simpleDateFormat.format(timestamp));
		}

		return aa; 
	}

	@RequestMapping(path="/klasifikacije", method=RequestMethod.GET)
	public List<Klasifikacije> getJsonklasifikacije(){
		
		List<Klasifikacije> aa = klasifikacijeService.getAllKlasifikacije();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Klasifikacije klasifikacije = (Klasifikacije) iterator.next();
			 klasifikacije.setAkcija("<a href=\"update-classifications.html?id=" + klasifikacije.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-classifications.html?id=" + klasifikacije.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S");
//		        Date tt = jediniceMera.getTimestamp();
//		        jediniceMera.setTimestamp(simpleDateFormat.format(tt));
//		        System.out.println(simpleDateFormat.format(timestamp));
		}

		return aa; 
	}

	@RequestMapping(path="/poreskegrupe", method=RequestMethod.GET)
	public List<PoreskeGrupe> getJsonporeskegrupe(){
		
		List<PoreskeGrupe> aa = poreskeGrupeService.getAllPoreskeGrupe();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 PoreskeGrupe poreskeGrupe = (PoreskeGrupe) iterator.next();
			 poreskeGrupe.setAkcija("<a href=\"update-poreskeGrupe.html?id=" + poreskeGrupe.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-poreskeGrupe.html?id=" + poreskeGrupe.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S");
//		        Date tt = jediniceMera.getTimestamp();
//		        jediniceMera.setTimestamp(simpleDateFormat.format(tt));
//		        System.out.println(simpleDateFormat.format(timestamp));
		}

		return aa; 
	}
	
	@RequestMapping(path="/artikli", method=RequestMethod.GET)
	public List<Artikli> getJsonArtikli(){
		
		List<Artikli> aa = artikliService.getAllArtikli();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Artikli artikli = (Artikli) iterator.next();
			 artikli.setVrste_artikala_naziv(artikli.getVrsteArtikala().getName());
			 artikli.setAkcija("<a href=\"update-artikli.html?id=" + artikli.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-artikli.html?id=" + artikli.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss:S");
//		        Date tt = jediniceMera.getTimestamp();
//		        jediniceMera.setTimestamp(simpleDateFormat.format(tt));
//		        System.out.println(simpleDateFormat.format(timestamp));
		}

		return aa; 
	}
	
	@RequestMapping(path="/vrstemagacina", method=RequestMethod.GET)
	public List<VrsteMagacina> getJsonVrsteMagacina(){
		
		List<VrsteMagacina> aa = vrsteMagacinaService.getAllVrsteMagacina();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 VrsteMagacina vrsteMagacina = (VrsteMagacina) iterator.next();
			 vrsteMagacina.setAkcija("<a href=\"update-vrste-magacina.html?id=" + vrsteMagacina.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-vrste-magacina.html?id=" + vrsteMagacina.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
		}

		return aa; 
	}
	
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public List<User> getJsonUsers(){
		
		List<User> aa = userService.getAllUsers();
	


		return aa; 
	}
	
	@RequestMapping(path="/states", method=RequestMethod.GET)
	public List<Drzave> getJsonStates(){
		
		List<Drzave> aa = drzaveRepository.findAllByOrderByIdDesc();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Drzave drzave = (Drzave) iterator.next();
			 drzave.setAkcija("<a href=\"update_states.html?id=" + drzave.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_states.html?id=" + drzave.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
			 
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

		        Date tt = drzave.getTimestamp();
		        drzave.setVideo(simpleDateFormat.format(tt));

		}

		return aa; 
	}
	
	@RequestMapping(path="/zipcodes", method=RequestMethod.GET)
	public List<PttBrojevi> getJsonzipCodes(){
		
		List<PttBrojevi> aa = zipCodesRepository.findAllByOrderByIdDesc();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 PttBrojevi pttBrojevi = (PttBrojevi) iterator.next();
			 pttBrojevi.setAkcija("<a href=\"update_zipCodes.html?id=" + pttBrojevi.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_zipCodes.html?id=" + pttBrojevi.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
			 
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

		        Date tt = pttBrojevi.getTimestamp();
		        pttBrojevi.setVideo(simpleDateFormat.format(tt));

		}

		return aa; 
	}	
	
	
	@RequestMapping(path="/costumers", method=RequestMethod.GET)
	public List<Partner> getJsonCostumers(){
		
		List<Partner> aa = costumersRepository.findAll();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Partner partner = (Partner) iterator.next();
			 partner.setAkcija("<a href=\"update_customer.html?id=" + partner.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_customer.html?id=" + partner.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
			 
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

		        Date tt = partner.getTimestamp();
		        partner.setVideo(simpleDateFormat.format(tt));

		}

		return aa; 
	}	

	
	@RequestMapping(path="/dokumenti", method=RequestMethod.GET)
	public List<Dokument> getJsonDokumenti(){
		
		List<Dokument> aa = dokumentRepository.findAll();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Dokument dokument = (Dokument) iterator.next();
			 dokument.setAkcija("<a href=\"update_dokument.html?id=" + dokument.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "    <a href=\"delete_dokument.html?id=" + dokument.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>"
					+  "<a href=\"www.w3schools.com\">Visit W3Schools</a> "
					+ "     <a href=\"view_dokument_items.html?id=" + dokument.getId()  + "\"> " + "<i class=\"fa fa-id-card-o\"></i> </a>");
			 
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

		        Date tt = dokument.getDatumVreme();
//		        dokument.setVideo(simpleDateFormat.format(tt));

		}

		return aa; 
	}
	
	@RequestMapping(path="/zapisnici", method=RequestMethod.GET)
	public List<Zapisnici> getJsonZapisnici(){
		
		List<Zapisnici> aa = zapisniciRepository.findAll();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Zapisnici zapisnik = (Zapisnici) iterator.next();
			 zapisnik.setAkcija("<a href=\"update-zapisnik.html?id=" + zapisnik.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "    <a href=\"delete_dokument.html?id=" + zapisnik.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>"
					+  "<a href=\"www.w3schools.com\">Visit W3Schools</a> "
					+ "     <a href=\"view_dokument_items.html?id=" + zapisnik.getId()  + "\"> " + "<i class=\"fa fa-id-card-o\"></i> </a>");
			 
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

		        //Date tt = zapisnik.getDatumVreme();
//		        dokument.setVideo(simpleDateFormat.format(tt));

		}

		return aa; 
	}	
	
	@RequestMapping(path="/dokumentstavketest1", method=RequestMethod.GET)
	public List<DokumentStavke> getJsonDokumentiStavkeRest(@RequestParam(value="id") Long id){

		Dokument aa1 = dokumentRepository.findOne(id);
		
		// netreba definisati findByIdDokument u querijima defoltno postoji
		List<DokumentStavke> aa = dokumentStavkeRepository.findByIdDokument(aa1);

		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 DokumentStavke dokument = (DokumentStavke) iterator.next();
			 dokument.setAkcija("<a href=\"update_dokumentistavke.html?id=" + dokument.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_dokumentistavke.html?id=" + dokument.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");


		}

		return aa; 
	}		
		
	@RequestMapping(path="/dokumentstavketest", method=RequestMethod.GET)
	public List<DokumentStavke> getJsonDokumentiStavkeTest(){


		
		// netreba definisati findByIdDokument u querijima defoltno postoji
		List<DokumentStavke> aa = dokumentStavkeRepository.findAll();

		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 DokumentStavke dokument = (DokumentStavke) iterator.next();
			 dokument.setAkcija("<a href=\"update_dokumentistavke.html?id=" + dokument.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_dokumentistavke.html?id=" + dokument.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");


		}

		return aa; 
	}
	

	
	@RequestMapping(path="/typesofdocuments", method=RequestMethod.GET)
	public List<TypesOfDocuments> getJsonTypesOfDocuments(){
		
		List<TypesOfDocuments> aa = typesOfDocumentsRepository.findAll();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 TypesOfDocuments dokument = (TypesOfDocuments) iterator.next();
			 dokument.setAkcija("<a href=\"update_typesOfDocuments.html?id=" + dokument.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete_typesOfDocuments.html?id=" + dokument.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
			 
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy'");
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

//		        Date tt = dokument.getDatumVreme();
//		        dokument.setVideo(simpleDateFormat.format(tt));

		}

		return aa; 
	}
	
	
	@RequestMapping(path="/magacinii", method=RequestMethod.GET)
	public List<Magacini> getJsonArticlesTypesM(){
		
		List<Magacini> aa = magaciniRepository.findAll();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Magacini magacini = (Magacini) iterator.next();
			 magacini.setAkcija("<a href=\"update-vrste-artikala.html?id=" + magacini.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-vrste-artikala.html?id=" + magacini.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
		}

		return aa; 
	}	
	
	@RequestMapping(path="/partneri", method=RequestMethod.GET)
	public List<Partner> getJsonArticlesTypesP(){
		
		List<Partner> aa = costumersRepository.findAll();
	
		 for (Iterator iterator = aa.iterator(); iterator.hasNext();) {
			 Partner magacini = (Partner) iterator.next();
			 magacini.setAkcija("<a href=\"update-vrste-artikala.html?id=" + magacini.getId() + "\"> " + "<i class=\"fa fa-pencil-square-o edit-delete-icon\"></i> </a> "
					+ "            <a href=\"delete-vrste-artikala.html?id=" + magacini.getId() + "\" Onclick=\"return ConfirmDelete();\"> " + "<i class=\"fa fa-trash-o edit-delete-icon\"></i> </a>");
		}

		return aa; 
	}	
	
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		}

}
