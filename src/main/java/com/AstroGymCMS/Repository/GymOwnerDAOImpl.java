package com.AstroGymCMS.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.AstroGymCMS.Model.GymOwner;
import com.AstroGymCMS.Services.RecordNotFoundException;

@Repository
public class GymOwnerDAOImpl {

	@Autowired
	GymOwnerRepository repository;

	@Transactional
	public GymOwner getGymOwnerById(int id) throws RecordNotFoundException {
		Optional<GymOwner> gymOwner = repository.findById(id);

		if (gymOwner.isPresent()) {
			return gymOwner.get();
		} else {
			throw new RecordNotFoundException("No Gym Owner record exist for given id");
		}
	}

	@Transactional
	public GymOwner createGymOwner(GymOwner entity) {
		return repository.save(entity);
	}

	@Transactional
	public GymOwner updateGymOwner(GymOwner entity) throws RecordNotFoundException {
		return repository.save(entity);
	}

	/*
	 * @Transactional public List<GymOwner> getAllGymOwner(Integer pageNo,
	 * Integer pageSize, String sortBy) { Pageable paging =
	 * PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
	 * 
	 * Page<GymOwner> pagedResult = repository.findAll(paging);
	 * 
	 * if (pagedResult.hasContent()) { return pagedResult.getContent(); } else {
	 * return new ArrayList<GymOwner>(); } }
	 */

	/*
	 * @Transactional public void deleteGymOwnerById(int id) throws
	 * RecordNotFoundException { Optional<GymOwner> GymOwner =
	 * repository.findById(id);
	 * 
	 * if (GymOwner.isPresent()) { repository.deleteById(id); } else { throw new
	 * RecordNotFoundException("No Gym User record exist for given id"); } }
	 */

}
