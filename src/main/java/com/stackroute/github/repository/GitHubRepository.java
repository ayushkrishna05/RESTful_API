package com.stackroute.github.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.stackroute.github.model.UserDetails;

public interface GitHubRepository extends CrudRepository<UserDetails,Integer>{

}
