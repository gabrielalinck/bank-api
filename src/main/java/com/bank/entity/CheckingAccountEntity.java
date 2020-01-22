package com.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
public class CheckingAccountEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String socialNumber;

    @Column
    private Integer totalSavings;

    public CheckingAccountEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public Integer getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(Integer totalSavings) {
        this.totalSavings = totalSavings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccountEntity)) return false;
        CheckingAccountEntity that = (CheckingAccountEntity) o;
        return getId() == that.getId() &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getSocialNumber(), that.getSocialNumber()) &&
                Objects.equals(getTotalSavings(), that.getTotalSavings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getSocialNumber(), getTotalSavings());
    }

    @Override
    public String toString() {
        return "CheckingAccountEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialNumber='" + socialNumber + '\'' +
                ", totalSavings=" + totalSavings +
                '}';
    }
}