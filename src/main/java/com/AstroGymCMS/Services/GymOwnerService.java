package com.AstroGymCMS.Services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AstroGymCMS.Model.GymOwner;
import com.AstroGymCMS.Repository.GymOwnerDAOImpl;

@Service
public class GymOwnerService {

	@Autowired
	GymOwnerDAOImpl gymOwnerDAOImpl;

	public GymOwner getGymOwnerById(int id) throws RecordNotFoundException {

		GymOwner entity = gymOwnerDAOImpl.getGymOwnerById(id);

		return entity;
	}

	public GymOwner createGymOwner(GymOwner gymOwner_inp) throws Exception {
		if (gymOwner_inp.getOwnerId() != 0 ) {
			throw new Exception("You cannot save a new Gym owner with existing unique id");
		}
		
		gymOwner_inp.setOwnerStatus(true);
		LocalDate todaydate = LocalDate.now();
		gymOwner_inp.setOwnerDateOfJoining(todaydate);
		GymOwner gymOwner_new = gymOwnerDAOImpl.createGymOwner(gymOwner_inp);
		return gymOwner_new;
	}

	public GymOwner updateGymOwner(GymOwner gymOwner_inp) throws Exception {
		if (gymOwner_inp.getOwnerId() == 0) {
			throw new Exception("You have not provided the owner id to update the details");
		}
		GymOwner gymOwnerFoundInDB = gymOwnerDAOImpl.getGymOwnerById(gymOwner_inp.getOwnerId());

		gymOwnerFoundInDB.setOwnerFullName(gymOwner_inp.getOwnerFullName());

		gymOwnerFoundInDB.setOwnerGender(gymOwner_inp.getOwnerGender());

		GymOwner gymOwner_new = gymOwnerDAOImpl.updateGymOwner(gymOwnerFoundInDB);

		return gymOwner_new;
	}

}
