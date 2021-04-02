package com.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
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
    private long limit;

    @NotNull
    private int percent;

    public Credit(){

    }

    public String getCreditUUID() {
        return creditUUID;
    }

    public void setCreditUUID(String creditUUID) {
        this.creditUUID = creditUUID;
    }

    public Credit(@NotNull long limit, @NotNull int percent) {
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
                creditUUID.equals(credit.creditUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditUUID, limit, percent);
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
