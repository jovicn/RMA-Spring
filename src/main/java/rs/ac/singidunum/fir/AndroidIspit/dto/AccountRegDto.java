package rs.ac.singidunum.fir.AndroidIspit.dto;

public class AccountRegDto {

    private String forename, surename, email, phoneNumber, addres, city, postalCode, passwordHash;

    public AccountRegDto() {
    }

    public AccountRegDto(String forename, String surename, String email, String phoneNumber, String addres, String city, String postalCode, String passwordHash) {
        this.forename = forename;
        this.surename = surename;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addres = addres;
        this.city = city;
        this.postalCode = postalCode;
        this.passwordHash = passwordHash;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
