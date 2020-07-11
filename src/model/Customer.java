
package model;

import java.sql.Date;

public class Customer {
    private String customer_name;
    private String customer_sex;
    private String customer_birth;
    private String customer_phone_number;
    private String customer_address;
    private Date customer_create_at;

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_sex() {
        return customer_sex;
    }

    public String getCustomer_birth() {
        return customer_birth;
    }

    public String getCustomer_phone_number() {
        return customer_phone_number;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public Date getCustomer_create_at() {
        return customer_create_at;
    }


    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }

    public void setCustomer_birth(String customer_birth) {
        this.customer_birth = customer_birth;
    }

    public void setCustomer_phone_number(String customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public void setCustomer_create_at(Date customer_create_at) {
        this.customer_create_at = customer_create_at;
    }
    
}
