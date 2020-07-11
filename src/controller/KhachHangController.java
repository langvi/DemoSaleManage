package controller;

import base.BaseApp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Customer;

public class KhachHangController {

    public void fetchDataCustomer(JTable table, String query) {

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {
            Statement st = BaseApp.connectDB().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_phone_number(rs.getString("customer_phone_number"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setCustomer_address(rs.getString("customer_address"));
                customer.setCustomer_birth(rs.getString("customer_birth"));
                customer.setCustomer_sex(rs.getString("customer_sex"));
                list.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[5];
            data[0] = list.get(i).getCustomer_name();
            data[1] = list.get(i).getCustomer_birth();
            data[2] = list.get(i).getCustomer_phone_number();
            data[3] = list.get(i).getCustomer_address();
            data[4] = list.get(i).getCustomer_sex();
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();

    }

    public void searchCustomer(String phoneNumber, Customer customer) {
        String sql1 = "SELECT customer_name,customer_birth,customer_phone_number,customer_address,"
                + "customer_sex FROM customer where customer_phone_number='" + phoneNumber + "'";
        try {

            Statement st = BaseApp.connectDB().createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if (rs.first())//nếu có dữ liệu
            {
                customer.setCustomer_phone_number(rs.getString("customer_phone_number"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setCustomer_address(rs.getString("customer_address"));
                customer.setCustomer_birth(rs.getString("customer_birth"));
                customer.setCustomer_sex(rs.getString("customer_sex"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UpdateKH(Customer customer, String phoneNumber) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = formatter.format(date);
        String sql = "UPDATE `customer` SET `customer_phone_number`=?,`customer_name`=?,`customer_sex`=?,"
                + "`customer_birth`=?,`customer_address`=?,`customer_create_at`=? WHERE `customer_phone_number` =" + phoneNumber;
        try {
            PreparedStatement pst = BaseApp.connectDB().prepareStatement(sql);
            pst.setString(1, customer.getCustomer_phone_number());
            pst.setString(2, customer.getCustomer_name());
            pst.setString(3, customer.getCustomer_sex());
            pst.setString(4, customer.getCustomer_birth());
            pst.setString(5, customer.getCustomer_address());
            pst.setString(6, dateString);
            pst.execute();
            JOptionPane.showMessageDialog(null, " Đã sửa thành thành công", "Thông báo", 1);
        } catch (SQLException e) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void AddDatabase(String query, Customer customer) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = formatter.format(date);
        try {
            PreparedStatement pst = BaseApp.connectDB().prepareStatement(query);
            pst.setString(1, customer.getCustomer_phone_number());
            pst.setString(2, customer.getCustomer_name());
            pst.setString(3, customer.getCustomer_sex());
            pst.setString(4, customer.getCustomer_birth());
            pst.setString(5, customer.getCustomer_address());
            pst.setString(6, dateString);
            pst.execute();
            JOptionPane.showMessageDialog(null, " Đã thêm thành công", "Thông báo", 1);

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " Đã tồn tại", "Thông báo", 1);

        }

    }

    public int getTotalCustomer(String query) {
        int total = 0;
        try {
            Statement st = BaseApp.connectDB().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.first();
            total = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
