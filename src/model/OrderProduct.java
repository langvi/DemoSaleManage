/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class OrderProduct {
    private int order_ID;
    private int product_ID;
    private int total_product;

    public OrderProduct(int order_ID, int product_ID, int total_product) {
        this.order_ID = order_ID;
        this.product_ID = product_ID;
        this.total_product = total_product;
    }
    public OrderProduct(){
        
    }
    public int getOrder_ID() {
        return order_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public int getTotal_product() {
        return total_product;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public void setTotal_product(int total_product) {
        this.total_product = total_product;
    }
    
    
}
