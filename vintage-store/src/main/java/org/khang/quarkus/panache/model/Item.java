package org.khang.quarkus.panache.model;

import java.math.BigDecimal;
import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_items")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends PanacheEntity {

  @Column(length = 100, nullable = false)
  public String title;

  @Column(length = 3000)
  public String description;

  @Column(nullable = false)
  public BigDecimal price;

  // @ManyToOne(cascade = CascadeType.PERSIST)
  // @JoinColumn(name = "artist_fk")
  // public Artist artist;

  @Column(name = "created_date", nullable = false)
  public Instant createdDate = Instant.now();
} 
