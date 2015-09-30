package com.vzw.prepaid;

import java.io.Serializable;

public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String msgTypeIndicator;
	public String bitMap;
	public String processingCode;
	public String amount;
	public String sysTraceAuditNo;
	public String additionalRespData;
	public String reservedIsoUse;
	public String transmissionDateTime;
	
	public String getMsgTypeIndicator() {
		return msgTypeIndicator;
	}
	public void setMsgTypeIndicator(String msgTypeIndicator) {
		this.msgTypeIndicator = msgTypeIndicator;
	}
	public String getBitMap() {
		return bitMap;
	}
	public void setBitMap(String bitMap) {
		this.bitMap = bitMap;
	}
	public String getProcessingCode() {
		return processingCode;
	}
	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSysTraceAuditNo() {
		return sysTraceAuditNo;
	}
	public void setSysTraceAuditNo(String sysTraceAuditNo) {
		this.sysTraceAuditNo = sysTraceAuditNo;
	}
	public String getAdditionalRespData() {
		return additionalRespData;
	}
	public void setAdditionalRespData(String additionalRespData) {
		this.additionalRespData = additionalRespData;
	}
	public String getReservedIsoUse() {
		return reservedIsoUse;
	}
	public void setReservedIsoUse(String reservedIsoUse) {
		this.reservedIsoUse = reservedIsoUse;
	}
	
	public String getTransmissionDateTime() {
		return transmissionDateTime;
	}
	public void setTransmissionDateTime(String transmissionDateTime) {
		this.transmissionDateTime = transmissionDateTime;
	}
	@Override
	public String toString() {
		return "Message [msgTypeIndicator=" + msgTypeIndicator + ", bitMap=" + bitMap + ", processingCode="
				+ processingCode + ", amount=" + amount + ", sysTraceAuditNo=" + sysTraceAuditNo
				+ ", additionalRespData=" + additionalRespData + ", reservedIsoUse=" + reservedIsoUse
				+ ", transmissionDateTime=" + transmissionDateTime + "]";
	}
	
}
