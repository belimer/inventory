package com.brandlogs.inventory_api.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

/**
 * @author Mercy
 *
 * @date Jul 19, 2022
 */
@MappedSuperclass
public abstract class Record implements Serializable {

	/**
	 * The actual date and time the record was INSERTed.
	 */
	@Column(name = "datetime_created", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")

	@CreationTimestamp
	protected ZonedDateTime datetimeCreated;

	/**
	 * The actual date and time the record was UPDATEd
	 */
	@Column(name = "last_modified", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")


	@CreatedDate
	protected ZonedDateTime lastModified;

	/**
	 * @param datetimeCreated
	 * @param lastModified
	 */
	public Record() {
		super();
		this.datetimeCreated = ZonedDateTime.now();
		this.lastModified = ZonedDateTime.now();
	}

	/**
	 * @return the datetimeCreated
	 */
	public ZonedDateTime getDatetimeCreated() {
		return datetimeCreated;
	}

	/**
	 * @param datetimeCreated the datetimeCreated to set
	 */
	public void setDatetimeCreated(ZonedDateTime datetimeCreated) {
		this.datetimeCreated = datetimeCreated;
	}

	/**
	 * @return the lastModified
	 */
	public ZonedDateTime getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(ZonedDateTime lastModified) {
		this.lastModified = lastModified;
	}

	@PrePersist
	public void handleInsertEvent() {
		datetimeCreated = ZonedDateTime.now();
	}

	@PreUpdate
	public void handleUpdateEvent() {
		lastModified = ZonedDateTime.now();
	}


}