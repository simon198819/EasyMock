package com.abhinav.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;

import com.abhinav.dao.ContactDao;
import com.abhinav.model.Contact;

public class ContactServiceTest {
	
	private static ContactServiceImpl service = null;
	
	@BeforeClass
	public static void init() {
		//Creating proxy
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);
		
		//setting behavior for proxy
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Abhinav");
//		EasyMock.expect(daoProxy.findNameById(102)).andReturn("Ajit");
		
		List<String> names = new ArrayList<String>();
		names.add("Abhinav");
		names.add("Devesh");
		names.add("Anuj");
		names.add("Sourav");
		//Set the behaviour for mock obj
		EasyMock.expect(daoProxy.findNames()).andReturn(names);
		
		//Setting behaiour for dao method-3
		Contact c = new Contact();
		c.setContactId(101);
		c.setContactName("Domnic");
		c.setContactNumber(999987864);
		EasyMock.expect(daoProxy.findById(101)).andReturn(c);
		
		//Saving proxy behaviour
		EasyMock.replay(daoProxy);
		
		//Injection proxy obj into target obj
		service = new ContactServiceImpl();
		service.setContactDao(daoProxy);
	}
	
	@Test
	public void testGetNameById_01() {
		String name = service.getNameById(101);
		assertNotNull(name);
		System.out.println(name);
	}
	
	@Test
	public void testGetAllName_02(){
		List<String> allNames = service.getAllContactNames();
		assertNotNull(allNames);
		System.out.println(allNames);
	}
	
	@Test
	public void testGetContactById_03() {
		Contact contact = service.getContactById(101);
		assertNotNull(contact);
		System.out.println(contact);
	}

}
