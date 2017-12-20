package com.hellokoding.auth.controllers;

import com.hellokoding.auth.model.Magacini;
import com.hellokoding.auth.repository.MagaciniRepository;
import com.hellokoding.auth.service.ICarService;
import com.hellokoding.auth.service.JediniceMeraService;
import com.hellokoding.auth.service.MagaciniService;
import com.hellokoding.auth.service.VrstePaletaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
public class PrintController {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private ICarService carService;
    @Autowired
    private VrstePaletaService vrstePaletaService;
    @Autowired
    private MagaciniService magaciniService;
    @Autowired
    private MagaciniRepository magaciniRepository;
    @Autowired
    private JediniceMeraService jediniceMeraService;
    
    @RequestMapping(path = "/pdf", method = RequestMethod.GET)
    public ModelAndView report() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:report2.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", carService.findAll());

        return new ModelAndView(view, params);
    }
    
    @RequestMapping(path = "/vrste_paleta_pdf.html", method = RequestMethod.GET)
    public ModelAndView report1() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_VrstePaleta.jrxml");
        view.setApplicationContext(appContext);
       

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", vrstePaletaService.getAllVrstePaleta());

        return new ModelAndView(view, params);
    }
    
    @RequestMapping(path = "/magacini_pdf.html", method = RequestMethod.GET)
    public ModelAndView report2() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:rpt_Magacin2.jrxml");
        view.setApplicationContext(appContext);
       
        List<Magacini> addressObjArray = magaciniRepository.rptMagacini();
        
 //   	List<Object[]> addressObjArray = query.list();
		for(Magacini row : addressObjArray){

				System.out.print(row + "::");

			System.out.println("\n");
		}
        Map<String, Object> params = new HashMap<>();
        
        
        params.put("datasource", magaciniRepository.rptMagacini()); // .getAllMagacini());

        return new ModelAndView(view, params);
    }
    
//    @RequestMapping(path = "/units_of_measure_pdf.html", method = RequestMethod.GET)
//    public ModelAndView report4() {
//
//        JasperReportsPdfView view = new JasperReportsPdfView();
//        view.setUrl("classpath:rpt_Items1.jrxml");
//        view.setApplicationContext(appContext);
//       
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("datasource", jediniceMeraService.getAllJediniceMera());
//        params.put("title", "Jedinice Mera");
//        return new ModelAndView(view, params);
//    }
}
