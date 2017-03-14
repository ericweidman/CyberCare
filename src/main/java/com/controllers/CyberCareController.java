package com.controllers;

import com.services.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ericweidman on 3/14/17.
 */

@RestController
public class CyberCareController {

    @Autowired
    CustomerRepository customers;



}
