package com.c.bean;

import org.springframework.stereotype.Component;

@Component
public class CarProblem {
  private String name;
  private String RegistrationNo;
  private String Repairingdate;
  private String Issue;
  private String flagStatus = "Pending";
public CarProblem() {
	super();
	// TODO Auto-generated constructor stub
}
public CarProblem(String name, String registrationNo, String repairingdate, String issue, String flagStatus) {
	super();
	this.name = name;
	this.RegistrationNo = registrationNo;
	this.Repairingdate = repairingdate;
	this.Issue = issue;
	this.flagStatus = flagStatus;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRegistrationNo() {
	return RegistrationNo;
}
public void setRegistrationNo(String registrationNo) {
	RegistrationNo = registrationNo;
}
public String getRepairingdate() {
	return Repairingdate;
}
public void setRepairingdate(String repairingdate) {
	Repairingdate = repairingdate;
}
public String getIssue() {
	return Issue;
}
public void setIssue(String issue) {
	Issue = issue;
}
public String getFlagStatus() {
	return flagStatus;
}
public void setFlagStatus(String flagStatus) {
	this.flagStatus = flagStatus;
}
@Override
public String toString() {
	return "CarProblem [name=" + name + ", RegistrationNo=" + RegistrationNo + ", Repairingdate=" + Repairingdate
			+ ", Issue=" + Issue + ", flagStatus=" + flagStatus + "]";
}
  
  
}
