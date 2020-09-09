package com.AstroGymCMS.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Entity
public class GymOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ownerId;

	@NonNull
	@NotEmpty(message = "Name is mandatory")
	private String ownerFullName;
	
	@NonNull
	@NotEmpty(message = "Email is mandatory")
	private String ownerEmailId;

	private Gender ownerGender;

	@Min(1000000000l)
	@Max(9999999999l)
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

	public String getOwnerFullName() {
		return ownerFullName;
	}

	public void setOwnerFullName(String ownerFullName) {
		this.ownerFullName = ownerFullName;
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

	public GymOwner() {
		super();
	}

	public GymOwner(int ownerId, String ownerFullName, String ownerEmailId, Gender ownerGender, long ownerMobileNo,
			List<Gyms> ownerGym, boolean ownerStatus, LocalDate ownerDateOfJoining) {
		super();
		this.ownerId = ownerId;
		this.ownerFullName = ownerFullName;
		this.ownerEmailId = ownerEmailId;
		this.ownerGender = ownerGender;
		this.ownerMobileNo = ownerMobileNo;
		this.ownerGym = ownerGym;
		this.ownerStatus = ownerStatus;
		this.ownerDateOfJoining = ownerDateOfJoining;
	}

}
