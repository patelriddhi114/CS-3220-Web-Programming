package Models;

import java.util.Date;

public class CustomerEntry {

	static int count=0;
	
	int id;
	String name;
	String address;
	String email;
	String phone;
	String gender;
	String opportunity_name;
	String account;
	
	Date date;
	public CustomerEntry()
	{
		date = new Date();
	}
	public CustomerEntry(int id, String name, String address, String email, String phone, String gender,
			String opportunity_name, String account) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.opportunity_name = opportunity_name;
		this.account = account;
		this.date = new Date();
	}
	public CustomerEntry(String name, String address, String email, String phone, String gender,
			String opportunity_name, String account) {
		super();
		this.id = count++;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.opportunity_name = opportunity_name;
		this.account = account;
		this.date = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOpportunity_name() {
		return opportunity_name;
	}
	public void setOpportunity_name(String opportunity_name) {
		this.opportunity_name = opportunity_name;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}