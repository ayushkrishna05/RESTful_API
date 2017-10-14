package com.stackroute.github.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stackroute.github.exceptions.UserAlreadyExistException;
import com.stackroute.github.exceptions.UserNotExistException;
import com.stackroute.github.model.UserDetails;
import com.stackroute.github.repository.GitHubRepository;
import com.stackroute.github.exceptions.UserAlreadyExistException;
import com.stackroute.github.model.UserDetails;
import com.stackroute.github.model.UserDetails;

@Service
public class GitHubServices {
	
	@Autowired
	private GitHubRepository gr;
	
// --------------------------START: AddMethod--------------------------------------
	public void addDetails (UserDetails u)throws UserAlreadyExistException
	{
		if(gr.exists(u.getId())) {
			throw new UserAlreadyExistException (u.getUsername() + " Id already exist");
		}
		
		else
		gr.save(u);
	}
//----------------------------END: AddMethod-------------------------------------------
//	public void addDetails (@RequestBody UserDetails u)
//	{
//		
//		gr.save(u);
//	}
	
	
//----------------------------START: Getting All Details-------------------------------------
	public List<UserDetails> getAllDetails1() {
		
		List<UserDetails> l = new  ArrayList();
		gr.findAll().forEach(l::add);
		return  l;
	

}
//-----------------------------END: Getting All Details---------------------------------------

//-----------------------------START: Deleting by Id------------------------------------------
	public void delete(int id) throws UserNotExistException{
		if(gr.exists(id) == false) {
			throw new UserNotExistException(id + " does not exist");
		}
		else
		gr.delete(id);
		
		
	}
//-----------------------------END: Deleting by Id---------------------------------------------	
}
