package com.example.missions.services;



import com.example.missions.dao.RecommandationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class RecommandationService {

    @Autowired
    RecommandationDao recommandationDao;

    public String count() {
        return recommandationDao.sum();
    }


//     public String sum (){
//         List<Object[]> list = recommandationDao.sum();
//       for (Object[] ob : list){
//             String serverName = (String)ob[0];
//            Integer count = (Integer)ob[1];
//            return count +" "+ serverName ;
//         }
//
//     }



}
