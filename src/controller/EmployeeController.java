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
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.Employee;

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
        ArrayList<Employee> list = new ArrayList<Employee>();
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                Employee employee = new Employee();
                employee.setId(result.getInt("employee_ID"));
                employee.setName(result.getString("employee_name"));
                employee.setBirthday(result.getString("employee_birth"));
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
            data[2] = list.get(i).getBirthday();
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
    
    public int getLastUserID(){
        int last_user_ID = 0;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select user_ID from employee where user_ID=(select max(user_ID) from employee)");
            rs.next(); 
            last_user_ID = rs.getInt("user_ID") + 1;
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_user_ID;
    }
    
    public int getLastEmpID(){
        int last_emp_ID = 0;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select employee_ID from employee where employee_ID=(select max(employee_ID) from employee)");
            rs.next(); 
            last_emp_ID = rs.getInt("employee_ID") + 1;
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_emp_ID;
    }
    
    public int getUserID(int employee_ID){
        int user_ID = 0;
        try{
            String sql = "Select user_ID from employee where employee_ID = ?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, employee_ID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                user_ID = rs.getInt("user_ID");
            }
            rs.close();
            pst.close();
        }catch(SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_ID;
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
    public int AddEmployee(String query, Employee employee) {
        // query: insert into sales_database.employee(employee_ID, user_ID,
        // employee_employee_name, employee_birth, employee_employee_phone_number, employee_employee_address,
        // employee_employee_salary, employee_work_time, employee_work_day
        int chk = 0;
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getName());
            String strdate = employee.getBirthday();
            Date date1 = convertStringToDate(strdate, "dd/MM/yyyy");
            pst.setDate(3, date1);
            pst.setString(4, employee.getPhoneNumber());
            pst.setString(5, employee.getAddress());
            pst.setFloat(6, employee.getBasicSalary());
            pst.setString(7, employee.getWorkTime());
            pst.setInt(8, employee.getNumberWorkDay());
            chk = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    
    public void callSearchData(String query, JTable table, String name, String phone) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<Employee> list = new ArrayList<Employee>();

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            if(phone.trim().isEmpty()){
                pst.setString(1, name);
            }
            else if (name.trim().isEmpty()){
                pst.setString(1, phone);
            }
            else{
                pst.setString(1, name);
                pst.setString(2, phone);
            }

            ResultSet result = pst.executeQuery();
            while (result.next()) {
                if(result.getBoolean("employee_state") == true){
                    Employee employee = new Employee();
                    employee.setId(result.getInt("employee_ID"));
                    employee.setName(result.getString("employee_name"));
                    employee.setBirthday(result.getString("employee_birth"));
                    employee.setPhoneNumber(result.getString("employee_phone_number"));
                    employee.setAddress(result.getString("employee_address"));
                    employee.setWorkTime(result.getString("employee_work_time"));
                    employee.setNumberWorkDay(result.getInt("employee_work_day"));
                    employee.setBasicSalary(result.getFloat("employee_salary"));
                    employee.computeSalary(result.getInt("employee_work_day"),
                            result.getFloat("employee_salary"));
                    list.add(employee);
                }
            }
            ResultSetMetaData metadata = result.getMetaData();
            int number = metadata.getColumnCount();     // tra ve so cot
            if(number == 0) {
                JOptionPane.showMessageDialog(null, "không tồn tại nhân viên này");
            }
        }catch(SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < list.size(); i++) {
            String[] data = new String[9];
            
            data[0] = Integer.toString(list.get(i).getId());
            data[1] = list.get(i).getName();
            data[2] = list.get(i).getBirthday();
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
    
    public void DeleteEmployee(int EmpID){
        String query = "update employee set employee_state = 0 where employee_ID = ?";
        try{
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, EmpID);
            pst.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
