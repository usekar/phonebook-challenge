package com.livevox.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livevox.model.PhoneBookUser;
import com.livevox.repository.ContactRepository;
import com.livevox.web.PhoneBookController;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

	// Post Methods
	@Transactional
	public PhoneBookUser saveContact(PhoneBookUser userContact) {
		logger.info("Saving for contact " + userContact.toString());
		return contactRepo.save(userContact);
	}

	
	@Transactional
	public Iterable<PhoneBookUser> saveContacts(List<PhoneBookUser> userContacts) {
		logger.info("Saving for contacts " + userContacts );
		return contactRepo.saveAll(userContacts);
	}

	// Get Methods
	@Transactional
	public Iterable<PhoneBookUser> getContactByString(String sString) {
		logger.info("Finding for contact " + sString);
		return contactRepo.findByFName(sString);
	}


	@Transactional
	public Iterable<PhoneBookUser> getContacts( ) {
		logger.info("getting ALL contacts "  );
		return contactRepo.findAll();
	}

	// Delete Contact
	@Transactional
	public String deleteContactById(int id) {
		logger.info("Deleting contact for " + id  );
		contactRepo.deleteById(id);
		return (id + " deleted the Phone book contact successfully !!");
	}

	// Update Contact
	@Transactional
	public PhoneBookUser updateContactById(PhoneBookUser userContact) {
		
		PhoneBookUser existingContact = contactRepo.findById(userContact.getId()).orElse(null);
		existingContact.setFirstName(userContact.getFirstName());
		existingContact.setLastName(userContact.getLastName());
		existingContact.setPhoneNumber(userContact.getPhoneNumber());
		logger.info(userContact.getId() + " updated successfully");
		return contactRepo.save(existingContact);
	}
}
