package com.entities;


import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "offer")
public class CreditOffer {
    @Id
    @GeneratedValue
    private UUID offerId;

    @NotNull
    private String offerUUID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credit_id")
    private Credit credit;

    private long summCredit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public CreditOffer() {

    }

    public String getOfferUUID() {
        return offerUUID;
    }

    public void setOfferUUID(String offerUUID) {
        this.offerUUID = offerUUID;
    }

    public CreditOffer(Client client, Credit credit, long summCredit, Schedule schedule) {
        this.offerId = UUID.randomUUID();
        this.offerUUID = offerId.toString();
        this.client = client;
        this.credit = credit;
        this.summCredit = summCredit;
        this.schedule = schedule;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public void setSummCredit(long summCredit) {
        this.summCredit = summCredit;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public UUID getOfferId() {
        return offerId;
    }

    public Client getClient() {
        return client;
    }

    public Credit getCredit() {
        return credit;
    }

    public long getSummCredit() {
        return summCredit;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditOffer that = (CreditOffer) o;
        return summCredit == that.summCredit &&
                offerUUID.equals(that.offerUUID) &&
                client.equals(that.client) &&
                credit.equals(that.credit) &&
                schedule.equals(that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerUUID, client, credit, summCredit, schedule);
    }
}
