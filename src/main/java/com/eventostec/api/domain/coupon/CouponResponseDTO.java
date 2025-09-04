package com.eventostec.api.domain.coupon;

public record CouponResponseDTO(
        String code,
        Integer discount,
        String validDate
) {
    public CouponResponseDTO(Coupon coupon){
        this(coupon.getCode(), coupon.getDiscount(), coupon.getValidDate());
    }
}
