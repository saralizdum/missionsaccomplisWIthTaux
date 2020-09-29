package com.example.missions.dao;

import com.example.missions.entities.Filiale;
import com.example.missions.entities.Mission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface FilialeDao extends CrudRepository<Filiale,Long> {




}
