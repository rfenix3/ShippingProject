package com.company.shippingedgeservice.service;

import com.company.shippingedgeservice.model.Invoice;
import com.company.shippingedgeservice.util.feign.InvoiceClient;
import com.company.shippingedgeservice.util.feign.InvoiceItemClient;
import com.company.shippingedgeservice.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * allows customers to ship one or more items
 * allows customers to look up past orders by Customer ID
 */


@Service
public class ShippingServiceLayer {

    private InvoiceClient invoiceClient;
    private InvoiceItemClient invoiceItemClient;

    @Autowired
    public ShippingServiceLayer(InvoiceClient invoiceClient, InvoiceItemClient invoiceItemClient) {
        this.invoiceClient = invoiceClient;
        this.invoiceItemClient = invoiceItemClient;
    }

    public InvoiceViewModel findInvoiceViewModelByInvoiceId(Integer invoiceId){
        Invoice invoice= invoiceClient.getInvoiceByInvoiceId(invoiceId);

        return buildInvoiceViewModel(invoice);

    }


    // Helper Methods
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // Assemble the InvoiceViewModel
        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setCustomerId(invoice.getCustomerId());
        ivm.setShipToZip(invoice.getShipToZip());
        ivm.setPurchaseDate(invoice.getPurchaseDate());
        ivm.setTotalCost(invoice.getTotalCost());
        ivm.setSalesTax(invoice.getSalesTax());
        ivm.setSurcharge(invoice.getSurcharge());

        ivm.setInvoiceItemList(invoiceItemClient.findInvoiceItemsByInvoiceId(invoice.getInvoiceId()));

        // Return the InvoiceViewModel
        return ivm;

    }


}
