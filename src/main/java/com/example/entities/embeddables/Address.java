package com.example.entities.embeddables;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@EqualsAndHashCode
public class Address {
    
    @Column(name = "street_name" , length = 40 , nullable = false)
    private String streetName;

    @Column(name = "lives_in_apartment" , nullable = false)
    private Boolean livesInApartment;

    @Column(name = "flat_number" , length = 40 , nullable = false)
    private String flatNumber;

    @Column(name = "zip_code" , nullable = false)
    private Integer zipCode;

    

    public Address(final String stretName , final Boolean livesInApartment,
                   final String flatNumber , final Integer zipCode){
        this.streetName = stretName;
        this.livesInApartment = livesInApartment;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;            
    }

    protected Address(){}


}
