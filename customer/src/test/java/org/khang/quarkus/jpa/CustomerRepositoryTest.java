package org.khang.quarkus.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CustomerRepositoryTest {
  @Inject
  CustomerRepository repository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindACustomer() {
    Customer customer = new Customer("first name", "last name", "email");

    repository.persist(customer);
    assertNotNull(customer.getId());

    customer = repository.findById(customer.getId());
    assertEquals("last name", customer.getLastName());
  } 
}
