package org.khang.quarkus.panache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PublisherRepositoryTest {
  @Test
  @TestTransaction
  public void shouldCreateAndFindAPublisher() {
    Publisher publisher = new Publisher("name");

    Publisher.persist(publisher);
    assertNotNull(publisher.id);

    publisher = Publisher.findById(publisher.id);
    assertEquals("name", publisher.name);
  }
}
