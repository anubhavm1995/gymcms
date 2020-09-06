package com.AstroGymCMS.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.AstroGymCMS.Model.GymUser;
 
@Repository
public interface GymRepository extends PagingAndSortingRepository<GymUser, Integer> {
 
}