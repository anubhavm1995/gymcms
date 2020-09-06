package com.AstroGymCMS.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class GymUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@NonNull
	private String userfullName;

	private String userEmailId;

	private Gender userGender;

	private long userMobileNo;

	@ManyToOne(fetch = FetchType.LAZY)
	private Gyms userGymDetails;

	private boolean userStatus;

	private double userFeesPaid;

	private LocalDate userDateOfJoining;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserfullName() {
		return userfullName;
	}

	public void setUserfullName(String userfullName) {
		this.userfullName = userfullName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}

	public long getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(long userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public Gyms getUserGymDetails() {
		return userGymDetails;
	}

	public void setUserGymDetails(Gyms userGymDetails) {
		this.userGymDetails = userGymDetails;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public double getUserFeesPaid() {
		return userFeesPaid;
	}

	public void setUserFeesPaid(double userFeesPaid) {
		this.userFeesPaid = userFeesPaid;
	}

	public LocalDate getUserDateOfJoining() {
		return userDateOfJoining;
	}

	public void setUserDateOfJoining(LocalDate userDateOfJoining) {
		this.userDateOfJoining = userDateOfJoining;
	}

	public GymUser(int userId, String userfullName, String userEmailId, Gender userGender, long userMobileNo,
			Gyms userGymDetails, boolean userStatus, double userFeesPaid, LocalDate userDateOfJoining) {
		super();
		this.userId = userId;
		this.userfullName = userfullName;
		this.userEmailId = userEmailId;
		this.userGender = userGender;
		this.userMobileNo = userMobileNo;
		this.userGymDetails = userGymDetails;
		this.userStatus = userStatus;
		this.userFeesPaid = userFeesPaid;
		this.userDateOfJoining = userDateOfJoining;
	}

	public GymUser() {
		super();
	}

	@Override
	public String toString() {
		return "GymUser [userId=" + userId + ", userfullName=" + userfullName + ", userEmailId=" + userEmailId
				+ ", userGender=" + userGender + ", userMobileNo=" + userMobileNo + ", userGymDetails=" + userGymDetails
				+ ", userStatus=" + userStatus + ", userFeesPaid=" + userFeesPaid + ", userDateOfJoining="
				+ userDateOfJoining + "]";
	}

	

}
