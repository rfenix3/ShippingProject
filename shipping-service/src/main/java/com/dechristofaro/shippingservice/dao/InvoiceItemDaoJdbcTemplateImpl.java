package com.dechristofaro.shippingservice.dao;
import com.dechristofaro.shippingservice.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_INVOICE_ITEM_SQL =
            "INSERT INTO invoice_item (invoice_id, item_name, item_description, weight, ship_cost) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_INVOICE_ITEM_SQL =
            "SELECT * FROM invoice_item WHERE invoice_item_id = ?";
    private static final String SELECT_ALL_INVOICE_ITEM_SQL =
            "SELECT * FROM invoice_item";
    private static final String SELECT_INVOICE_ITEM_BY_INVOICE_ID_SQL =
            "SELECT * FROM invoice_item WHERE invoice_id = ?";
    private static final String UPDATE_INVOICE_ITEM_SQL =
            "UPDATE invoice_item SET invoice_id = ?, item_name = ?, item_description = ?, weight = ?, ship_cost = ? WHERE invoice_item_id = ?";
    private static final String DELETE_INVOICE_ITEM_SQL =
            "DELETE FROM invoice_item WHERE invoice_item_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public InvoiceItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Methods
    @Override
    @Transactional
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(INSERT_INVOICE_ITEM_SQL,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemName(),
                invoiceItem.getItemDescription(),
                invoiceItem.getWeight(),
                invoiceItem.getShipCost());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        invoiceItem.setInvoiceItemId(id);
        return invoiceItem;
    }

    @Override
    public InvoiceItem getInvoiceItem(int invoiceItemId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_ITEM_SQL, this::mapRowToInvoiceItem, invoiceItemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItem() {
        return jdbcTemplate.query(SELECT_ALL_INVOICE_ITEM_SQL, this::mapRowToInvoiceItem);
    }

    @Override
    public List<InvoiceItem> getInvoiceItemByInvoiceId(int invoiceId) {
        return jdbcTemplate.query(SELECT_INVOICE_ITEM_BY_INVOICE_ID_SQL, this::mapRowToInvoiceItem, invoiceId);
    }

    @Override
    @Transactional
    public void updateInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(UPDATE_INVOICE_ITEM_SQL,
                invoiceItem.getInvoiceId(),
                invoiceItem.getItemName(),
                invoiceItem.getItemDescription(),
                invoiceItem.getWeight(),
                invoiceItem.getShipCost(),
                invoiceItem.getInvoiceItemId());
    }

    @Override
    @Transactional
    public void deleteInvoiceItem(int invoiceItemId) {
        jdbcTemplate.update(DELETE_INVOICE_ITEM_SQL, invoiceItemId);
    }

    private InvoiceItem mapRowToInvoiceItem(ResultSet resultSet, int rowNumber) throws SQLException {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceItemId(resultSet.getInt("invoice_item_id"));
        invoiceItem.setInvoiceId(resultSet.getInt("invoice_id"));
        invoiceItem.setItemName(resultSet.getString("item_name"));
        invoiceItem.setItemDescription(resultSet.getString("item_description"));
        invoiceItem.setWeight(resultSet.getInt("weight"));
        invoiceItem.setShipCost(resultSet.getBigDecimal("ship_cost"));
        return invoiceItem;
    }
}
