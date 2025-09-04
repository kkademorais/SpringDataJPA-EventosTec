package com.eventostec.api.domain.address;

import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import java.util.*;

@Table(name = "addresses")
@Entity(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String uf;
    private String city;

    //@OneToOne
    //@JoinColumn(name = "event-id")
    private String event;

    public Address(){}
    public Address(String uf, String city, String event){
        this.uf = uf;
        this.city = city;
        this.event = event;
    }
    public Address(AddressRequestDTO addressRequestDTO){
        this.uf = addressRequestDTO.uf();
        this.city = addressRequestDTO.city();
        this.event = addressRequestDTO.event();
    }


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getUf() {return uf;}
    public void setUf(String uf) {this.uf = uf;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getEvent() {return event;}
    public void setEvent(String event) {this.event = event;}

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", uf='" + uf + '\'' +
                ", city='" + city + '\'' +
                ", event=" + event +
                '}';
    }
}
