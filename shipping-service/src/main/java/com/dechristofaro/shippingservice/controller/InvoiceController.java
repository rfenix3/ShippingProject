package com.dechristofaro.shippingservice.controller;
import com.dechristofaro.shippingservice.dao.InvoiceDao;
import com.dechristofaro.shippingservice.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {
    // Properties
    @Autowired
    private InvoiceDao invoiceDao;

    // Methods
    @Transactional
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody @Valid Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }
    
    @RequestMapping(value = "invoice/{invoiceId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoice(@PathVariable int invoiceId) {
        // Get the request Invoice from the database
        Invoice invoiceFromDB = invoiceDao.getInvoice(invoiceId);

        // Return the Invoice if it is found in the database
        if(invoiceFromDB != null) {
            return invoiceFromDB;
        } else {
            throw new IllegalArgumentException("There is no Invoice with the id: " + invoiceId);
        }
    }
    
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoice() {
        // Get all Invoices in the database
        return invoiceDao.getAllInvoice();
    }
    
    @RequestMapping(value = "/invoice/byCustomer/{cusomterId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getInvoiceByCustomerId(@PathVariable int customerId) {
        // Get all Invoice in the database by a specific customerId
        return invoiceDao.getInvoiceByCustomerId(customerId);
    }
    
    @Transactional
    @RequestMapping(value = "/invoice", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateInvoice(@RequestBody @Valid Invoice invoice) {
        // Validate that the Invoice object has an Id
        if(invoice.getInvoiceId() == null) {
            throw new IllegalArgumentException("You must pass an Invoice ID when trying to update.");
        }

        // Get the Invoice object from the database
        Invoice invoiceFromDB = invoiceDao.getInvoice(invoice.getInvoiceId());

        // Update the Invoice if it is found in the database
        if(invoiceFromDB != null) {
            invoiceDao.updateInvoice(invoice);
        } else {
            throw new IllegalArgumentException("There is no Invoice with id: " + invoice.getInvoiceId());
        }
    }
    
    @Transactional
    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteInvoice(@PathVariable int invoiceId) {
        // Get the Invoice from the database
        Invoice invoiceFromDB = invoiceDao.getInvoice(invoiceId);

        // Delete the Invoice if it is found in the database
        if (invoiceFromDB != null) {
            invoiceDao.deleteInvoice(invoiceId);
        } else {
            throw new IllegalArgumentException("There is no Invoice with id: " + invoiceId);
        }
    }
}
