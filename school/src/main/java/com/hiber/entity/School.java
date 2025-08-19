package com.hiber.entity;

import java.util.Date;

import com.hiber.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "school")
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String userName;
	@Column
	private Gender gender;
	@Column
	private String adress;
	@Column
	private Date dob;
	
	
	public School() {
		// TODO Auto-generated constructor stub
	}
	
	
	public School(String firstName, String lastName, String userName, Gender gender, String adress,
			Date dob) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
		this.adress = adress;
		this.dob = dob;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "School [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", gender=" + gender + ", adress=" + adress + ", dob=" + dob + "]";
	}
	
	

}
