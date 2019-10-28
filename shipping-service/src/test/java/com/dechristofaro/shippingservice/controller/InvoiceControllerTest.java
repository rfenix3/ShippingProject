package com.dechristofaro.shippingservice.controller;
import com.dechristofaro.shippingservice.dao.InvoiceDao;
import com.dechristofaro.shippingservice.dao.InvoiceItemDao;
import com.dechristofaro.shippingservice.model.Invoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {
    // Properties
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private InvoiceDao invoiceDao;
    @MockBean
    private InvoiceItemDao invoiceItemDao;
    private ObjectMapper objectMapper = new ObjectMapper();

    // Tests
    @Test
    public void addInvoice_ShouldReturnCreatedInvoice() throws Exception {
        Invoice inputInvoice = new Invoice(1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        String inputJson = objectMapper.writeValueAsString(inputInvoice);

        Invoice responseInvoice = new Invoice(1,1, "00000", LocalDate.now(), new BigDecimal("9.99"), new BigDecimal("0.99"), new BigDecimal("0.25"));
        String responseJson = objectMapper.writeValueAsString(responseInvoice);

        Mockito.when(invoiceDao.addInvoice(inputInvoice)).thenReturn(responseInvoice);

        this.mockMvc.perform(post("/invoice")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }
}
