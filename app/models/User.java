package models;

import io.ebean.Finder;
import io.ebean.Model;
import models.bridges.City_User;
import models.compoundKeys.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Model {
	public static final Finder<String, User> find = new Finder<>(User.class);
	@Id
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Embedded
	private Address address;
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Column(name = "yob", nullable = false)
	private int yob;
	@Column(name = "mob", nullable = false)
	private int mob;
	@Column(name = "dob", nullable = false)
	private int dob;
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	@Column(name = "parentUser")
	private User parentUser;
	@OneToMany(mappedBy = "user")
	private List<City_User> managedCities = new LinkedList<>();
	//  PRIVATE METHODS

	/*
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	*/
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = (email!=null)? email.trim() : "";}
	public Address getAddress() {return address;}
	public void setAddress(Address address) {this.address = address;}
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setPassword(String password){this.password = password;}
	public int getYob() {return yob;}
	public void setYob(int yob) {this.yob = yob;}
	public int getMob() {return mob;}
	public void setMob(int mob) {this.mob = mob;}
	public int getDob() {return dob;}
	public void setDob(int dob) {this.dob = dob;}
	public int getAge() {return (LocalDate.now().getYear() - yob);}
	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	public User getParentUser() {return parentUser;}
	public void setParentUser(User parentUser) {this.parentUser = parentUser;}
	public boolean isCityManager() {return (managedCities.isEmpty());}
	public Iterator<City_User> getManagers() {return managedCities.iterator();}
	public String getQR(){
		return email + " " + firstName + " " + lastName;
	}

	//public boolean isAttractionManager() {return managesAttraction;}
}
