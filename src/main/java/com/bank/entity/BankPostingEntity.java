package com.bank.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

public class BankPostingEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postingId;

    @Column
    private LocalDate postingDate;

    @Column
    private Integer originAccount;

    @Column
    private Integer recipientAccount;

    @Column
    private Integer totalValue;

    public BankPostingEntity() {
    }

    public int getPostingId() {
        return postingId;
    }

    public void setPostingId(int postingId) {
        this.postingId = postingId;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public Integer getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(Integer originAccount) {
        this.originAccount = originAccount;
    }

    public Integer getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(Integer recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "BankPostingEntity{" +
                "postingId=" + postingId +
                ", postingDate=" + postingDate +
                ", originAccount=" + originAccount +
                ", recipientAccount=" + recipientAccount +
                ", totalValue=" + totalValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankPostingEntity)) return false;
        BankPostingEntity that = (BankPostingEntity) o;
        return getPostingId() == that.getPostingId() &&
                Objects.equals(getPostingDate(), that.getPostingDate()) &&
                Objects.equals(getOriginAccount(), that.getOriginAccount()) &&
                Objects.equals(getRecipientAccount(), that.getRecipientAccount()) &&
                Objects.equals(getTotalValue(), that.getTotalValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostingId(), getPostingDate(), getOriginAccount(), getRecipientAccount(), getTotalValue());
    }
}
