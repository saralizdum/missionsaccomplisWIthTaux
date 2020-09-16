package com.example.missions.dao;

import com.example.missions.entities.Suivis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SuivisDao extends CrudRepository<Suivis,Long> {
}
