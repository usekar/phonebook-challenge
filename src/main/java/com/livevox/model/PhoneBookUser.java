package com.livevox.model;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity 
@Table (name="Contacts")
public class PhoneBookUser {
	
	@Id
	@GeneratedValue
	private int id;
	
 
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name") 
	private String lastName;
	
	@Column(name="phone_Number")
	private String phoneNumber;

	

}
