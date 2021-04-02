package com.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client {

    public UUID getClientId() {
        return clientId;
    }

    @Id
    @GeneratedValue
    private UUID clientId;

    @NotNull
    private String clientUUID;

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String passportNumber;

    public Client(){

    }

    public String getClientUUID() {
        return clientUUID;
    }

    public void setClientUUID(String clientUUID) {
        this.clientUUID = clientUUID;
    }

    public Client(@NotNull String name, @NotNull String phoneNumber, @NotNull String email, @NotNull String passportNumber) {
        this.clientId = UUID.randomUUID();
        this.clientUUID = this.clientId.toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientUUID.equals(client.clientUUID) &&
                name.equals(client.name) &&
                phoneNumber.equals(client.phoneNumber) &&
                email.equals(client.email) &&
                passportNumber.equals(client.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientUUID, name, phoneNumber, email, passportNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}

