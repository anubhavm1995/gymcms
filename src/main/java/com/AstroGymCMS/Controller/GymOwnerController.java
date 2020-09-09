package com.AstroGymCMS.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AstroGymCMS.Model.GymOwner;
import com.AstroGymCMS.Services.GymOwnerService;
import com.AstroGymCMS.Services.RecordNotFoundException;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping("/owner")
public class GymOwnerController {

	@Autowired
	GymOwnerService service;

	@GetMapping("/hometest")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Hi there !!", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GymOwner> getGymOwnerById(@PathVariable("id") int id) throws RecordNotFoundException {
		GymOwner crtdGymOwnr = service.getGymOwnerById(id);

		return new ResponseEntity<GymOwner>(crtdGymOwnr, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/crtOwner")
	public ResponseEntity<GymOwner> createGymOwner(@Valid @RequestBody GymOwner gymOwner) throws Exception {

		GymOwner saved = service.createGymOwner(gymOwner);

		return new ResponseEntity<GymOwner>(saved, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/updtOwner")
	public ResponseEntity<GymOwner> updateGymOwner(@RequestBody GymOwner gymOwner) throws Exception {

		GymOwner updatedGymOwnr = service.updateGymOwner(gymOwner);

		return new ResponseEntity<GymOwner>(updatedGymOwnr, new HttpHeaders(), HttpStatus.OK);
	}
	
	
}