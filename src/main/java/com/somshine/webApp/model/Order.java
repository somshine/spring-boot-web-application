package com.somshine.webApp.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Order {
	private Long id;
	private int shoppeId;
	private String billNo;
	private int paymentId;
	private int customerId;
	private int supplierId;
	private Double saleQuanity;
	private Double returnQuanity;
	private Double saleAmount;
	private Double returnAmount;
	private Double billingAmount;
	private int discount;
	private Double paidByCash;
	private LocalDate createdOn;
	private LocalDate updatedOn;
	
	public Order() {
		super();
	}
	
	public Order(int shoppeId, String billNo, int paymentId, int customerId, int supplierId, Double saleQuanity,
			Double returnQuanity, Double saleAmount, Double returnAmount, Double billingAmount, int discount,
			Double paidByCash, LocalDate createdOn, LocalDate updatedOn) {
		super();
		this.shoppeId = shoppeId;
		this.billNo = billNo;
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.supplierId = supplierId;
		this.saleQuanity = saleQuanity;
		this.returnQuanity = returnQuanity;
		this.saleAmount = saleAmount;
		this.returnAmount = returnAmount;
		this.billingAmount = billingAmount;
		this.discount = discount;
		this.paidByCash = paidByCash;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	public Order(Long id, int shoppeId, String billNo, int paymentId, int customerId, int supplierId,
			Double saleQuanity, Double returnQuanity, Double saleAmount, Double returnAmount, Double billingAmount,
			int discount, Double paidByCash, LocalDate createdOn, LocalDate updatedOn) {
		super();
		this.id = id;
		this.shoppeId = shoppeId;
		this.billNo = billNo;
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.supplierId = supplierId;
		this.saleQuanity = saleQuanity;
		this.returnQuanity = returnQuanity;
		this.saleAmount = saleAmount;
		this.returnAmount = returnAmount;
		this.billingAmount = billingAmount;
		this.discount = discount;
		this.paidByCash = paidByCash;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getShoppeId() {
		return shoppeId;
	}
	public void setShoppeId(int shoppeId) {
		this.shoppeId = shoppeId;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public Double getSaleQuanity() {
		return saleQuanity;
	}
	public void setSaleQuanity(Double saleQuanity) {
		this.saleQuanity = saleQuanity;
	}
	public Double getReturnQuanity() {
		return returnQuanity;
	}
	public void setReturnQuanity(Double returnQuanity) {
		this.returnQuanity = returnQuanity;
	}
	public Double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}
	public Double getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(Double returnAmount) {
		this.returnAmount = returnAmount;
	}
	public Double getBillingAmount() {
		return billingAmount;
	}
	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Double getPaidByCash() {
		return paidByCash;
	}
	public void setPaidByCash(Double paidByCash) {
		this.paidByCash = paidByCash;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDate getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
}
