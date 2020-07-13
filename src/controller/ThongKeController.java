/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import base.BaseApp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.productProperties;

/**
 *
 * @author Laptop88
 */
public class ThongKeController {

    public Connection conn = BaseApp.connectDB();
    public String product_name;
    public int product_product_retail_price;
    private JLabel productValue;
    private JLabel moneyValue;
    private JLabel profitValue;

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void callDataDay(String query, JTable table, JLabel product_label, JLabel money_label, JLabel profit_label) {
        int total_Product = 0;
        int total_Money_out = 0;
        int total_Profit = 0;
        int total_Money_in = 0;
        ArrayList<Integer> list_order = new ArrayList<Integer>();
        ArrayList<Integer> list_product = new ArrayList<Integer>();
        try {
            Statement pst = BaseApp.connectDB().createStatement();
            ResultSet rs = pst.executeQuery(query);
            while (rs.next()) {
                productProperties order = new productProperties();
                order.setOrder_ID(rs.getInt("order_ID"));
                list_order.add(order.getOrder_ID());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nameConcate = "";
        for (int i = 0; i < list_order.size(); i++) {
            nameConcate += "" + list_order.get(i) + ",";
        }
        String str = nameConcate;
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        String query_unique_product_ID = "select distinct product_ID FROM order_product where order_ID in " + "(" + str + ");";
        try {
            Statement pst_1 = BaseApp.connectDB().createStatement();
            ResultSet rs_1 = pst_1.executeQuery(query_unique_product_ID);
            while (rs_1.next()) {
                productProperties product_ID = new productProperties();
                product_ID.setProduct_code(rs_1.getInt("product_ID"));
                list_product.add(product_ID.getProduct_code());
            }
        } catch (SQLException e) {
            Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, e);
        }
        String product_list = "";
        for (int i = 0; i < list_product.size(); i++) {
            product_list += "" + list_product.get(i) + ",";
        }
        String str_1 = product_list;
        if (str_1 != null && str_1.length() > 0 && str_1.charAt(str_1.length() - 1) == ',') {
            str_1 = str_1.substring(0, str_1.length() - 1);
        }
        Integer[] data = new Integer[list_product.size()];
        for (int i = 0; i < list_product.size(); i++) {
            String product_number = "select total_product FROM order_product where order_ID in " + "(" + str + ") and product_ID =" + list_product.get(i) + ";";
            try {
                Statement pst_2 = BaseApp.connectDB().createStatement();
                ResultSet rs_2 = pst_2.executeQuery(product_number);
                int total = 0;
                while (rs_2.next()) {

                    total += rs_2.getInt("total_product");
                }
                data[i] = total;
            } catch (SQLException e) {
                Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<productProperties> list = new ArrayList<productProperties>();
        String get_product = "SELECT product_ID,product_name,product_category ,product_entry_price,"
                + " product_retail_price FROM product where product_ID in (" + str_1 + ")";
        try {
            Statement st_3 = BaseApp.connectDB().createStatement();
            ResultSet rs_3 = st_3.executeQuery(get_product);
            int i = 0;
            while (rs_3.next()) {

                productProperties product = new productProperties();
                product.setProduct_code(rs_3.getInt("product_ID"));
                product.setName(rs_3.getString("product_name"));
                product.setCategory(rs_3.getString("product_category"));
                product.setProduct_number(rs_3.getInt("product_entry_price"));
                product.setRetail_price(rs_3.getInt("product_retail_price"));
                total_Product += data[i];
                list.add(product);
                total_Money_in += rs_3.getInt("product_retail_price") * data[i];
                total_Money_out += rs_3.getInt("product_entry_price") * data[i];
                i++;
            }
            total_Profit = total_Money_in - total_Money_out;
            product_label.setText(Integer.toString(total_Product) + " Sản Phẩm");
            money_label.setText(BaseApp.formatMoney(total_Money_in) + " VNĐ");
            profit_label.setText(BaseApp.formatMoney(total_Profit) + " VNĐ");
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < list.size(); i++) {
            String[] data_table = new String[5];
            data_table[0] = Integer.toString(list.get(i).getProduct_code());
            data_table[1] = list.get(i).getName();
            data_table[2] = list.get(i).getCategory();
            data_table[3] = Integer.toString(data[i]);
            tableModel.addRow(data_table);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    public String getDate(String query) {
        String date = "";
        try {
            Statement stm = BaseApp.connectDB().createStatement();
            ResultSet result = stm.executeQuery(query);
            result.first();
            date = result.getString("order_create_at");
            return date;

        } catch (Exception e) {
        }
        return date;
    }

}
