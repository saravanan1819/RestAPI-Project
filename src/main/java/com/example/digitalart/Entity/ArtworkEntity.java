package com.example.digitalart.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "artwork")
public class ArtworkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String price;
    
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private ArtistEntity artist;
    
    @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuctionEntity> auctions;
    
    public ArtworkEntity() {
    }
    
    public ArtworkEntity(int id, String title, String description, String price, ArtistEntity artist, List<AuctionEntity> auctions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.artist = artist;
        this.auctions = auctions;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public ArtistEntity getArtist() {
        return artist;
    }
    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
    public List<AuctionEntity> getAuctions() {
        return auctions;
    }
    public void setAuctions(List<AuctionEntity> auctions) {
        this.auctions = auctions;
    }
}