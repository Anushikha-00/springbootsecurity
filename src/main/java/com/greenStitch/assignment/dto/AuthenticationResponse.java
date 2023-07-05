package com.greenStitch.assignment.dto;


public class AuthenticationResponse {
    private String token;

    // Constructors, getters, and setters

    public AuthenticationResponse() {
    }

    @Override
	public String toString() {
		return "AuthenticationResponse [token=" + token + "]";
	}

	public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
