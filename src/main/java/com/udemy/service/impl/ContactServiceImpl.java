package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.converter.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
	
	private static final Log LOG = LogFactory.getLog(ContactServiceImpl.class);
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ContactConverter contactConverter;

	public ContactModel addContact(ContactModel contactModel) {
		LOG.info("Entrada método addContact");
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		return contactConverter.convertContactToContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		LOG.info("Entrada método listAllContacts");
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<>();
		for(Contact contact: contacts) {
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		LOG.info("Entrada método findContactById");
		return contactRepository.findById(id);
	}

	@Override
	public ContactModel findContactModelById(int id) {
		LOG.info("Entrada método findContactModelById");
		Contact contact = contactRepository.findById(id);
		return contactConverter.convertContactToContactModel(contact);
	}

	@Override
	public void removeContact(int id) {
		LOG.info("Entrada método removeContact");
		Contact contact = contactRepository.findById(id);
		if(contact != null) {			
			contactRepository.delete(contact);
		}
	}

}
