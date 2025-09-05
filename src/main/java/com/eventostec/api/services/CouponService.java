package com.eventostec.api.services;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.coupon.CouponResponseDTO;
import com.eventostec.api.repositories.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository){this.couponRepository = couponRepository;}

    public void addCoupon(CouponRequestDTO coupon){
        Coupon couponAdd = new Coupon(coupon);
        this.couponRepository.save(couponAdd);
    }

    public List<CouponResponseDTO> getCoupon(){
        return this.couponRepository
                .findAll()
                .stream()
                .map(coupon -> new CouponResponseDTO(coupon))
                .toList();
    }

    public void updateCoupon(CouponRequestDTO couponRequestDTO){
        Coupon couponUpdate = new Coupon(couponRequestDTO);
        couponUpdate.setId(this.couponRepository.findAll()
                .stream()
                .filter(coupon -> coupon.getCode().equals(coupon.getCode()))
                .findFirst()
                .get()
                .getId());
        this.couponRepository.save(couponUpdate);
    }

    public void deleteCouponByCode(String code){
        Coupon couponDelete = this.couponRepository.findAll()
                .stream()
                .filter(coupon -> coupon.getCode().equals(code))
                .findFirst()
                .get();
        this.couponRepository.delete(couponDelete);
    }


}
