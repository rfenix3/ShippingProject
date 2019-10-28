package com.company.shippingedgeservice.viewmodel;

import com.company.shippingedgeservice.model.InvoiceItem;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {
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
    private List<InvoiceItem> invoiceItemList;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getShipToZip() {
        return shipToZip;
    }

    public void setShipToZip(String shipToZip) {
        this.shipToZip = shipToZip;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }

    public List<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    public void setInvoiceItemList(List<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getInvoiceId().equals(that.getInvoiceId()) &&
                getCustomerId().equals(that.getCustomerId()) &&
                getShipToZip().equals(that.getShipToZip()) &&
                getPurchaseDate().equals(that.getPurchaseDate()) &&
                getTotalCost().equals(that.getTotalCost()) &&
                getSalesTax().equals(that.getSalesTax()) &&
                getSurcharge().equals(that.getSurcharge()) &&
                Objects.equals(getInvoiceItemList(), that.getInvoiceItemList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getCustomerId(), getShipToZip(), getPurchaseDate(), getTotalCost(), getSalesTax(), getSurcharge(), getInvoiceItemList());
    }

    @Override
    public String toString() {
        return "ShippingViewModel{" +
                "invoiceId=" + invoiceId +
                ", customerId=" + customerId +
                ", shipToZip='" + shipToZip + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", totalCost=" + totalCost +
                ", salesTax=" + salesTax +
                ", surcharge=" + surcharge +
                ", invoiceItemList=" + invoiceItemList +
                '}';
    }
}
