package com.obs.coupon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.obs.helper.sequenceGeneration.StringSequence;

@Entity
public class Coupon {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "coup_seq")
    @GenericGenerator(name="coup_seq",
            strategy = "com.obs.helper.sequenceGeneration.StringSequence",
            parameters = {
                    @Parameter(name=StringSequence.INCREMENT_PARAM,value="1"),
                    @Parameter(name=StringSequence.VALUE_PREFIX_PARAMETER,value="Coup_"),
                    @Parameter(name=StringSequence.NUMBER_FORMAT_PARAMETER,value="%04d")
            }
     )
	private String couponId;
	private String couponName;
	private Double couponPrice;
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Double getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(Double couponPrice) {
		this.couponPrice = couponPrice;
	}
	
	
	

}
