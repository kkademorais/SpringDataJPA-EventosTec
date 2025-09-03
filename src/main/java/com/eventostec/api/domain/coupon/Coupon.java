package com.eventostec.api.domain.coupon;

import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import java.util.*;

@Table(name = "coupons")
@Entity(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;
    private Integer discount;
    private Date valid;

    @ManyToOne
    @JoinColumn(name = "event-id")
    private Event event;


    public Coupon(){}
    public Coupon(UUID id, String code, Integer discount, Date valid, Event event){
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.valid = valid;
        this.event = event;
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}

    public Integer getDiscount() {return discount;}
    public void setDiscount(Integer discount) {this.discount = discount;}

    public Date getValid() {return valid;}
    public void setValid(Date valid) {this.valid = valid;}

    public Event getEvent() {return event;}
    public void setEvent(Event event) {this.event = event;}

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", valid=" + valid +
                '}';
    }
}
