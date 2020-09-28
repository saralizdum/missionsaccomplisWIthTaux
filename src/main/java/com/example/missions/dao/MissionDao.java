package com.example.missions.dao;

import com.example.missions.entities.Mission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface MissionDao extends CrudRepository<Mission,Long> {

    @Query(value = "SELECT distinct m.intitule FROM Mission m "
    )
//    Double sum();
//    String sum();
   String find();

    @Query(value = "SELECT  m.intitule FROM Mission m "
    )
//    Double sum();
//    String sum();

    ArrayList<String> sum();



}
