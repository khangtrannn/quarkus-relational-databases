package org.khang.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.khang.quarkus.jdbc.Artist;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ArtistRepositoryTest {
  @Inject
  ArtistRepository artistRepository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindAnArtist() {
    long count = artistRepository.count();
    int listAll = artistRepository.listAll().size();
    assertEquals(count, listAll);

    Artist artist = new Artist("name", "bio");

    artistRepository.persist(artist);
    assertNotNull(artist.getName());

    assertEquals(count + 1, artistRepository.count());

    artist = artistRepository.findById(artist.getId());
    assertEquals("name", artist.getName());

    artistRepository.deleteById(artist.getId());
    assertEquals(count, artistRepository.count());
  }
}
