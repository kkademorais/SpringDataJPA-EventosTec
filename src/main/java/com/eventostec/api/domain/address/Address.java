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

    @OneToOne
    @JoinColumn(name = "event-id")
    private Event event;

    public Address(){}
    public Address(UUID id, String uf, String city, Event event){
        this.id = id;
        this.uf = uf;
        this.city = city;
        this.event = event;
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getUf() {return uf;}
    public void setUf(String uf) {this.uf = uf;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public Event getEvent() {return event;}
    public void setEvent(Event event) {this.event = event;}

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
