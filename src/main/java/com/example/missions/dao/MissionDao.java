package com.example.missions.dao;

import com.example.missions.entities.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MissionDao extends CrudRepository<Mission,Long> {
}
