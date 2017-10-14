package com.stackroute.github.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.github.exceptions.UserAlreadyExistException;
import com.stackroute.github.exceptions.UserNotExistException;
import com.stackroute.github.model.UserDetails;
import com.stackroute.github.services.GitHubServices;
import com.stackroute.github.exceptions.UserAlreadyExistException;
import com.stackroute.github.model.UserDetails;
import com.stackroute.github.model.UserDetails;

@RestController
public class GitHubControllers {
	
	@Autowired
	private GitHubServices gs;
	
//	@RequestMapping(value="/savedetails", method = RequestMethod.POST)
//	public String getDetails(@RequestBody UserDetails u) {
//		gs.addDetails(u);
//		return "User saved successfully";
//	}
	
//	@RequestMapping(value="/getdetails", method = RequestMethod.GET)
//	public List<UserDetails> getAllDetails() {
//		return gs.getAllDetails1();
//		
//	}
//	
//	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
//     public void deleteId(@PathVariable int id) {
//		gs.delete(id);
//	}
	
//	@RequestMapping(value="/getdetails", method = RequestMethod.GET)
//	public ResponseEntity getAllDetails() {
//		if(gs.getAllDetails1() == null)
//			return new ResponseEntity<String>("Database is empty",HttpStatus.PARTIAL_CONTENT);
//		else
//			return new ResponseEntity<List<UserDetails>>(gs.getAllDetails1(),HttpStatus.OK);
//		
//		
//	}
//--------------------------START: Using POST for adding New User--------------------------------	
	@RequestMapping(value="/user/add", method = RequestMethod.POST)
    public ResponseEntity addNewUser(RequestEntity<UserDetails>  u) throws Exception  {
		try {
			
		if( u.getBody().getRepos() == null || u.getBody().getUsername()== null) {
			
			return new ResponseEntity<String>("Insufficient parameter",HttpStatus.PARTIAL_CONTENT);
			
		}
		else
		    {
		
			gs.addDetails(u.getBody());
			return new ResponseEntity<String>("User saved successfully",HttpStatus.OK);
			
		    }
		}
		catch(UserAlreadyExistException uaee)
		{
		
			System.out.println(uaee.getMessage());
			return new ResponseEntity<String>("Data already exists",HttpStatus.CONFLICT);
		}
    	
    }
//------------------------------END: Using POST for adding New User--------------------------------	
	
//	----------------------------START: Using GET for getting All Users-----------------------------
    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity getAllDetails () {
    	
    	if(gs.getAllDetails1() == null) {
    		
    		return new ResponseEntity<String>("Empty Database", HttpStatus.PARTIAL_CONTENT);
    	}
    	
    	else 
    	{
    		return new ResponseEntity<List<UserDetails>> (gs.getAllDetails1(), HttpStatus.OK);
   
        }

	}
//  ------------------------------END: Using GET for getting All Users-----------------------------
    
// -------------------------------START: Using DELETE for deleting User by Id-----------------------
    
    @RequestMapping(value="/user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById (@PathVariable int id) {
    	
    	try {
    		gs.delete(id);
    		 return new ResponseEntity<String> ("Succesful Deletion of User", HttpStatus.OK);
    	}
    	catch (UserNotExistException unee) {
    		System.out.println(unee.getMessage());
    		return new ResponseEntity<String> ("Data doesnot exist", HttpStatus.NOT_FOUND);
    	}
    }
    
// ---------------------------------END: Using DELETE for deleting User by Id-----------------------  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
