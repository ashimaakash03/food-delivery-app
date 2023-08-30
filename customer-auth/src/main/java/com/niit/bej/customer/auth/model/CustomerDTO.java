package com.niit.bej.customer.auth.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(fullname, that.fullname) && Objects.equals(contact, that.contact) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, contact, email);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "fullname='" + fullname + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
