package com.md;

import java.util.Date;

public class Reimbursement {
	
	private int reimbursementId;
	private int emplId;
	private double amount;
	private String submitDate;
	private String type;
	private String status;
	
	public Reimbursement() {
		
	}

	public Reimbursement(int reimbursementId, int emplId, double amount, String submitDate, String type,
			String status) {
		super();
		this.reimbursementId = reimbursementId;
		this.emplId = emplId;
		this.amount = amount;
		this.submitDate = submitDate;
		this.type = type;
		this.status = status;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmplId() {
		return emplId;
	}

	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", emplId=" + emplId + ", amount=" + amount
				+ ", submitDate=" + submitDate + ", type=" + type + ", status=" + status + "]";
	}

	
}
