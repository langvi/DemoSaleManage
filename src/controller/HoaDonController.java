package controller;

import base.BaseApp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.OrderProduct;
import model.Product;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HoaDonController {

    public String fetchData(String query) {
        String data = "";
        try {
            Statement stm = BaseApp.connectDB().createStatement();
            ResultSet result = stm.executeQuery(query);
            result.first();
            data = result.getString(1);
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public Employee fetchDataEmployee(String query) {
        Employee employee = new Employee();
        try {
            Statement stm = BaseApp.connectDB().createStatement();
            ResultSet result = stm.executeQuery(query);
            result.first();
            employee.setId(result.getInt("employee_ID"));
            employee.setName(result.getString("employee_name"));
            return employee;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    public String get_product_name(int product_ID) {
        String product_nameString = "";
        try {
            PreparedStatement pstm = BaseApp.connectDB().prepareStatement("Select * from product where product_ID=?");
            pstm.setInt(1, product_ID);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            product_nameString = rs.getString("product_name");
            rs.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_nameString;
    }

    public float get_product_retail_price(int product_ID) {
        float product_product_retail_price = 0;
        try {
            PreparedStatement pstm = BaseApp.connectDB().prepareStatement("Select * from product where product_ID=?");
            pstm.setInt(1, product_ID);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            product_product_retail_price = rs.getFloat("product_retail_price");
            rs.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_product_retail_price;
    }

    public void store_order(int order_ID, String customer_phone_number, int employee_ID, ArrayList<Product> product_list, ArrayList<OrderProduct> order_product_list) {
        try {
            PreparedStatement pstm = BaseApp.connectDB().prepareStatement("Insert into orders (order_ID, customer_phone_number, employee_ID, order_create_at) values (?, ?, ?, ?)");
            pstm.setInt(1, order_ID);
            pstm.setString(2, customer_phone_number);
            pstm.setInt(3, employee_ID);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateString = formatter.format(date);
            pstm.setString(4, dateString);
            pstm.execute();

            for (OrderProduct od_p : order_product_list) {
                pstm = BaseApp.connectDB().prepareStatement("insert into order_product (order_ID, product_ID, total_product) values (?, ?, ?)");
                pstm.setInt(1, order_ID);
                pstm.setInt(2, od_p.getProduct_ID());
                pstm.setInt(3, od_p.getTotal_product());
                pstm.execute();
            }

            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int get_last_order_ID() {
        int last_order_ID = 0;
        try {
            Statement stm = BaseApp.connectDB().createStatement();
            ResultSet rs = stm.executeQuery("Select order_ID from orders where order_ID=(select max(order_id) from orders)");
            rs.next();
            last_order_ID = rs.getInt("order_ID");
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_order_ID;
    }
}
