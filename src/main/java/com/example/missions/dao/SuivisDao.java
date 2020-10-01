package com.example.missions.dao;

import com.example.missions.entities.Suivis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Repository
@Transactional
public interface SuivisDao extends CrudRepository<Suivis,Long> {


    @Query(value = "SELECT (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Suivis r"
    )

    Double coun();

    @Query(value = "SELECT r.incharge,  (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Suivis r group by r.incharge"
    )
//
//    Double sum();
//

    List<String> sum();

//        @Query(value = "SELECT distinct r, (SELECT (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Suivis r) FROM Suivis r group by r.incharge"
//    )
////
//        HashSet<String> sum();
}
