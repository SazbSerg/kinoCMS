package com.example.miniProject.models;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
public class SmsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sms", nullable = false)
    private String sms;

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SmsModel() {
    }

    public SmsModel(String sms) {
        this.sms = sms;
    }
}
