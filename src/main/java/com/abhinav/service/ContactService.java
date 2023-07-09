package com.abhinav.service;

import java.util.List;

import com.abhinav.model.Contact;

public interface ContactService {
	
	public String getNameById(Integer id);
	
	public List<String> getAllContactNames();
	
	public Contact getContactById(Integer id);
}
