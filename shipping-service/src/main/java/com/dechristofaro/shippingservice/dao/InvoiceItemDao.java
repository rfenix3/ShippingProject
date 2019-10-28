package com.dechristofaro.shippingservice.dao;
import com.dechristofaro.shippingservice.model.InvoiceItem;
import java.util.List;

public interface InvoiceItemDao {
    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);
    InvoiceItem getInvoiceItem(int invoiceItemId);
    List<InvoiceItem> getAllInvoiceItem();
    List<InvoiceItem> getInvoiceItemByInvoiceId(int invoiceId);
    void updateInvoiceItem(InvoiceItem invoiceItem);
    void deleteInvoiceItem(int invoiceItemId);
}
