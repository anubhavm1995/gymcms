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

import com.AstroGymCMS.Model.GymUser;
import com.AstroGymCMS.Repository.GymUserRepository;

@Service
public class GymUserService {
     
    @Autowired
    GymUserRepository repository;
    
    @Transactional
    public List<GymUser> getAllGymUser(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<GymUser> pagedResult = repository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<GymUser>();
        }
    }
    
    @Transactional
    public GymUser getGymUserById(int id) throws RecordNotFoundException
    {
        Optional<GymUser> gymUser = repository.findById(id);
         
        if(gymUser.isPresent()) {
            return gymUser.get();
        } else {
            throw new RecordNotFoundException("No Gym User record exist for given id");
        }
    }
    
    @Transactional
    public GymUser createOrUpdateGymUser(GymUser entity) throws RecordNotFoundException
    {
        Optional<GymUser> gymUser = repository.findById(entity.getUserId());
        
        if(gymUser.isPresent())
        {
            GymUser newEntity = gymUser.get();
            newEntity.setUserfullName(entity.getUserfullName());
            newEntity.setUserEmailId(entity.getUserEmailId());
            newEntity.setUserMobileNo(entity.getUserMobileNo());
            newEntity.setUserGender(entity.getUserGender());
            newEntity = repository.save(newEntity);
            return newEntity;
        } 
        else {
            entity = repository.save(entity);
            return entity;
        }
    }
    
    @Transactional
    public void deleteGymUserById(int id) throws RecordNotFoundException
    {
        Optional<GymUser> gymUser = repository.findById(id);
         
        if(gymUser.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Gym User record exist for given id");
        }
    }
}