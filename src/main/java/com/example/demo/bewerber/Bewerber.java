package com.example.demo.bewerber;

import javax.persistence.*;


@Entity
@Table
public class Bewerber {

    @Id
    @SequenceGenerator(name = "bewerber_sequence", sequenceName = "bewerber_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bewerber_sequence")
    private Long id;
    private String name;
    private String email;
    private String phonenumber;
    private String whishedposition;
    private String employment;
    private Integer whishedpayment;
    private String statusjobapplication;


    //constructors


    public Bewerber() {
    }

    public Bewerber(Long id, String name, String email, String phonenumber, String whishedposition, String employment, Integer whishedpayment, String statusjobapplication) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.whishedposition = whishedposition;
        this.employment = employment;
        this.whishedpayment = whishedpayment;
        this.statusjobapplication = statusjobapplication;
    }

    public Bewerber(String name, String email, String phonenumber, String whishedposition, String employment, Integer whishedpayment, String statusjobapplication) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.whishedposition = whishedposition;
        this.employment = employment;
        this.whishedpayment = whishedpayment;
        this.statusjobapplication = statusjobapplication;
    }

    //setter + getter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getWhishedposition() {
        return whishedposition;
    }

    public void setWhishedposition(String whishedposition) {
        this.whishedposition = whishedposition;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public Integer getWhishedpayment() {
        return whishedpayment;
    }

    public void setWhishedpayment(Integer whishedpayment) {
        this.whishedpayment = whishedpayment;
    }

    public String getStatusjobapplication() {
        return statusjobapplication;
    }

    public void setStatusjobapplication(String statusjobapplication) {
        this.statusjobapplication = statusjobapplication;
    }

    @Override
    public String toString() {
        return "Bewerber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", whishedposition='" + whishedposition + '\'' +
                ", employment='" + employment + '\'' +
                ", whishedpayment=" + whishedpayment +
                ", statusjobapplication='" + statusjobapplication + '\'' +
                '}';
    }
}
