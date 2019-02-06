package com.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_record", catalog = "test")
public class StockDailyRecord implements java.io.Serializable {

	private Integer recordId;
	private Stock stock;
	private String name;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = true)
	public Integer getRecordId() {
		return this.recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	@Column(name = "name", nullable = true, length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id", nullable = true)
	public Stock getStock() {
		return this.stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "StockDailyRecord [recordId=" + recordId + ", name=" + name + "]";
	}
}