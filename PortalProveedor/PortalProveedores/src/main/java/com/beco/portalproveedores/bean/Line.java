package com.beco.portalproveedores.bean;

// Generated 27/03/2014 04:21:05 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Line generated by hbm2java
 */
@Entity
@Table(name = "LINE")
public class Line implements java.io.Serializable {

	private BigDecimal lineId;
	private String lineName;
	private String lineDepartment;

	public Line() {
	}

	public Line(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public Line(BigDecimal lineId, String lineName, String lineDepartment) {
		this.lineId = lineId;
		this.lineName = lineName;
		this.lineDepartment = lineDepartment;
	}

	@Id
	@Column(name = "LINE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	@Column(name = "LINE_NAME", length = 100)
	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	@Column(name = "LINE_DEPARTMENT", length = 100)
	public String getLineDepartment() {
		return this.lineDepartment;
	}

	public void setLineDepartment(String lineDepartment) {
		this.lineDepartment = lineDepartment;
	}

}