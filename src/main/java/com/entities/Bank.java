package com.entities;


import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue
    private UUID bankId;

    public UUID getBankId() {
        return bankId;
    }

    @NotNull
    private String bankUUID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_id")
    Credit credit;

    public String getBankUUID() {
        return bankUUID;
    }

    public void setBankUUID(String bankUUID) {
        this.bankUUID = bankUUID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Bank(){
        this.bankId = UUID.randomUUID();
        this.bankUUID = this.bankId.toString();
    }

    public Bank(@NotNull Client client, @NotNull Credit credit){
        this.bankId = UUID.randomUUID();
        this.bankUUID = this.bankId.toString();
        this.client = client;
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return bankUUID.equals(bank.bankUUID) &&
                client.equals(bank.client) &&
                credit.equals(bank.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankUUID, client, credit);
    }
}

