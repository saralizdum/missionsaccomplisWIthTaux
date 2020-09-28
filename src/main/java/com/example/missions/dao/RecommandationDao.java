package com.example.missions.dao;

import com.example.missions.entities.Recommandation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
@Transactional
public interface RecommandationDao extends CrudRepository<Recommandation,Long> {


    @Query(value = "SELECT distinct r.incharge, (SELECT (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Recommandation r) FROM Recommandation r group by r.incharge"
    )
//
//    Double sum();
////

    String sum();
//    @Query(value = "SELECT  r.incharge , (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Recommandation r group by r.incharge"
//    )
////    Double sum();
////    String sum();
//
//    List<String> sum();
//    HashSet<String> sum();

    @Query(value = "SELECT (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Recommandation r "
    )

    Double coun();
//


    @Query(value = "SELECT m.intitule FROM Recommandation r left outer  join Suivis s on s.id=r.suivis.id left " +
            "outer join Mission m on m.id=s.mission.id"
    )
//
//    Double sum();
////

    String find();




}
