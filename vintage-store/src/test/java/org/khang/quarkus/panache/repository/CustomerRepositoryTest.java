package org.khang.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.khang.quarkus.jpa.Customer;

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
    assertTrue(repository.listAllDans().size() <= repository.listAll().size());
    Customer customer = new Customer("first name", "last name", "email");

    repository.persist(customer);
    assertNotNull(customer.getId());

    customer = repository.findById(customer.getId());
    assertEquals("last name", customer.getLastName());
  } 
}
