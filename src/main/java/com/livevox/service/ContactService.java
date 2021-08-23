package com.livevox.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.livevox.model.PhoneBookUser;

@Component
public interface ContactService {

	// Post Methods
	PhoneBookUser saveContact(PhoneBookUser userContact);

	//public List<PhoneBookUser> saveContacts(List<PhoneBookUser> userContacts) {
	Iterable<PhoneBookUser> saveContacts(List<PhoneBookUser> userContacts);

	// Get Methods
	Iterable<PhoneBookUser> getContactByString(String sString);

	Iterable<PhoneBookUser> getContacts();

	// Delete Contact
	String deleteContactById(int id);

	// Update Contact
	PhoneBookUser updateContactById(PhoneBookUser userContact);

}