package com.controllers;


import com.entities.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.CustomerRepository;
import org.h2.tools.Server;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.List;

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
    public String addCustomer(@RequestBody String customer) {

        JSONObject newCustomer = new JSONObject(customer);
        int id = newCustomer.getInt("id");
        String customerName = newCustomer.getString("name");
        String customerEmail = newCustomer.getString("email");
        String customerPhone = newCustomer.getString("phone");
        String customerStreet = newCustomer.getString("street");
        String customerCity = newCustomer.getString("city");
        String customerState = newCustomer.getString("state");
        String customerZip = newCustomer.getString("zip");
        Customer newCustomerObject = new Customer(id, customerName, customerEmail, customerPhone, customerStreet, customerCity, customerState, customerZip);
        customers.save(newCustomerObject);

        return customer;

    }

    @RequestMapping(path = "/get-customers", method = RequestMethod.GET)
    public String customerList() throws JsonProcessingException {

        List<Customer> customerList = (List<Customer>) customers.findAll();
        com.fasterxml.jackson.databind.ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(customerList);
        System.out.println(json);

        return json;
    }

    @RequestMapping(path = "/update-customer", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody String customer) {

        JSONObject newCustomer = new JSONObject(customer);
        int id = newCustomer.getInt("updateNumber");
        String customerName = newCustomer.getString("updatedName");
        String customerEmail = newCustomer.getString("updatedEmail");
        String customerPhone = newCustomer.getString("updatedPhone");
        String customerStreet = newCustomer.getString("updatedStreet");
        String customerCity = newCustomer.getString("updatedCity");
        String customerState = newCustomer.getString("updatedState");
        String customerZip = newCustomer.getString("updatedZip");

        Customer oldCustomer = customers.findOne(id);
        oldCustomer.setId(id);
        oldCustomer.setName(customerName);
        oldCustomer.setEmail(customerEmail);
        oldCustomer.setPhone(customerPhone);
        oldCustomer.setPhone(customerStreet);
        oldCustomer.setCity(customerCity);
        oldCustomer.setState(customerState);
        oldCustomer.setZip(customerZip);

        customers.save(oldCustomer);

    }

    @RequestMapping(path = "/delete-customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") int id) {

        customers.delete(id);
    }

}


