package com.proposta.aceita.notificationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;


public class Negotiation {
    private String id;
    private final Interest interest;
    private final Sale sale;
    private final LocalDateTime createdAt;

    public Negotiation(@JsonProperty("id") String id,
                       @JsonProperty("interest") Interest interest,
                       @JsonProperty("sale") Sale sale,
                       @JsonProperty("createdAt") LocalDateTime createdAt) {
        this.id = id;
        this.interest = interest;
        this.sale = sale;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public Interest getInterest() {
        return interest;
    }

    public Sale getSale() {
        return sale;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Negotiation that = (Negotiation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(interest, that.interest) &&
                Objects.equals(sale, that.sale) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, interest, sale, createdAt);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Negotiation.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("interest=" + interest)
                .add("sale=" + sale)
                .add("createdAt=" + createdAt)
                .toString();
    }
}

