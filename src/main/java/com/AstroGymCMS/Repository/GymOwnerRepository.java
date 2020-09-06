package com.AstroGymCMS.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.AstroGymCMS.Model.GymOwner;
 
@Repository
public interface GymOwnerRepository extends PagingAndSortingRepository<GymOwner, Integer> {
 
}