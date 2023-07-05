package com.greenStitch.assignment.dto;


public class AuthenticationRequest {
    private String username;
    private String password;

    // Constructors, getters, and setters
    

    public AuthenticationRequest() {
    }

    @Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + "]";
	}

	public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
