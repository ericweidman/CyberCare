package com.controllers;


import com.entities.Customer;
import com.services.CustomerRepository;
import org.h2.tools.Server;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

/**
 * Created by ericweidman on 3/14/17.
 */

@RestController
public class CyberCareController {

    @Autowired
    CustomerRepository customers;

    Server dbui = null;

    @PostConstruct
    public void init() throws SQLException {
        dbui = Server.createWebServer().start();
    }

    @PreDestroy
    public void destroy() {
        dbui.stop();
    }

    @RequestMapping(path = "/create-customer", method = RequestMethod.POST, consumes = "application/json")
    public void addCustomer(@RequestBody String customer){

        JSONObject newCustomer = new JSONObject(customer);
        String customerName = newCustomer.getString("name");
        String customerEmail = newCustomer.getString("email");
        String customerPhone = newCustomer.getString("phone");
        String customerStreet = newCustomer.getString("street");
        String customerCity = newCustomer.getString("city");
        String customerState = newCustomer.getString("state");
        String customerZip = newCustomer.getString("zip");
        Customer newCustomerObject = new Customer(customerName, customerEmail, customerPhone, customerStreet, customerCity, customerState, customerZip);
        customers.save(newCustomerObject);

    }

    @RequestMapping(path = "/get-customers", method = RequestMethod.GET)
    public String customerList(){

        return "customers";
    }

    @RequestMapping(path = "/update-customer/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody String json){

        System.out.println(json);
    }

    @RequestMapping(path = "/delete-customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody int id){
        customers.delete(id);
    }



}


