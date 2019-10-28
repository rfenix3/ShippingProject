package com.company.shippingedgeservice.model;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    // Properties
    private Integer invoiceId;
    @NotNull(message = "customerId must not be null.")
    @Positive(message = "customerId must be a positive integer value.")
    private Integer customerId;
    @NotNull(message = "shipToZip must not be null.")
    @Size(min = 5, max = 5, message = "shipToZip must be exactly 5 characters in length.")
    private String shipToZip;
    @NotNull(message = "purchaseDate must not be null.")
    @PastOrPresent(message = "purchaseDate must be the present date or in the past.")
    private LocalDate purchaseDate;
    @NotNull(message = "totalCost must not be null.")
    @Digits(integer = 5, fraction = 2, message = "totalCost is in the wrong format. NNNNN.NN")
    private BigDecimal totalCost;
    @NotNull(message = "salesTax must not be null.")
    @Digits(integer = 5, fraction = 2, message = "salesTax is in the wrong format. NNNNN.NN")
    private BigDecimal salesTax;
    @NotNull(message = "surcharge must not be null.")
    @Digits(integer = 5, fraction = 2, message = "surcharge is in the wrong format. NNNNN.NN")
    private BigDecimal surcharge;

    // Constructors
    public Invoice() {

    }

    public Invoice(@NotNull(message = "customerId must not be null.") @Positive(message = "customerId must be a positive integer value.") Integer customerId, @NotNull(message = "shipToZip must not be null.") @Size(min = 5, max = 5, message = "shipToZip must be exactly 5 characters in length.") String shipToZip, @NotNull(message = "purchaseDate must not be null.") @PastOrPresent(message = "purchaseDate must be the present date or in the past.") LocalDate purchaseDate, @NotNull(message = "totalCost must not be null.") @Digits(integer = 5, fraction = 2, message = "totalCost is in the wrong format. NNNNN.NN") BigDecimal totalCost, @NotNull(message = "salesTax must not be null.") @Digits(integer = 5, fraction = 2, message = "salesTax is in the wrong format. NNNNN.NN") BigDecimal salesTax, @NotNull(message = "surcharge must not be null.") @Digits(integer = 5, fraction = 2, message = "surcharge is in the wrong format. NNNNN.NN") BigDecimal surcharge) {
        this.customerId = customerId;
        this.shipToZip = shipToZip;
        this.purchaseDate = purchaseDate;
        this.totalCost = totalCost;
        this.salesTax = salesTax;
        this.surcharge = surcharge;
    }

    public Invoice(Integer invoiceId, @NotNull(message = "customerId must not be null.") @Positive(message = "customerId must be a positive integer value.") Integer customerId, @NotNull(message = "shipToZip must not be null.") @Size(min = 5, max = 5, message = "shipToZip must be exactly 5 characters in length.") String shipToZip, @NotNull(message = "purchaseDate must not be null.") @PastOrPresent(message = "purchaseDate must be the present date or in the past.") LocalDate purchaseDate, @NotNull(message = "totalCost must not be null.") @Digits(integer = 5, fraction = 2, message = "totalCost is in the wrong format. NNNNN.NN") BigDecimal totalCost, @NotNull(message = "salesTax must not be null.") @Digits(integer = 5, fraction = 2, message = "salesTax is in the wrong format. NNNNN.NN") BigDecimal salesTax, @NotNull(message = "surcharge must not be null.") @Digits(integer = 5, fraction = 2, message = "surcharge is in the wrong format. NNNNN.NN") BigDecimal surcharge) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.shipToZip = shipToZip;
        this.purchaseDate = purchaseDate;
        this.totalCost = totalCost;
        this.salesTax = salesTax;
        this.surcharge = surcharge;
    }

    // Getters
    public Integer getInvoiceId() {
        return this.invoiceId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public String getShipToZip() {
        return this.shipToZip;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public BigDecimal getSalesTax() {
        return this.salesTax;
    }

    public BigDecimal getSurcharge() {
        return this.surcharge;
    }

    // Setters
    public void setInvoiceId(Integer invoiceIdIn) {
        this.invoiceId = invoiceIdIn;
    }

    public void setCustomerId(Integer customerIdIn) {
        this.customerId = customerIdIn;
    }

    public void setShipToZip(String shipToZipIn) {
        this.shipToZip = shipToZipIn;
    }

    public void setPurchaseDate(LocalDate purchaseDateIn) {
        this.purchaseDate = purchaseDateIn;
    }

    public void setTotalCost(BigDecimal totalCostIn) {
        this.totalCost = totalCostIn;
    }

    public void setSalesTax(BigDecimal salesTaxIn) {
        this.salesTax = salesTaxIn;
    }

    public void setSurcharge(BigDecimal surchargeIn) {
        this.surcharge = surchargeIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceId, invoice.invoiceId) &&
                customerId.equals(invoice.customerId) &&
                shipToZip.equals(invoice.shipToZip) &&
                purchaseDate.equals(invoice.purchaseDate) &&
                totalCost.equals(invoice.totalCost) &&
                salesTax.equals(invoice.salesTax) &&
                surcharge.equals(invoice.surcharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, customerId, shipToZip, purchaseDate, totalCost, salesTax, surcharge);
    }
}
