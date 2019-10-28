package com.company.shippingedgeservice.util.feign;

import com.company.shippingedgeservice.model.Invoice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * getAllBooks
 * getBookByIsbn
 */

@FeignClient(name = "shipping-service")
public interface InvoiceClient {
    //@GetMapping
    @RequestMapping(value = "/invoice/{customerId}", method = RequestMethod.GET)
    public List<Invoice> findInvoiceByCustomerId(Integer customerId);

    //@GetMapping
    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.GET)
    public Invoice getInvoiceByInvoiceId(Integer invoiceId);


}


