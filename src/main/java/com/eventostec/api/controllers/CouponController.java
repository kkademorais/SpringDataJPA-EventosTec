package com.eventostec.api.controllers;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.coupon.CouponResponseDTO;
import com.eventostec.api.services.CouponService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity addCoupon(@RequestBody @Valid CouponRequestDTO couponRequestDTO){
        this.couponService.addCoupon(couponRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CouponResponseDTO>> getCoupon(){
        return ResponseEntity.ok(this.couponService.getCoupon());
    }

    @PutMapping
    public ResponseEntity updateCoupon(@RequestBody @Valid CouponRequestDTO couponRequestDTO){
        this.couponService.updateCoupon(couponRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteCouponByCode(@PathVariable(name = "code") String code){
        this.couponService.deleteCouponByCode(code);
        return ResponseEntity.ok().build();
    }


}
