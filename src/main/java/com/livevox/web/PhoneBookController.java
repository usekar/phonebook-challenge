package com.livevox.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.livevox.model.PhoneBookUser;
import com.livevox.service.ContactService;

/**
 * Serves LiveVox Phonebook operations
 * 
 * @author Uday
 *
 */

@Controller
public class PhoneBookController {

	@Autowired
	private ContactService contactService;

	@Value("${application.message:Welcome to LiveVox !!}")
	private String welcomeMessage;

	Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

	@GetMapping("/")
	public String getHomePage(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("Authenticated", Boolean.TRUE);
	   
		// For today's purposes to simulate Login against AD or IAM roles
		boolean bAuthenticatedUser = (boolean) session.getAttribute("Authenticated");
		logger.info("For Demo purposes the flag is set to TRUE for authentication. Change it to False to validate Login message");
		
		if (bAuthenticatedUser)
			return "redirect:/findUser";
		else {
			model.addAttribute("message", welcomeMessage + "<BR> You need to Relogin to get access !!");
		}
		
		return "index";
	}

	/*
	 * @GetMapping("/findUser") public String findContact(Model model) {
	 * System.out.println("Within the find Contact controller");
	 * //List<PhoneBookUser> lContacts = contactService.getContacts();
	 * 
	 * Iterable<PhoneBookUser> lContacts = contactService.getContacts();
	 * model.addAttribute("contacts", lContacts);
	 * 
	 * return "index"; }
	 */

	@GetMapping("/findUser")
	public ModelAndView findContact(@ModelAttribute("id") String sFindStr) {
		logger.info("Finding the Contacts for " + sFindStr);
		ModelAndView mvObj = new ModelAndView("index");
		mvObj.setViewName("index");
		// List<PhoneBookUser> lContacts = contactService.getContacts();
		Iterable<PhoneBookUser> lContacts = contactService.getContactByString(sFindStr);
		mvObj.addObject("contactList", lContacts);
		return mvObj;
	}

	@PostMapping("/registerUser")
	public ModelAndView addContact(@ModelAttribute("user") PhoneBookUser pbUser) {
		logger.info(" Adding New Phone book contact for " + pbUser.toString());
		contactService.saveContact(pbUser);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("savedMessage",
				pbUser.getFirstName() + " " + pbUser.getLastName() + " saved succesfully !!");

		return modelAndView;
	}

	/* for Future enhancements - Not wiring it now */

	@PutMapping("/updateUser")
	public ModelAndView updateContact(@ModelAttribute("user") PhoneBookUser pbUser) {
		logger.info(" Updating existing Phone book contact for " + pbUser.toString());
		contactService.updateContactById(pbUser);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("savedMessage",
				pbUser.getFirstName() + " " + pbUser.getLastName() + " Updated succesfully !!");

		return modelAndView;
	}

	@DeleteMapping("/deleteContact/{id}")
	public ModelAndView deleteContact(@PathVariable int id) {
		logger.info(" Deleting Phone book contact for " + id);
		contactService.deleteContactById(id);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("savedMessage", " User Deleted !!!!");

		return modelAndView;
	}
}
