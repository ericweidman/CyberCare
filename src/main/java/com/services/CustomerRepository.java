package com.services;

import com.entities.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ericweidman on 3/14/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
