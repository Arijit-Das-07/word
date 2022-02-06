package com.word.wordguess.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIResponse {
	@JsonProperty("timestamp")
	private Timestamp timestamp = null;
	
	@JsonProperty("status")
    private int status;
	
	@JsonProperty("message")
    private String message;
	

	@JsonProperty("referenceNumber")
    private String referenceNumber;
	
	@JsonProperty("errors")
    private List<String> errors = new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

	Timestamp getTimestamp() {

		if(null == timestamp)
			timestamp = new Timestamp(new Date(System.currentTimeMillis()).getTime());
		
		return timestamp;
	}

	void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	public APIResponse()
	{
		super();
		timestamp = new Timestamp(new Date(System.currentTimeMillis()).getTime());
	}
	
	public APIResponse(int code, String message)
	{
		super();
		this.status = code;
		this.message = message;
		timestamp = new Timestamp(new Date(System.currentTimeMillis()).getTime());
	}
}
