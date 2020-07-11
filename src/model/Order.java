/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Order {
    private int order_ID;
    private String customer_phone_number;
    private int employee_ID;
    private Date order_create_at;

    public Order(){
        
    }
    
    public Order(int order_ID, String customer_phone_number, int employee_ID, Date order_create_at) {
        this.order_ID = order_ID;
        this.customer_phone_number = customer_phone_number;
        this.employee_ID = employee_ID;
        this.order_create_at = order_create_at;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public String getCustomer_phone_number() {
        return customer_phone_number;
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public Date getOrder_create_at() {
        return order_create_at;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public void setCustomer_phone_number(String customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public void setOrder_create_at(Date order_create_at) {
        this.order_create_at = order_create_at;
    }
    
    
}
