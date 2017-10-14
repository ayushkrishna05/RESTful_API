package com.stackroute.github.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="userdetails")
public class UserDetails {
        
	    @Id
	    private int id;
	    private String repos;
	    private String username;
	    private String url;
	    
	    
//       public UserDetails() {
//    	   
//       }
//	   public UserDetails(int id, String repos, String username, String url) {
//	        
//	        this.id = id;
//	        this.repos = repos;
//	        this.username = username;
//	        this.url = url;
//	    }

	    

	   public String getRepos() {
	        return repos;
	    }




	    public String getUsername() {
	        return username;
	    }




	    public String getUrl() {
	        return url;
	    }




	    public int getId() {
	        return id;
	    }

	 
	}