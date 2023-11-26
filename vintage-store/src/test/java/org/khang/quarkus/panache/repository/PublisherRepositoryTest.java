package org.khang.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.khang.quarkus.panache.model.Publisher;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PublisherRepositoryTest {
  @Test
  @TestTransaction
  public void shouldCreateAndFindAPublisher() {
    long count = Publisher.count();
    int listAll = Publisher.listAll().size();
    assertEquals(count, listAll);

    Publisher publisher = new Publisher("name");

    Publisher.persist(publisher);
    assertNotNull(publisher.id);

    assertEquals(count + 1, Publisher.count());

    publisher = Publisher.findById(publisher.id);
    assertEquals("name", publisher.name);

    Publisher.deleteById(publisher.id);
    assertEquals(count, Publisher.count());
  }
}
