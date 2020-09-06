package com.AstroGymCMS.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class GymOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ownerId;
	
	@NonNull
	private String ownerfullName;

	private String ownerEmailId;

	private Gender ownerGender;

	private long ownerMobileNo;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Gyms> ownerGym;

	private boolean ownerStatus;
		
	private LocalDate ownerDateOfJoining;

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerfullName() {
		return ownerfullName;
	}

	public void setOwnerfullName(String ownerfullName) {
		this.ownerfullName = ownerfullName;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public Gender getOwnerGender() {
		return ownerGender;
	}

	public void setOwnerGender(Gender ownerGender) {
		this.ownerGender = ownerGender;
	}

	public long getOwnerMobileNo() {
		return ownerMobileNo;
	}

	public void setOwnerMobileNo(long ownerMobileNo) {
		this.ownerMobileNo = ownerMobileNo;
	}

	
	

	public List<Gyms> getOwnerGym() {
		return ownerGym;
	}

	public void setOwnerGym(List<Gyms> ownerGym) {
		this.ownerGym = ownerGym;
	}

	public boolean isOwnerStatus() {
		return ownerStatus;
	}

	public void setOwnerStatus(boolean ownerStatus) {
		this.ownerStatus = ownerStatus;
	}

	public LocalDate getOwnerDateOfJoining() {
		return ownerDateOfJoining;
	}

	public void setOwnerDateOfJoining(LocalDate ownerDateOfJoining) {
		this.ownerDateOfJoining = ownerDateOfJoining;
	}

	
	
	
	
}
