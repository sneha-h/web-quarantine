package com.glarimy.cmad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class IncidentController {

	@Autowired
	private IncidentRepository repo;

	@RequestMapping(path = "/incident", method = RequestMethod.POST)
	public ResponseEntity<Incident> addIncident(@RequestBody Incident Incident) {
		repo.save(Incident);
		return new ResponseEntity<Incident>(Incident, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/incident/{id}", method = RequestMethod.GET)
	public ResponseEntity<Incident> findById(@PathVariable int id) {
		try {
			Incident inc = repo.findById(id).orElseThrow(()-> new Exception());
		    return new ResponseEntity<Incident>(inc, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Incident>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@RequestMapping(path="/incident", method = RequestMethod.GET)
	public ResponseEntity<List<Incident>> searchByCustomerId(@RequestParam(value = "cid") Integer cid, 
			@RequestParam(value = "offset", defaultValue = "50") int offset) {
		try {
			List<Incident> inc = repo.findByCid(cid);
			return new ResponseEntity<List<Incident>>(inc, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<List<Incident>>(HttpStatus.NOT_FOUND);
        }	
	}
	
	/*@RequestMapping(path="/incident", method = RequestMethod.GET)
	public ResponseEntity<List<Incident>> searchByCidandVerdict(@RequestParam(value = "cid") Integer cid, 
			@RequestParam(value = "verdict") String verdict) {
		try {
			Page<Incident> inc = repo.findByCidAndVerdict(cid, verdict, PageRequest.of(1,3));
			return new ResponseEntity<List<Incident>>(inc.getContent(), HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<List<Incident>>(HttpStatus.NOT_FOUND);
        }	
	}*/
	

	// Allowed by admin
	/*@RequestMapping(path="/incident/", method = RequestMethod.GET)
	public ResponseEntity<List<Incident>> search(@RequestParam(value = "verdict") String v, 
			@RequestParam(value = "offset", defaultValue = "50") int offset) {
		try {
			List<Incident> inc1 = repo.findByVerdict(v);
			return new ResponseEntity<List<Incident>>(inc1, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<List<Incident>>(HttpStatus.NOT_FOUND);
        }	
	}*/
	
	
	@RequestMapping(path = "/incidents", method = RequestMethod.GET)
	public ResponseEntity<List<Incident>> listAllIncidents() {
		try{
			List<Incident> Incidents = repo.findAll();
		    return new ResponseEntity<List<Incident>>(Incidents, HttpStatus.OK); 
		} catch (Exception e) {
		    return new ResponseEntity<List<Incident>>(HttpStatus.NOT_FOUND);
        }
	}
	
	@RequestMapping(path = "/incident/{id}", method = RequestMethod.DELETE)
	 public void deleteIncident(@PathVariable int id) {
	     repo.deleteById(id);
	 }
	
	// Allowed only by admin
	@RequestMapping(path = "/incident/", method = RequestMethod.DELETE)
	 public void deleteAllIncident() {
	     repo.deleteAll();
	 }
	
	// Allowed only by admin
	@RequestMapping(path="/incident", method = RequestMethod.DELETE)
	public void deleteByCustomerId(@RequestParam(value = "customer id") Integer cid) {
			repo.deleteById(cid);
	}
	
}
