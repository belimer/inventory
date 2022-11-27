package com.brandlogs.inventory_api.dto;



import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mercy
 *
 * @date Jul 21, 2022
 */
public class ApiResonse {
	@JsonProperty("status")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@NotBlank
	@Pattern(regexp = "^\\d{6}$")
	protected String status;

	@JsonProperty("message")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected String message;

	@JsonProperty("id")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@NotNull
	protected long transactionId;
	
	@JsonProperty("referenceNumber")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@NotNull
	protected String referenceNumber;

	@JsonProperty("timestamp")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS Z")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected ZonedDateTime timestamp;

	/**
	 * 
	 */
	public ApiResonse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	/**
	 * @return the timestamp
	 */
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public static ApiResonse valueOf(String message2, String status2) {
		ApiResonse res =new ApiResonse();
		res.setMessage(message2);
		res.setStatus(status2);
				
		return res;
	}

}
