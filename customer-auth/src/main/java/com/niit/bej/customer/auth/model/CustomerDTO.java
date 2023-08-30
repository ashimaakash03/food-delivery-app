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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
