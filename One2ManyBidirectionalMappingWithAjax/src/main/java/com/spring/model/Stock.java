package com.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.spring.model.StockDailyRecord;

@Entity
@Table(name = "stock", catalog = "test")
public class Stock implements java.io.Serializable {

	private Integer id;
	private String stockname;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name", unique = true, nullable = true, length = 20)
	public String getStockName() {
		return stockname;
	}
	public void setStockName(String name) {
		this.stockname = stockname;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	public Set<StockDailyRecord> getStockDailyRecords() {
		return this.stockDailyRecords;
	}
	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockname=" + stockname;
	}
}
