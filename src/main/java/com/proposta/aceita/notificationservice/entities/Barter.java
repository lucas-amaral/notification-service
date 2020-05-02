package com.proposta.aceita.notificationservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.proposta.aceita.notificationservice.entities.enums.BarterType;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Barter {
    private final BarterType type;
    private final BigDecimal value;

    public Barter(@JsonProperty("type") BarterType type, @JsonProperty("value") BigDecimal value) {
        this.type = type;
        this.value = value;
    }

    public BarterType getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barter barter = (Barter) o;
        return type == barter.type &&
                Objects.equals(value, barter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Barter.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("value=" + value)
                .toString();
    }
}
