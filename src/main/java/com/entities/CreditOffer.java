package com.entities;


import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Set;
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

    @OneToMany(mappedBy = "creditOffer", fetch = FetchType.EAGER)
    private Set<ScheduleOfPayment> scheduleOfPayments;

    public Set<ScheduleOfPayment> getScheduleOfPayments() {
        return scheduleOfPayments;
    }

    public void setScheduleOfPayments(Set<ScheduleOfPayment> scheduleOfPayments) {
        this.scheduleOfPayments = scheduleOfPayments;
    }

    public CreditOffer() {

    }

    public String getOfferUUID() {
        return offerUUID;
    }

    public void setOfferUUID(String offerUUID) {
        this.offerUUID = offerUUID;
    }

    public CreditOffer(Client client, Credit credit, long summCredit) {
        this.offerId = UUID.randomUUID();
        this.offerUUID = offerId.toString();
        this.client = client;
        this.credit = credit;
        this.summCredit = summCredit;
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

}
