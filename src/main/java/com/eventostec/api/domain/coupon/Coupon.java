package com.eventostec.api.domain.coupon;

import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Table(name = "coupons")
@Entity(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;
    private Integer discount;
    private Date validDate;

    //@ManyToOne
    //@JoinColumn(name = "event-id")
    //private Event event;


    public Coupon(){}
    public Coupon(UUID id, String code, Integer discount, Date validDate){
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.validDate = validDate;
        //this.event = event;
    }
    public Coupon(CouponRequestDTO couponRequestDTO){
        this.code = couponRequestDTO.code();
        this.discount = couponRequestDTO.discount();
        this.validDate = couponRequestDTO.validDate();
    }


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public Integer getDiscount() {return discount;}
    public void setDiscount(Integer discount) {this.discount = discount;}

    public Date getValidDate(){return validDate;}
    public String getValidDatetoString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(validDate);
    }
    public void setValidDate(Date validDate) {this.validDate = validDate;}


    //public Event getEvent() {return event;}
    //public void setEvent(Event event) {this.event = event;}

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", validDate=" + getValidDatetoString() +
                '}';
    }
}
