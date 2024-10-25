package com.example.giuaky.models;

import jakarta.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long sellerId;
        private String firstName;
        private String lastName;
        private String mobileNo;
        private String password;


        public Seller(){
        }

        public Seller(long sellerId,String firstName, String lastName, String mobileNo, String password){
            this.sellerId=sellerId;
            this.firstName=firstName;
            this.lastName=lastName;
            this.mobileNo=mobileNo;
            this.password=password;
        }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
