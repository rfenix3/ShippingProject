package com.dechristofaro.shippingservice.dao;
import com.dechristofaro.shippingservice.model.Invoice;
import com.dechristofaro.shippingservice.model.InvoiceItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class InvoiceItemDaoTest {
    // Autowired Dao
    @Autowired
    private InvoiceItemDao invoiceItemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    // setUp()
    @BeforeEach
    public void setUp() throws Exception {
        // Clean up the Invoice Item table in the database
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItem();
        invoiceItemList.forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        // Clean up the Invoice table in the database
        List<Invoice> invoiceList = invoiceDao.getAllInvoice();
        invoiceList.forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
    }

    // Tests
    @Test
    public void addInvoiceItem() {
        // Add a new Invoice object to the database
        Invoice invoice = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        invoice = invoiceDao.addInvoice(invoice);

        // Add a new Invoice Item object to the database
        InvoiceItem invoiceItem = new InvoiceItem(invoice.getInvoiceId(), "name1", "description1", 10, new BigDecimal("9.99"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        // Create a copy of the newly added Invoice Object
        InvoiceItem invoiceItemCopy = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        // Test addInvoiceItem() method
        assertEquals(invoiceItem, invoiceItemCopy);
    }

    @Test
    public void getInvoiceItem() {
        // Add a new Invoice object to the database
        Invoice invoice = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        invoice = invoiceDao.addInvoice(invoice);

        // Add a new Invoice Item object to the database
        InvoiceItem invoiceItem = new InvoiceItem(invoice.getInvoiceId(), "name1", "description1", 10, new BigDecimal("9.99"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        // Create a copy of the newly added Invoice Object
        InvoiceItem invoiceItemCopy = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        // Test addInvoiceItem() method
        assertEquals(invoiceItem, invoiceItemCopy);
    }

    @Test
    public void getAllInvoiceItem() {
        // Add a new Invoice object to the database
        Invoice invoice = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        invoice = invoiceDao.addInvoice(invoice);

        // Add 2 InvoiceItem objects to the database
        InvoiceItem invoiceItem1 = new InvoiceItem(invoice.getInvoiceId(), "name1", "description1", 10, new BigDecimal("9.99"));
        InvoiceItem invoiceItem2 = new InvoiceItem(invoice.getInvoiceId(), "name2", "description2", 10, new BigDecimal("9.99"));
        invoiceItem1 = invoiceItemDao.addInvoiceItem(invoiceItem1);
        invoiceItem2 = invoiceItemDao.addInvoiceItem(invoiceItem2);

        // Get a List of all the Invoice Item objects in the database
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItem();

        // Test getAlInvoiceItem() method
        assertEquals(2, invoiceItemList.size());
    }

    @Test
    public void getInvoiceItemByInvoiceId() {
        // Add 2 Invoice objects to the database
        Invoice invoice1 = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        Invoice invoice2 = new Invoice(2, "99999", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        invoice1 = invoiceDao.addInvoice(invoice1);
        invoice2 = invoiceDao.addInvoice(invoice2);

        // Add 3 InvoiceItem objects to the database
        InvoiceItem invoiceItem1 = new InvoiceItem(invoice1.getInvoiceId(), "name1", "description1", 10, new BigDecimal("9.99"));
        InvoiceItem invoiceItem2 = new InvoiceItem(invoice1.getInvoiceId(), "name2", "description2", 10, new BigDecimal("9.99"));
        InvoiceItem invoiceItem3 = new InvoiceItem(invoice2.getInvoiceId(), "name3", "description3", 10, new BigDecimal("9.99"));
        invoiceItem1 = invoiceItemDao.addInvoiceItem(invoiceItem1);
        invoiceItem2 = invoiceItemDao.addInvoiceItem(invoiceItem2);
        invoiceItem3 = invoiceItemDao.addInvoiceItem(invoiceItem3);

        // Get a list of all InvoiceItems by InvoiceId
        List<InvoiceItem> invoiceId1InvoiceItemList = invoiceItemDao.getInvoiceItemByInvoiceId(invoice1.getInvoiceId());
        List<InvoiceItem> invoiceId2InvoiceItemList = invoiceItemDao.getInvoiceItemByInvoiceId(invoice2.getInvoiceId());

        // Test getInvoiceItemByInvoiceId() method
        assertEquals(2, invoiceId1InvoiceItemList.size());
        assertEquals(1, invoiceId2InvoiceItemList.size());
    }

    @Test
    public void updateInvoiceItem() {
        // Add an Invoice object to the database
        Invoice invoice = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        invoice = invoiceDao.addInvoice(invoice);

        // Add an InvoiceItem object to the database
        InvoiceItem invoiceItem = new InvoiceItem(invoice.getInvoiceId(), "name1", "description1", 10, new BigDecimal("9.99"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        // Update the Invoice Item in the database
        invoiceItem.setItemDescription("Update");
        invoiceItemDao.updateInvoiceItem(invoiceItem);

        // Get a copy of the updated invoice item object
        InvoiceItem invoiceItemCopy = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        // Test updateInvoiceItem() method
        assertEquals(invoiceItem, invoiceItemCopy);
    }

    @Test
    public void deleteInvoiceItem() {
        // Add an Invoice object to the database
        Invoice invoice = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        invoice = invoiceDao.addInvoice(invoice);

        // Add an InvoiceItem object to the database
        InvoiceItem invoiceItem = new InvoiceItem(invoice.getInvoiceId(), "name1", "description1", 10, new BigDecimal("9.99"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        // Delete the Invoice Item object from the database
        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        // Get a copy of the deleted invoice item object
        InvoiceItem invoiceItemCopy = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        // Test deleteInvoice() method
        assertNull(invoiceItemCopy);
    }
}
