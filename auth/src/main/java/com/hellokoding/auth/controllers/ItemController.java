package com.hellokoding.auth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.websystique.springmvc.service.ItemService;
import com.hellokoding.auth.repository.DokumentStavkeRepository;
import com.hellokoding.auth.model.Dokument;
import com.hellokoding.auth.model.DokumentStavke;
import com.hellokoding.auth.repository.DokumentRepository;
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    DokumentStavkeRepository dokumentStavkeRepository;  //Service which will do all data retrieval/manipulation work
    @Autowired
    DokumentRepository dokumentRepository;  //Service which will do all data retrieval/manipulation work
 
	@RequestMapping(value="/ds")
    public ResponseEntity<List> listAllComputers() {
		System.out.println("*************************************ListAllComputers");
//		Dokument aa1 = dokumentRepository.findOne(id);
		
		// netreba definisati findByIdDokument u querijima defoltno postoji
//		List<DokumentStavke> aa = dokumentStavkeRepository.findByIdDokument(aa1);

    	List items = 	dokumentStavkeRepository.findAll(); //. ..findItemsByCategory("computers");
        if(items.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(items, HttpStatus.OK);
    }

	@RequestMapping(value="/ds/{id}")
    public ResponseEntity<Object> findSpecificComputer(@PathVariable("id") long id) {
		System.out.println("*************************************findSpecificComputer");
		Dokument aa1 = dokumentRepository.findOne(id);
		
		// netreba definisati findByIdDokument u querijima defoltno postoji
		List<DokumentStavke> aa = dokumentStavkeRepository.findByIdDokument(aa1);

    	Object item = dokumentStavkeRepository.findByIdDokument(aa1); //	itemService.findItemById(id, "computers");
        if(item == null){
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }

	


}
