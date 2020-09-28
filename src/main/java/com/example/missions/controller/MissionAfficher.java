package com.example.missions.controller;

import com.example.missions.dao.MissionDao;
import com.example.missions.dao.RecommandationDao;
import com.example.missions.dao.SuivisDao;
import com.example.missions.entities.Mission;
import com.example.missions.entities.Recommandation;
import com.example.missions.entities.Suivis;
import com.example.missions.services.MissionService;
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
public class MissionAfficher {

    @Autowired
    RecommandationDao recommandationDao;

    @Autowired
    SuivisDao suivisDao;

    @Autowired
    MissionDao missionDao;


    @Autowired
    MissionService service;





    @RequestMapping(value = "affichermission")
    public String index(Model model) {


        model.addAttribute("missions",  missionDao.findAll());

        model.addAttribute("title", "Liste des missions");

        return "controle/affichermission";
    }

    @RequestMapping("/afficherrec/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long  id) {
        ModelAndView mav = new ModelAndView("controle/afficherrec");
        Mission mission=service.get(id);
       Suivis suivis=service.gett(id);
        mav.addObject("title", mission.getIntitule());
        mav.addObject("chef", mission.getChefmission() );
        mav.addObject("responsable", mission.getResponsableaudite() );
        mav.addObject("recommandation", suivis.getRecommandations());
        mav.addObject("mission", mission.getSuivis() );

        mav.addObject("id", mission.getId() );

        return mav;
    }



}
