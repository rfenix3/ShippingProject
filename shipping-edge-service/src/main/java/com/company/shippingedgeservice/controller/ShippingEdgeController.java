package com.company.shippingedgeservice.controller;


import com.company.shippingedgeservice.service.ShippingServiceLayer;
import com.company.shippingedgeservice.viewmodel.InvoiceViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * allows customers to ship one or more items
 * allows customers to look up past orders by Customer ID
 */

@RestController
public class ShippingEdgeController {


    // All DAOs for each model is created with ServiceLayer's contructor.
    private final ShippingServiceLayer shippingServiceLayer;

    public ShippingEdgeController(ShippingServiceLayer shippingServiceLayer) {
        this.shippingServiceLayer = shippingServiceLayer;
    }

    //@GetMapping
    @RequestMapping(value = "/shipping/{invoiceId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoiceViewModelByInvoiceId(@PathVariable Integer invoiceId) {
        return shippingServiceLayer.findInvoiceViewModelByInvoiceId(invoiceId);

    }



}
