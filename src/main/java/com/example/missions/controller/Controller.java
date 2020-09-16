package com.example.missions.controller;

import com.example.missions.dao.MissionDao;
import com.example.missions.dao.RecommandationDao;
import com.example.missions.dao.SuivisDao;
import com.example.missions.entities.Recommandation;
import com.example.missions.entities.Suivis;
import com.example.missions.services.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
        model.addAttribute("recommandations",  recommandationDao.findAll());
        model.addAttribute("title", "Liste des recommandations");

        return "controle/afficher";
    }


    @RequestMapping("/count")
    public ModelAndView count() {


        String coun =service.count();
        ModelAndView mav = new ModelAndView("controle/count");
        mav.addObject("coun", coun);

        return mav;
    }


    @RequestMapping(value = "addriskd", method = RequestMethod.GET)
    public String displayAddProcessForm(Model model) {

        model.addAttribute("title", "Add Risk Detail");
        model.addAttribute(new Recommandation());
        model.addAttribute("recommandation", recommandationDao.findAll());

        return "controle/addrecommandation";
    }

    @RequestMapping(value = "addrecommandation", method = RequestMethod.POST)
    public String processAddProcessForm(@ModelAttribute @Valid Recommandation newRecommandation,
                                        Errors errors, @RequestParam Long  suiviId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Risk Detail");
            model.addAttribute("recommandation", recommandationDao.findAll());

            return "controle/addrecommandation";
        }

        Suivis suivi = suivisDao.findById(suiviId).orElseThrow(() -> new IllegalArgumentException("Invalid suivi Id:" + suiviId));
        ;
        newRecommandation.setSuivis(suivi);

        recommandationDao.save(newRecommandation);

        return "redirect:/controle/afficher/";

    }


    @RequestMapping(value = "suivi", method = RequestMethod.GET)
    public String domaine(Model model, Long id) {

        Suivis suivis= suivisDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid  Id:" + id));
        Set<Recommandation> recommandations = suivis.getRecommandations();
        model.addAttribute("recommandation", recommandations);
        model.addAttribute("title", "recommandation In suivi: " + suivis.getConstats());
        return "index";

    }



}
