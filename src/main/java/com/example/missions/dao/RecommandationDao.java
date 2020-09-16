package com.example.missions.dao;

import com.example.missions.entities.Recommandation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;

@Repository
@Transactional
public interface RecommandationDao extends CrudRepository<Recommandation,Long> {

    @Query(value = "SELECT r.incharge,  (sum (r.tauxavancement * r.ponderation)) /(sum (r.ponderation)) FROM Recommandation r group by r.incharge"
    )
//
//    Double sum();
//

    String sum();
//    HashSet<String> sum();

}
