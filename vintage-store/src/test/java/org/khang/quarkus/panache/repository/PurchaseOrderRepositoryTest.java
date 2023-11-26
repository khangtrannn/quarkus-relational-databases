package org.khang.quarkus.panache.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.khang.quarkus.jdbc.Artist;
import org.khang.quarkus.jpa.Customer;
import org.khang.quarkus.panache.model.Book;
import org.khang.quarkus.panache.model.Language;
import org.khang.quarkus.panache.model.OrderLine;
import org.khang.quarkus.panache.model.Publisher;
import org.khang.quarkus.panache.model.PurchaseOrder;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class PurchaseOrderRepositoryTest {
  @Inject
  CustomerRepository customerRepository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindAPurchaseOrder() {
    // Creates an Artist
    Artist artist = new Artist();
    artist.setName("name");
    artist.setBio("bio");

    // Creates a Publisher
    Publisher publisher = new Publisher();
    publisher.name = "name";

    // Creates a Book
    Book book = new Book();
    book.title = "title";
    book.description = "description";
    book.price = new BigDecimal(10);
    book.isbn = "ISBN";
    book.nbOfPages = 500;
    book.publicationDate = LocalDate.now().minusDays(100);
    book.language = Language.ENGLISH;

    // Sets the Publisher and Artist to the Book
    book.publisher = publisher;
    book.artist = artist;

    // Persists the Book with one Publisher and one Artist
    Book.persist(book);

    // Creates a Customer
    Customer customer = new Customer();
    customer.setFirstName("first name");
    customer.setLastName("last name");
    customer.setEmail("email");
    customerRepository.persist(customer);

    // Create an Order Line
    OrderLine orderLine = new OrderLine();
    orderLine.item = book;
    orderLine.quantity = 2;

    // Create a Purchase Order
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.customer = customer;
    purchaseOrder.addOrderLine(orderLine);

    PurchaseOrder.persist(purchaseOrder);
  }
}
