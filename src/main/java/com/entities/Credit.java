package com.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue
    private UUID creditId;

    @NotNull
    private String creditUUID;

    @NotNull
    private String creditName;

    @NotNull
    private long limit;

    @NotNull
    private int percent;

    @OneToMany(mappedBy = "credit", fetch = FetchType.EAGER)
    private Set<CreditOffer> creditOffers;

    public Set<CreditOffer> getCreditOffers() {
        return creditOffers;
    }

    public void setCreditOffers(Set<CreditOffer> creditOffers) {
        this.creditOffers = creditOffers;
    }

    public Credit(){

    }

    public String getCreditUUID() {
        return creditUUID;
    }

    public void setCreditUUID(String creditUUID) {
        this.creditUUID = creditUUID;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Credit(@NotNull long limit, @NotNull int percent, @NotNull String creditName) {
        this.creditName = creditName;
        this.creditId = UUID.randomUUID();
        this.creditUUID = creditId.toString();
        this.limit = limit;
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return limit == credit.limit &&
                percent == credit.percent &&
                creditUUID.equals(credit.creditUUID) &&
                creditName.equals(credit.creditName) &&
                Objects.equals(creditOffers, credit.creditOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditUUID, creditName, limit, percent, creditOffers);
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public UUID getCreditId() {
        return creditId;
    }
}
