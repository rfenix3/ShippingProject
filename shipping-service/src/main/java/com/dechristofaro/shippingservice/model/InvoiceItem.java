package com.dechristofaro.shippingservice.model;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {
    // Properties
    private Integer invoiceItemId;
    @NotNull(message = "invoiceId must not be null.")
    @Positive(message = "invoiceId must be a positive integer.")
    private Integer invoiceId;
    @NotNull(message = "itemName must not be null.")
    @Size(min = 1, max = 50, message = "itemName must be between 1 and 50 characters in length.")
    private String itemName;
    @NotNull(message = "itemDescription must not be null.")
    @Size(min = 1, max = 255, message = "itemDescription must be between 1 and 255 characters in length.")
    private String itemDescription;
    @NotNull(message = "weight must not be null.")
    @Positive(message = "weight must be a positive value.")
    private Integer weight;
    @NotNull(message = "shipCost must not be null.")
    @Digits(integer = 5, fraction = 2, message = "shipCost is in the wrong format. NNNNN.NN")
    private BigDecimal shipCost;

    // Constructors
    public InvoiceItem() {

    }

    public InvoiceItem(@NotNull(message = "invoiceId must not be null.") @Positive(message = "invoiceId must be a positive integer.") Integer invoiceId, @NotNull(message = "itemName must not be null.") @Size(min = 1, max = 50, message = "itemName must be between 1 and 50 characters in length.") String itemName, @NotNull(message = "itemDescription must not be null.") @Size(min = 1, max = 255, message = "itemDescription must be between 1 and 255 characters in length.") String itemDescription, @NotNull(message = "weight must not be null.") @Positive(message = "weight must be a positive value.") Integer weight, @NotNull(message = "shipCost must not be null.") @Digits(integer = 5, fraction = 2, message = "shipCost is in the wrong format. NNNNN.NN") BigDecimal shipCost) {
        this.invoiceId = invoiceId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    public InvoiceItem(Integer invoiceItemId, @NotNull(message = "invoiceId must not be null.") @Positive(message = "invoiceId must be a positive integer.") Integer invoiceId, @NotNull(message = "itemName must not be null.") @Size(min = 1, max = 50, message = "itemName must be between 1 and 50 characters in length.") String itemName, @NotNull(message = "itemDescription must not be null.") @Size(min = 1, max = 255, message = "itemDescription must be between 1 and 255 characters in length.") String itemDescription, @NotNull(message = "weight must not be null.") @Positive(message = "weight must be a positive value.") Integer weight, @NotNull(message = "shipCost must not be null.") @Digits(integer = 5, fraction = 2, message = "shipCost is in the wrong format. NNNNN.NN") BigDecimal shipCost) {
        this.invoiceItemId = invoiceItemId;
        this.invoiceId = invoiceId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.weight = weight;
        this.shipCost = shipCost;
    }

    // Getters
    public Integer getInvoiceItemId() {
        return this.invoiceItemId;
    }

    public Integer getInvoiceId() {
        return this.invoiceId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public BigDecimal getShipCost() {
        return this.shipCost;
    }

    // Setters
    public void setInvoiceItemId(Integer invoiceItemIdIn) {
        this.invoiceItemId = invoiceItemIdIn;
    }

    public void setInvoiceId(Integer invoiceIdIn) {
        this.invoiceId = invoiceIdIn;
    }

    public void setItemName(String itemNameIn) {
        this.itemName = itemNameIn;
    }

    public void setItemDescription(String itemDescriptionIn) {
        this.itemDescription = itemDescriptionIn;
    }

    public void setWeight(Integer weightIn) {
        this.weight = weightIn;
    }

    public void setShipCost(BigDecimal shipCostIn) {
        this.shipCost = shipCostIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return Objects.equals(invoiceItemId, that.invoiceItemId) &&
                invoiceId.equals(that.invoiceId) &&
                itemName.equals(that.itemName) &&
                itemDescription.equals(that.itemDescription) &&
                weight.equals(that.weight) &&
                shipCost.equals(that.shipCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, invoiceId, itemName, itemDescription, weight, shipCost);
    }
}
