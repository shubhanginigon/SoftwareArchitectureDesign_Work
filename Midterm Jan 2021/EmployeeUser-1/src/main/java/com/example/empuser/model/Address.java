package com.example.empuser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @EmbeddedId
    private AddressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee emp;
}