package com.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "scheduleOfPayment")
public class ScheduleOfPayment {
    @Id
    @GeneratedValue
    private UUID scheduleId;

    @NotNull
    private String scheduleUUID;

    @Basic
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateOfPay;

    @NotNull
    private long allSum;

    @NotNull
    private long sumOfBody;

    @NotNull
    private long sumOfPercent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offer_id", nullable = false)
    private CreditOffer creditOffer;

    public ScheduleOfPayment(){

    }

    public String getScheduleUUID() {
        return scheduleUUID;
    }

    public void setScheduleUUID(String scheduleUUID) {
        this.scheduleUUID = scheduleUUID;
    }

    public ScheduleOfPayment(LocalDate dateOfPay, long allSum, long sumOfBody, long sumOfPercent) {
        ZoneId zoneId = ZoneId.systemDefault();
        this.scheduleId = UUID.randomUUID();
        this.scheduleUUID = this.scheduleId.toString();
        this.dateOfPay = Date.from(dateOfPay.atStartOfDay(zoneId).toInstant());;
        this.allSum = allSum;
        this.sumOfBody = sumOfBody;
        this.sumOfPercent = sumOfPercent;
    }

    public Date getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(LocalDate dateOfPay) {
        ZoneId zoneId = ZoneId.systemDefault();
        this.dateOfPay = Date.from(dateOfPay.atStartOfDay(zoneId).toInstant());;
    }

    public UUID getScheduleId() {
        return scheduleId;
    }

    public long getAllSum() {
        return allSum;
    }

    public void setAllSum(long allSum) {
        this.allSum = allSum;
    }

    public long getSumOfBody() {
        return sumOfBody;
    }

    public void setSumOfBody(long sumOfBody) {
        this.sumOfBody = sumOfBody;
    }

    public long getSumOfPercent() {
        return sumOfPercent;
    }

    public void setSumOfPercent(long sumOfPercent) {
        this.sumOfPercent = sumOfPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleOfPayment scheduleOfPayment = (ScheduleOfPayment) o;
        return allSum == scheduleOfPayment.allSum &&
                sumOfBody == scheduleOfPayment.sumOfBody &&
                sumOfPercent == scheduleOfPayment.sumOfPercent &&
                scheduleUUID.equals(scheduleOfPayment.scheduleUUID) &&
                dateOfPay.equals(scheduleOfPayment.dateOfPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleUUID, dateOfPay, allSum, sumOfBody, sumOfPercent);
    }
}
