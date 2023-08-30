package com.niit.bej.customer.auth.model;

public class CustomerDTO {
    private String fullname;
    private String contact;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(String fullname, String contact, String email) {
        this.fullname = fullname;
        this.contact = contact;
        this.email = email;
    }
}
