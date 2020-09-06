package com.AstroGymCMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AstroGymCMS.Model.GymOwner;
import com.AstroGymCMS.Services.GymOwnerService;
import com.AstroGymCMS.Services.RecordNotFoundException;

@RestController
@RequestMapping("/owner")
public class GymOwnerController {

	@Autowired
	GymOwnerService service;

	@GetMapping("/home")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Hi there !!", new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GymOwner> getEmployeeById(@PathVariable("id") int id) throws RecordNotFoundException {
		GymOwner entity = service.getGymOwnerById(id);

		return new ResponseEntity<GymOwner>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/saveOwner")
	public ResponseEntity<GymOwner> createOrUpdateEmployee(@RequestBody GymOwner gymOwner) throws RecordNotFoundException {
		GymOwner updated = service.createOrUpdateGymOwner(gymOwner);
		if()
		return new ResponseEntity<GymOwner>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteGymOwnerById(@PathVariable("id") int id) throws RecordNotFoundException {
		service.deleteGymOwnerById(id);
		return HttpStatus.FORBIDDEN;
	}

}