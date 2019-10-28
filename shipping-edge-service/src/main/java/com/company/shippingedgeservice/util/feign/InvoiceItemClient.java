package com.company.shippingedgeservice.util.feign;

import com.company.shippingedgeservice.model.InvoiceItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "shipping-service")
public interface InvoiceItemClient {


//    //@GetMapping
//    @RequestMapping(value = "/invoice/{customerId}", method = RequestMethod.GET)
//    public List<Invoice> findInvoiceByCustomerId(Integer customerId);

    //@GetMapping
    @RequestMapping(value = "/invoiceitem/{invoiceId}", method = RequestMethod.GET)
    public List<InvoiceItem> findInvoiceItemsByInvoiceId(Integer invoiceId);

}
