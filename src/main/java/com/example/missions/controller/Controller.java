package com.example.missions.controller;

import com.example.missions.dao.MissionDao;
import com.example.missions.dao.RecommandationDao;
import com.example.missions.dao.SuivisDao;
import com.example.missions.entities.Mission;
import com.example.missions.entities.Recommandation;
import com.example.missions.entities.Suivis;
import com.example.missions.services.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@org.springframework.stereotype.Controller
@RequestMapping(value = "controle")
public class Controller {

    @Autowired
    RecommandationDao recommandationDao;

    @Autowired
    SuivisDao suivisDao;

    @Autowired
    MissionDao missionDao;

    @Autowired
    RecommandationService service;



    @RequestMapping(value = "afficher")
    public String index(Model model) {
       ArrayList<String> coun =service.count();
       String find =service.find();
        Double count = service.coun();

        model.addAttribute("count",  count);
        model.addAttribute("find",  find);

        model.addAttribute("recommandations",  recommandationDao.findAll());
        model.addAttribute("suivi",  suivisDao.findAll());
        model.addAttribute("title", "Liste des recommandations");

        return "controle/afficher";
    }



//    @RequestMapping("/count")
//    public ModelAndView count() {
//        String coun =service.count();
//
//        ModelAndView mav = new ModelAndView("controle/afficher");
//        mav.addObject("coun", coun);
//
//        return mav;
//    }


//    @RequestMapping(value = "addrecommandation", method = RequestMethod.GET)
//    public String displayAddProcessForm(Model model) {
//
//        model.addAttribute("title", "Add Risk Detail");
//        model.addAttribute(new Recommandation());
//        model.addAttribute("recommandation", recommandationDao.findAll());
//
//        return "controle/addrecommandation";
//    }
//
//    @RequestMapping(value = "addrecommandation", method = RequestMethod.POST)
//    public String processAddProcessForm(@ModelAttribute @Valid Recommandation newRecommandation,
//                                        Errors errors, @RequestParam Long  suiviId, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Recommandation Detail");
//            model.addAttribute("recommandation", recommandationDao.findAll());
//
//            return "controle/addrecommandation";
//        }
//
//        Suivis suivi = suivisDao.findById(suiviId).orElseThrow(() -> new IllegalArgumentException("Invalid suivi Id:" + suiviId));
//        ;
//        newRecommandation.setSuivis(suivi);
//
//        recommandationDao.save(newRecommandation);
//
//        return "redirect:/controle/afficher/";
//
//    }
@RequestMapping(value = "addrec", method = RequestMethod.GET)
public String displayAddProcessForm(Model model) {

    model.addAttribute("title", "Add Recommandation");
    model.addAttribute(new Recommandation());
    model.addAttribute("suivi", suivisDao.findAll());


    return "controle/addrec";
}

    @RequestMapping(value = "addrec", method = RequestMethod.POST)
    public String processAddProcessForm(@ModelAttribute @Valid Recommandation newRecommandation,
                                        Errors errors, @RequestParam Long suiviId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recommandation");
            model.addAttribute("suivi", suivisDao.findAll());


            return "controle/addrec";
        }

        Suivis suivis = suivisDao.findById(suiviId).orElseThrow(() -> new IllegalArgumentException("Invalid suivi Id:" + suiviId));
        newRecommandation.setSuivis(suivis);
        recommandationDao.save(newRecommandation);

        return "redirect:/controle/afficher/";

    }
    @RequestMapping("/edit_product/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long  id) {
        ModelAndView mav = new ModelAndView("controle/edit_product");
        mav.addObject("suivi",suivisDao.findAll());
        Recommandation recommandation= service.get(id);
        mav.addObject("recommandation", recommandation );

        return mav;
    }
//    @RequestMapping("/afficherrec/{id}")
//    public ModelAndView showEditForm(@PathVariable(name = "id") Long  id) {
//        ModelAndView mav = new ModelAndView("controle/afficherrec");
//        mav.addObject("suivi",suivisDao.findAll());
//        Mission recommandation= service.get(id);
//        mav.addObject("mission", recommandation );
//
//        return mav;
//    }

    @RequestMapping(value = "suivi", method = RequestMethod.GET)
    public String domaine(Model model, Long id) {

        Suivis suivis= suivisDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
        Set<Recommandation> recommandations = suivis.getRecommandations();
        model.addAttribute("recommandation", recommandations);
        model.addAttribute("title", "recommandation In suivi: " + suivis.getConstats());
        return "index";

    }



}
