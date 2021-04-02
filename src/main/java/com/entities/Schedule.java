package com.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue
    private UUID scheduleId;

    @NotNull
    private String scheduleUUID;

    @NotNull
    private Date dateOfPay;

    @NotNull
    private long sum;

    @NotNull
    private long sumOfBody;

    @NotNull
    private long sumOfPercent;

    public Schedule(){

    }

    public String getScheduleUUID() {
        return scheduleUUID;
    }

    public void setScheduleUUID(String scheduleUUID) {
        this.scheduleUUID = scheduleUUID;
    }

    public Schedule(Date dateOfPay, long sum, long sumOfBody, long sumOfPercent) {
        this.scheduleId = UUID.randomUUID();
        this.scheduleUUID = this.scheduleId.toString();
        this.dateOfPay = dateOfPay;
        this.sum = sum;
        this.sumOfBody = sumOfBody;
        this.sumOfPercent = sumOfPercent;
    }

    public Date getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(Date dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public UUID getScheduleId() {
        return scheduleId;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
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
        Schedule schedule = (Schedule) o;
        return sum == schedule.sum &&
                sumOfBody == schedule.sumOfBody &&
                sumOfPercent == schedule.sumOfPercent &&
                scheduleUUID.equals(schedule.scheduleUUID) &&
                dateOfPay.equals(schedule.dateOfPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleUUID, dateOfPay, sum, sumOfBody, sumOfPercent);
    }
}
