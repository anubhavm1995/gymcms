package com.AstroGymCMS.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Gyms {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gymId;

	@NonNull
	private String gymName;

	private String gymAddress1;

	private String gymAddress2;

	@NonNull
	private int gymPincode;

	private String gymCity;

	@NonNull
	private String gymState;

	private double gymrating;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = GymOwner.class)
	private GymOwner gymOwner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userGymDetails")
	private List<GymUser> gymUserList;

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getGymAddress1() {
		return gymAddress1;
	}

	public void setGymAddress1(String gymAddress1) {
		this.gymAddress1 = gymAddress1;
	}

	public String getGymAddress2() {
		return gymAddress2;
	}

	public void setGymAddress2(String gymAddress2) {
		this.gymAddress2 = gymAddress2;
	}

	public int getGymPincode() {
		return gymPincode;
	}

	public void setGymPincode(int gymPincode) {
		this.gymPincode = gymPincode;
	}

	public String getGymCity() {
		return gymCity;
	}

	public void setGymCity(String gymCity) {
		this.gymCity = gymCity;
	}

	public String getGymState() {
		return gymState;
	}

	public void setGymState(String gymState) {
		this.gymState = gymState;
	}

	public double getGymrating() {
		return gymrating;
	}

	public void setGymrating(double gymrating) {
		this.gymrating = gymrating;
	}

	public GymOwner getGymOwner() {
		return gymOwner;
	}

	public void setGymOwner(GymOwner gymOwner) {
		this.gymOwner = gymOwner;
	}

	public List<GymUser> getGymUserList() {
		return gymUserList;
	}

	public void setGymUserList(List<GymUser> gymUserList) {
		this.gymUserList = gymUserList;
	}

}
