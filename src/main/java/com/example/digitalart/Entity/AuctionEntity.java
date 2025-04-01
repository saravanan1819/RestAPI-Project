package com.example.digitalart.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auction")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String startDate;
    private String endDate;
    private String startingPrice;
    
    @ManyToOne
    @JoinColumn(name = "artwork_id", nullable = false)
    private ArtworkEntity artwork;
    
    public AuctionEntity() {
    }
    
    public AuctionEntity(int id, String title, String startDate, String endDate, String startingPrice, ArtworkEntity artwork) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startingPrice = startingPrice;
        this.artwork = artwork;
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
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getStartingPrice() {
        return startingPrice;
    }
    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }
    public ArtworkEntity getArtwork() {
        return artwork;
    }
    public void setArtwork(ArtworkEntity artwork) {
        this.artwork = artwork;
    }
}