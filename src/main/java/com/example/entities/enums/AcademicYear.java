package com.example.entities.enums;

public enum AcademicYear {
    I(1)  , II(2) , III(3) , IV(4);

    AcademicYear(int year){
        this.year = year;
    }

    private int year;

    public int getYear(){
        return this.year;
    }
    
}
