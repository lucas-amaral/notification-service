package com.proposta.aceita.notificationservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proposta.aceita.notificationservice.entities.enums.PropertyType;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Sale {
    private final Integer id;
    private final Integer propertyId;
    private final Integer neighborhoodId;
    private final PropertyType type;
    private final Integer dorms;
    private final Integer suites;
    private final Integer bathrooms;
    private final Integer garages;
    private final boolean pool;
    private final boolean balcony;
    private final boolean elevator;
    private final boolean barbecueGrill;
    private final BigDecimal value;
    private final boolean financing;
    private final BigDecimal financingValue;
    private final boolean barterVehicle;
    private final BigDecimal barterVehicleValue;
    private final boolean barterProperty;
    private final BigDecimal barterPropertyValue;

    public Sale(@JsonProperty("id") Integer id,
                @JsonProperty("propertyId") Integer propertyId,
                @JsonProperty("neighborhoodId") Integer neighborhoodId,
                @JsonProperty("type") PropertyType type,
                @JsonProperty("dorms") Integer dorms,
                @JsonProperty("suites") Integer suites,
                @JsonProperty("bathrooms") Integer bathrooms,
                @JsonProperty("garages") Integer garages,
                @JsonProperty("pool") boolean pool,
                @JsonProperty("balcony") boolean balcony,
                @JsonProperty("elevator") boolean elevator,
                @JsonProperty("barbecueGrill") boolean barbecueGrill,
                @JsonProperty("value") BigDecimal value,
                @JsonProperty("financing") boolean financing,
                @JsonProperty("financingValue") BigDecimal financingValue,
                @JsonProperty("barterVehicle") boolean barterVehicle,
                @JsonProperty("barterVehicleValue") BigDecimal barterVehicleValue,
                @JsonProperty("barterProperty") boolean barterProperty,
                @JsonProperty("barterPropertyValue") BigDecimal barterPropertyValue) {
        this.id = id;
        this.propertyId = propertyId;
        this.neighborhoodId = neighborhoodId;
        this.type = type;
        this.dorms = dorms;
        this.suites = suites;
        this.bathrooms = bathrooms;
        this.garages = garages;
        this.pool = pool;
        this.balcony = balcony;
        this.elevator = elevator;
        this.barbecueGrill = barbecueGrill;
        this.value = value;
        this.financing = financing;
        this.financingValue = financingValue;
        this.barterVehicle = barterVehicle;
        this.barterVehicleValue = barterVehicleValue;
        this.barterProperty = barterProperty;
        this.barterPropertyValue = barterPropertyValue;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public Integer getNeighborhoodId() {
        return neighborhoodId;
    }

    public PropertyType getType() {
        return type;
    }

    public Integer getDorms() {
        return dorms;
    }

    public Integer getSuites() {
        return suites;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public Integer getGarages() {
        return garages;
    }

    public Boolean getPool() {
        return pool;
    }

    public Boolean getBalcony() {
        return balcony;
    }

    public Boolean getElevator() {
        return elevator;
    }

    public Boolean getBarbecueGrill() {
        return barbecueGrill;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Boolean getFinancing() {
        return financing;
    }

    public BigDecimal getFinancingValue() {
        return financingValue;
    }

    public Boolean getBarterVehicle() {
        return barterVehicle;
    }

    public BigDecimal getBarterVehicleValue() {
        return barterVehicleValue;
    }

    public Boolean getBarterProperty() {
        return barterProperty;
    }

    public BigDecimal getBarterPropertyValue() {
        return barterPropertyValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return pool == sale.pool &&
                balcony == sale.balcony &&
                elevator == sale.elevator &&
                barbecueGrill == sale.barbecueGrill &&
                financing == sale.financing &&
                barterVehicle == sale.barterVehicle &&
                barterProperty == sale.barterProperty &&
                Objects.equals(id, sale.id) &&
                Objects.equals(propertyId, sale.propertyId) &&
                Objects.equals(neighborhoodId, sale.neighborhoodId) &&
                type == sale.type &&
                Objects.equals(dorms, sale.dorms) &&
                Objects.equals(suites, sale.suites) &&
                Objects.equals(bathrooms, sale.bathrooms) &&
                Objects.equals(garages, sale.garages) &&
                Objects.equals(value, sale.value) &&
                Objects.equals(financingValue, sale.financingValue) &&
                Objects.equals(barterVehicleValue, sale.barterVehicleValue) &&
                Objects.equals(barterPropertyValue, sale.barterPropertyValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyId, neighborhoodId, type, dorms, suites, bathrooms, garages, pool, balcony, elevator, barbecueGrill, value, financing, financingValue, barterVehicle, barterVehicleValue, barterProperty, barterPropertyValue);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Sale.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("propertyId=" + propertyId)
                .add("neighborhoodId=" + neighborhoodId)
                .add("type=" + type)
                .add("dorms=" + dorms)
                .add("suites=" + suites)
                .add("bathrooms=" + bathrooms)
                .add("garages=" + garages)
                .add("pool=" + pool)
                .add("balcony=" + balcony)
                .add("elevator=" + elevator)
                .add("barbecueGrill=" + barbecueGrill)
                .add("value=" + value)
                .add("financing=" + financing)
                .add("financingValue=" + financingValue)
                .add("barterVehicle=" + barterVehicle)
                .add("barterVehicleValue=" + barterVehicleValue)
                .add("barterProperty=" + barterProperty)
                .add("barterPropertyValue=" + barterPropertyValue)
                .toString();
    }
}

