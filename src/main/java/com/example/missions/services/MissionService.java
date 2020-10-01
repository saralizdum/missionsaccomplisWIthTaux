package com.example.missions.services;



import com.example.missions.dao.FilialeDao;
import com.example.missions.dao.MissionDao;
//import com.example.missions.dao.RecommandationDao;
import com.example.missions.dao.SuivisDao;
import com.example.missions.entities.Filiale;
import com.example.missions.entities.Mission;
//import com.example.missions.entities.Recommandation;
import com.example.missions.entities.Suivis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MissionService {

//    @Autowired
//    RecommandationDao recommandationDao;

    @Autowired
    MissionDao missionDao;
    @Autowired
    SuivisDao suivisDao;

    @Autowired
    FilialeDao filialeDao;



    public Mission get(Long id) {
        return  missionDao.findById(id).get();
    }
//    public Recommandation gt(Long id) {
//        return  recommandationDao.findById(id).get();
//    }
public double coun()
{
    return suivisDao.coun();
}
public List<String> sum(){
        return suivisDao.sum();
}
//    public HashSet<String> count()
//    {
//        return suivisDao.sum();
//    }
    public Suivis gett(Long id) {
        return  suivisDao.findById(id).get();
    }

    public Filiale ge(Long id) {
        return  filialeDao.findById(id).get();
    }

    public List<Mission> search(String keyword) {
        return missionDao.search(keyword);
    }


}
