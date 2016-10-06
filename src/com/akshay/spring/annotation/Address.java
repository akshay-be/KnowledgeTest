package com.akshay.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	@Value("No 1")
	private String homeNum;
	
	@Value("Ragiginagar")
	private String street;
	private String city;
	private String pincode;
	public Address() {
		System.out.println("Address no argument constructor...");
	}
	public Address(String homeNum, String street, String city, String pincode) {
		super();
		this.homeNum = homeNum;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public String getHomeNum() {
		return homeNum;
	}
	public void setHomeNum(String homeNum) {
		this.homeNum = homeNum;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((homeNum == null) ? 0 : homeNum.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (homeNum == null) {
			if (other.homeNum != null)
				return false;
		} else if (!homeNum.equals(other.homeNum))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [homeNum=" + homeNum + ", street=" + street + ", city="
				+ city + ", pincode=" + pincode + "]";
	}
	
	

}
