package com.cjayawardana.customerservice.model;

import com.cjayawardana.customerservice.validator.CaseMode;
import com.cjayawardana.customerservice.validator.CheckCase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @CheckCase(value = CaseMode.UPPER, message = "Please provide firstName in UPPER case")
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @CheckCase(value = CaseMode.UPPER, message = "Please provide lastName in UPPER case")
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public Customer() {
    }

    public Customer(String userName, String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
