/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import base.BaseApp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.EmployeeClass;

/**
 *
 * @author nguyenthithuylinh
 */
public class EmployeeController {

    //connect to database
    Connection conn = BaseApp.connectDB();

    // Lấy dữ liệu từ database nhân viên
    public void callData(String query, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<EmployeeClass> list = new ArrayList<EmployeeClass>();
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                EmployeeClass employee = new EmployeeClass();
                employee.setId(result.getInt("employee_ID"));
                employee.setName(result.getString("employee_name"));
                employee.setBirthday(result.getDate("employee_birth"));
                employee.setPhoneNumber(result.getString("employee_phone_number"));
                employee.setAddress(result.getString("employee_address"));
                employee.setWorkTime(result.getString("employee_work_time"));
                employee.setNumberWorkDay(result.getInt("employee_work_day"));
                employee.setSalary(result.getFloat("employee_salary"));
                employee.computeSalary(result.getInt("employee_work_day"),
                        result.getFloat("employee_salary"));
                list.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[9];

            data[0] = Integer.toString(list.get(i).getId());
            data[1] = list.get(i).getName();
            Date date = list.get(i).getBirthday();
            data[2] = convertDateToString(date, "dd/MM/yyyy");
            data[3] = list.get(i).getPhoneNumber();
            data[4] = list.get(i).getAddress();
            data[5] = list.get(i).getWorkTime();
            float basicSalary = list.get(i).getBasicSalary();
            data[6] = Float.toString(basicSalary);
            int numberDay = list.get(i).getNumberWorkDay();
            data[7] = Integer.toString(numberDay);
            float Salary = list.get(i).computeSalary(numberDay, basicSalary);
            data[8] = Float.toString(Salary);
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    public static String convertDateToString(Date date, String format) {
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
        return mySimpleDateFormat.format(date);
    }

    public static Date convertStringToDate(String dateStr, String format) {
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
        try {
            return (Date) mySimpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    // Thêm dữ liệu nhân viên vào database
    public void AddEmployee(String query, EmployeeClass employee) {
        // query: insert into sales_database.employee(employee_ID, user_ID,
        // employee_employee_name, employee_birth, employee_employee_phone_number, employee_employee_address,
        // employee_employee_salary, employee_work_time, employee_work_day
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getName());
            Date date = employee.getBirthday();
            String dateStr = convertDateToString(date, "dd/MM/yyyy");
            pst.setString(3, dateStr);
            pst.setString(4, employee.getPhoneNumber());
            pst.setString(5, employee.getAddress());
            pst.setFloat(6, employee.getBasicSalary());
            pst.setString(7, employee.getWorkTime());
            pst.setInt(8, employee.getNumberWorkDay());
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
