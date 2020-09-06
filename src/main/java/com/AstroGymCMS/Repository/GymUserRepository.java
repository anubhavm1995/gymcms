package com.AstroGymCMS.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.AstroGymCMS.Model.GymUser;
 
@Repository
public interface GymUserRepository extends PagingAndSortingRepository<GymUser, Integer> {
 
}