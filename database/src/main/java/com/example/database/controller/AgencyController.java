package com.example.database.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.model.Agency;
import com.example.database.repository.AgencyRepository;

@RestController
@RequestMapping("/api")
public class AgencyController {

	@Autowired
	AgencyRepository agencyRepository;

	@GetMapping("/agency")
	public ResponseEntity<List<Agency>> getAllAgency(@RequestParam(required = false) String traveller_id) {
		try {
			List<Agency> agency = new ArrayList<Agency>();

			if (traveller_id == null)
				agencyRepository.findAll().forEach(agency::add);

			if (agency.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(agency, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/agency/{id}")
	public ResponseEntity<Agency> getAgencyById(@PathVariable("id") long id) {
		Optional<Agency> agencyData = agencyRepository.findById(id);

		if (agencyData.isPresent()) {
			return new ResponseEntity<>(agencyData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/agency")
	public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
		try {
			Agency _agency = agencyRepository
					.save(new Agency(agency.gettraveller_id(), agency.gettraveller_name(), agency.getbooking_date(), agency.gettravelling_place()));
			return new ResponseEntity<>(_agency, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/agency/{id}")
	public ResponseEntity<Agency> updateAgency(@PathVariable("id") long id, @RequestBody Agency agency) {
		Optional<Agency> agencyData = agencyRepository.findById(id);

		if (agencyData.isPresent()) {
			Agency _agency = agencyData.get();
			_agency.settraveller_id(agency.gettraveller_id());
			_agency.settraveller_name(agency.gettraveller_name());
			_agency.setbooking_date(agency.getbooking_date());
            _agency.settravelling_place(agency.gettravelling_place());
			return new ResponseEntity<>(agencyRepository.save(_agency), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/agency/{id}")
	public ResponseEntity<HttpStatus> deleteAgency(@PathVariable("id") long id) {
		try {
			agencyRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/agency")
	public ResponseEntity<HttpStatus> deleteAllAgency() {
		try {
			agencyRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}