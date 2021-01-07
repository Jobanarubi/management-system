package com.delivery.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Parcel_Details")
public class ParcelDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="consingnment_id")
	private int consignmentId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="parcel_details")
	private String parcelDetails;
	@Column(name="weight")
	private Double weight;
	@Column(name="packaging_type")
	private String packagingType;
	@Column(name="delivery_address")
	private String deliveryAddress;
	@Column(name="delivery_agent")
	private String deliveryAgent;
	@Column(name="status")
	private String status;
	@Column(name="seqid")
	private int seqid;
	
	
	public ParcelDetails(int consignmentId,String customerName, String parcelDetails, Double weight, String packagingType,
			String deliveryAddress, String deliveryAgent, String status, int seqid) {
		super();
		this.consignmentId = consignmentId;
		this.customerName = customerName;
		this.parcelDetails = parcelDetails;
		this.weight = weight;
		this.packagingType = packagingType;
		this.deliveryAddress = deliveryAddress;
		this.deliveryAgent = deliveryAgent;
		this.status = status;
		this.seqid = seqid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ParcelDetails() {
		super();
		this.consignmentId = 0;
		this.parcelDetails = "";
		this.weight = (double) 0;
		this.packagingType = "";
		this.deliveryAddress = "";
		this.deliveryAgent = "";
		this.status = "";
		this.seqid = 0;
	}

	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(int consignmentId) {
		this.consignmentId = consignmentId;
	}

	public String getParcelDetails() {
		return parcelDetails;
	}

	public void setParcelDetails(String parcelDetails) {
		this.parcelDetails = parcelDetails;
	}

	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getPackagingType() {
		return packagingType;
	}

	public void setPackagingType(String packagingType) {
		this.packagingType = packagingType;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(String deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}

	
	
	
	
}
