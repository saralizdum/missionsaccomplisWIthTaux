package com.example.missions.services;



import com.example.missions.dao.RecommandationDao;
import com.example.missions.dao.SuivisDao;
import com.example.missions.entities.Recommandation;
import com.example.missions.entities.Suivis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommandationService {

    @Autowired
    RecommandationDao recommandationDao;

    @Autowired
    SuivisDao suivisDao;

    public List<String> count() {
        return recommandationDao.sum();
    }


    public String sum() {
        List<String> collection =  recommandationDao.sum();

        String count= collection.iterator().next();
        for(String value : collection){

            count =value;
        }
        return  count;
    }

//    public  String sum()
//    {
//        List<String> coun = recommandationDao.sum();
//
//        String count ="";
//        // for each loop
//        for  (Iterator it=coun.iterator();it.hasNext();)
//        {
//            String element = (String) it.next();
//           count= element;
//        }
////        for  (String str:coun)
////        {
////              count=str;
////        }
//
//        return count;

    public Recommandation get(Long id) {
        return recommandationDao.findById(id).get();
    }


    public double coun()
    {
        return recommandationDao.coun();
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
