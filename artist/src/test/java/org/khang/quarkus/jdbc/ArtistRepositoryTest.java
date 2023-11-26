package org.khang.quarkus.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ArtistRepositoryTest {
  @Inject
  ArtistRepository artistRepository;

  @Test
  public void shouldCreateAndFindAnArtist() throws SQLException {
    Artist artist = new Artist("name", "bio");

    artistRepository.persist(artist);
    assertNotNull(artist.getName());

    artist = artistRepository.findById(artist.getId());
    assertEquals("name", artist.getName());
  }
}
