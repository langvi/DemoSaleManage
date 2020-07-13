package controller;

import base.BaseApp;
import base.NameCompare;
import base.PriceCompare;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Product;

public class HangHoaController {

    ArrayList<Product> listProduct = new ArrayList<>();

    public void fetch_production_db(String query, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<Product> list = new ArrayList<>();
        if(!listProduct.isEmpty()){
            listProduct.clear();
        }
        try {
            Statement st = BaseApp.connectDB().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("product_name"));
                product.setId(rs.getString("product_ID"));
                product.setProduct_number(rs.getInt("product_number"));
                product.setRetail_price(rs.getInt("product_retail_price"));
                product.setCategory(rs.getString("product_category"));
                list.add(product);
                listProduct.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[5];
            data[0] = list.get(i).getName();
            data[1] = list.get(i).getId();
            data[2] = Integer.toString(list.get(i).getProduct_number());
            data[3] = BaseApp.formatMoney(list.get(i).getRetail_price());
            data[4] = list.get(i).getCategory();
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }
    // Add product information to data base

    public void add_info_product_db(Product base_product) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        try {
            Statement st = BaseApp.connectDB().createStatement();
            String query = "INSERT INTO product(product_name, "
                    + "product_category,product_retail_price, product_entry_price, product_number, product_create_at) "
                    + "VALUES ('" + base_product.getName() + "','" + base_product.getCategory() + "',"
                    + base_product.getRetail_price() + "," + base_product.getEntry_price()
                    + "," + base_product.getProduct_number() + ",'"
                    + dateString + "')";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Search product from database via text field search 
    public void searching_text_field_db(String text, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<Product> list = new ArrayList<>();
        try {
            Statement st = BaseApp.connectDB().createStatement();
            String query = "SELECT * FROM product WHERE product_name = '" + text + "'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("product_name"));
                product.setId(rs.getString("product_ID"));
                product.setProduct_number(rs.getInt("product_number"));
                product.setRetail_price(rs.getInt("product_retail_price"));
                product.setCategory(rs.getString("product_category"));
                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[5];
            data[0] = list.get(i).getName();
            data[1] = list.get(i).getId();
            data[2] = Integer.toString(list.get(i).getProduct_number());
            data[3] = BaseApp.formatMoney(list.get(i).getRetail_price());
            data[4] = list.get(i).getCategory();
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();

    }

    public void searching_product_category(String text, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<Product> list = new ArrayList<>();
        try {
            Statement st = BaseApp.connectDB().createStatement();
            String query = "SELECT * FROM product WHERE product_category = '" + text + "'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("product_name"));
                product.setId(rs.getString("product_ID"));
                product.setProduct_number(rs.getInt("product_number"));
                product.setRetail_price(rs.getInt("product_retail_price"));
                product.setCategory(rs.getString("product_category"));
                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[5];
            data[0] = list.get(i).getName();
            data[1] = list.get(i).getId();
            data[2] = Integer.toString(list.get(i).getProduct_number());
            data[3] = BaseApp.formatMoney(list.get(i).getRetail_price());
            data[4] = list.get(i).getCategory();
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();

    }

    public void sortProduct(int tieuChi, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        if (tieuChi == 1) {
            Collections.sort(listProduct, new NameCompare());
        } else if (tieuChi == 2) {
            Collections.sort(listProduct, new PriceCompare(false));
        } else if (tieuChi == 3) {
            Collections.sort(listProduct, new PriceCompare(true));
        }
        for (int i = 0; i < listProduct.size(); i++) {
            String[] data = new String[5];
            data[0] = listProduct.get(i).getName();
            data[1] = listProduct.get(i).getId();
            data[2] = Integer.toString(listProduct.get(i).getProduct_number());
            data[3] = BaseApp.formatMoney(listProduct.get(i).getRetail_price());
            data[4] = listProduct.get(i).getCategory();
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();

    }

}
