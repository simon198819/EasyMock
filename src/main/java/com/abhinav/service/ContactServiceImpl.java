package com.abhinav.service;

import java.util.List;

import com.abhinav.dao.ContactDao;
import com.abhinav.exception.NoDataFoundException;
import com.abhinav.model.Contact;

public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao;

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public String getNameById(Integer id) {
		String name = contactDao.findNameById(id);
		
		//logic
		String formattedName = name.toUpperCase();
		
		return formattedName;
	}


	public List<String> getAllContactNames() {
		List<String> name =	contactDao.findNames();
		if(!name.isEmpty()) {
			return name;
		}
			return null;
	}

	public Contact getContactById(Integer id) {
	Contact contacts = contactDao.findById(id);
	if(contacts == null) {
		throw new NoDataFoundException();
	}
		return contacts;
	}


}
