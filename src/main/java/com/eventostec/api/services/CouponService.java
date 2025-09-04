package com.eventostec.api.services;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponResponseDTO;
import com.eventostec.api.repositories.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository){this.couponRepository = couponRepository;}

    public void addCoupon(Coupon coupon){
        this.couponRepository.save(coupon);
    }

    public List<CouponResponseDTO> getCoupon(){
        return this.couponRepository
                .findAll()
                .stream()
                .map(coupon -> new CouponResponseDTO(coupon))
                .toList();
    }

}
