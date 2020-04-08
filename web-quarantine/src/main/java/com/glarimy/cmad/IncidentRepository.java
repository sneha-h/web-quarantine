package com.glarimy.cmad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends MongoRepository<Incident, Integer> {
	public List<Incident> findByCid(Integer cid);
	//public List<Incident> findByVerdict(String verdict);
	//public Page<Incident> findByCidAndVerdict(Integer cid, String verdict, Pageable page);
}
