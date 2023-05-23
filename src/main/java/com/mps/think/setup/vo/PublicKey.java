package com.mps.think.setup.vo;

public class PublicKey {

	String id;
	String strippublick;
	String status;
	String chargeId;
	String balanceTransaction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public String getBalanceTransaction() {
		return balanceTransaction;
	}

	public void setBalanceTransaction(String balanceTransaction) {
		this.balanceTransaction = balanceTransaction;
	}

	public String getStrippublick() {
		return strippublick;
	}

	public void setStrippublick(String strippublick) {
		this.strippublick = strippublick;
	}

	@Override
	public String toString() {
		return "PublicKey [id=" + id + ", strippublick=" + strippublick + ", status=" + status + ", chargeId="
				+ chargeId + ", balanceTransaction=" + balanceTransaction + "]";
	}

}