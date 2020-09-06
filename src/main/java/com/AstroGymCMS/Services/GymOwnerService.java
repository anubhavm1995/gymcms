package com.AstroGymCMS.Services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.AstroGymCMS.Model.GymOwner;
import com.AstroGymCMS.Repository.GymOwnerRepository;

@Service
public class GymOwnerService {
     
    @Autowired
    GymOwnerRepository repository;
    @Transactional
    public List<GymOwner> getAllGymOwner(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<GymOwner> pagedResult = repository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<GymOwner>();
        }
    }
    @Transactional
    public GymOwner getGymOwnerById(int id) throws RecordNotFoundException
    {
        Optional<GymOwner> gymOwner = repository.findById(id);
         
        if(gymOwner.isPresent()) {
            return gymOwner.get();
        } else {
            throw new RecordNotFoundException("No Gym Owner record exist for given id");
        }
    }
    @Transactional
    public GymOwner createOrUpdateGymOwner(GymOwner entity) throws RecordNotFoundException
    {
        Optional<GymOwner> gymOwner = repository.findById(entity.getOwnerId());
        
        if(gymOwner.isPresent())
        {
            GymOwner newEntity = gymOwner.get();
            newEntity.setOwnerfullName(entity.getOwnerfullName());
            newEntity.setOwnerEmailId(entity.getOwnerEmailId());
            newEntity.setOwnerMobileNo(entity.getOwnerMobileNo());
            newEntity.setOwnerGender(entity.getOwnerGender());
            newEntity = repository.save(newEntity);
            return newEntity;
        } 
        else {
            entity = repository.save(entity);
            return entity;
        }
    }
    @Transactional
    public void deleteGymOwnerById(int id) throws RecordNotFoundException
    {
        Optional<GymOwner> GymOwner = repository.findById(id);
         
        if(GymOwner.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Gym User record exist for given id");
        }
    }
}