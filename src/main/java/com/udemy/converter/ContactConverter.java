package com.udemy.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component
public class ContactConverter {
	
	private static final Log LOG = LogFactory.getLog(ContactConverter.class);
	
	public Contact convertContactModelToContact(ContactModel contactModel) {
		LOG.info("Entrada método convertContactModelToContact");
		Contact contact = new Contact();
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setId(contactModel.getId());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}

	public ContactModel convertContactToContactModel(Contact contact) {
		LOG.info("Entrada método convertContactToContactModel");
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setId(contact.getId());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}

}
