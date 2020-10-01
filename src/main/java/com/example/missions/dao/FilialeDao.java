package com.example.missions.dao;

import com.example.missions.entities.Filiale;
import com.example.missions.entities.Mission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface FilialeDao extends CrudRepository<Filiale,Long> {


    @Query(value = "SELECT f FROM Filiale f WHERE f.Nom LIKE '%' || :keyword || '%'"
    )
    public List<Filiale> search(@Param("keyword") String keyword);

}
