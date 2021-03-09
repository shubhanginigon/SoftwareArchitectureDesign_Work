package com.example.empuser.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class AddressId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;
    private String streetAddress;
    private String houseNo;
    private String zipcode;

}