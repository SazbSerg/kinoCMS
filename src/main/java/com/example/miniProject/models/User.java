package com.example.miniProject.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

@Table(name = "User", indexes = {
        @Index(name = "idx_user_local_date", columnList = "local_date")
})
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public User(String name, String surname, String nickname, String eMail, String adress, String password, String cardNumber, boolean language, boolean gender, String phoneNumber, Date date, String city, LocalDate now) {

    }

    public User() {
    }

    public User(String mainTopBannerImage1, String mainTopBannerUrl1, String mainTopBannerText1, String mainTopBannerImage2, String mainTopBannerUrl2, String mainTopBannerText2, String mainTopBannerImage3, String mainTopBannerUrl3, String mainTopBannerText3, String mainTopBannerImage4, String mainTopBannerUrl4, String mainTopBannerText4, String mainTopBannerImage5, String mainTopBannerUrl5, String mainTopBannerText5) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @Column(name = "e_mail", nullable = false, length = 100)
    private String eMail;

    @Column(name = "adress", nullable = false, length = 100)
    private String adress;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "card_number", nullable = false, length = 100)
    private String cardNumber;

    @Column(name = "language", nullable = false, length = 50)
    private boolean language;

    @Column(name = "gender", nullable = false, length = 20)
    private boolean gender;

    @Column(name = "phone_number", nullable = false, length = 100)
    private String phoneNumber;

    @Column(name = "date", nullable = false, length = 100)
    private Date date;

    @Column(name = "city", nullable = false, length = 30)
    private String city;

    @Column(name = "local_date", nullable = false, length = 20)
    private String localDate;

    @Column(name = "check_for_mail", nullable = false, length = 300)
    private boolean checkForMail;

    public boolean isCheckForMail() {
        return checkForMail;
    }

    public void setCheckForMail(boolean checkForMail) {
        this.checkForMail = checkForMail;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(String name, String surname, String nickname, String eMail,
                String adress, String password, String cardNumber, boolean language, boolean gender,
                String phoneNumber, Date date, String city, String localDate, boolean checkForMail) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.eMail = eMail;
        this.adress = adress;
        this.password = password;
        this.cardNumber = cardNumber;
        this.language = language;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.city = city;
        this.localDate = localDate;
        this.checkForMail = checkForMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(String name, String surname, String nickname, String eMail, String adress, String password,
                String cardNumber, boolean language, boolean gender, String phoneNumber, Date date, String city, String localDate) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.eMail = eMail;
        this.adress = adress;
        this.password = password;
        this.cardNumber = cardNumber;
        this.language = language;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.city = city;
        this.localDate = localDate;
    }
}