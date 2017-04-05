package au.com.ausland.ausland_application.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import au.com.ausland.ausland_application.model.AuslandUser;


public interface AuslandUserRepository extends CrudRepository<AuslandUser, Long> {

	AuslandUser findByUsername(String username);
    
    ArrayList<AuslandUser> findByActive(Boolean active);
  
}