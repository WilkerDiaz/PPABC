package com.beco.portalproveedores.bean;

// Generated 27/03/2014 04:21:05 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Section generated by hbm2java
 */
@Entity
@Table(name = "SECTION")
public class Section implements java.io.Serializable {

	private BigDecimal sectionId;
	private String sectionName;
	private String sectionLine;

	public Section() {
	}

	public Section(BigDecimal sectionId) {
		this.sectionId = sectionId;
	}

	public Section(BigDecimal sectionId, String sectionName, String sectionLine) {
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.sectionLine = sectionLine;
	}

	@Id
	@Column(name = "SECTION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(BigDecimal sectionId) {
		this.sectionId = sectionId;
	}

	@Column(name = "SECTION_NAME", length = 100)
	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Column(name = "SECTION_LINE", length = 100)
	public String getSectionLine() {
		return this.sectionLine;
	}

	public void setSectionLine(String sectionLine) {
		this.sectionLine = sectionLine;
	}

}