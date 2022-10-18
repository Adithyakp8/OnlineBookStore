package com.obs.coupon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obs.coupon.model.Coupon;

public interface CouponDao extends JpaRepository<Coupon,String>{

	Coupon findByCouponName(String couponName);

}
