package com.eventostec.api.domain.event;

import jakarta.persistence.*;

import java.util.*;

@Table(name = "events")
@Entity(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private String image_url;
    private String event_url;
    private Date date;
    private boolean remote;

    public Event(){}

    public Event(UUID id, String title, String description, String image_url, String event_url, Date date, boolean remote){
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.event_url = event_url;
        this.date = date;
        this.remote = remote;
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getImage_url() {return image_url;}
    public void setImage_url(String image_url) {this.image_url = image_url;}

    public String getEvent_url() {return event_url;}
    public void setEvent_url(String event_url) {this.event_url = event_url;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public boolean isRemote() {return remote;}
    public void setRemote(boolean remote) {this.remote = remote;}

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", event_url='" + event_url + '\'' +
                ", date=" + date +
                ", remote=" + remote +
                '}';
    }
}
