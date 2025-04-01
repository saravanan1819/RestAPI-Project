package com.example.digitalart.Entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Artist")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String bio;
    private String email;
    
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtworkEntity> Artwork;

    public ArtistEntity() {
    }
    
    public ArtistEntity(int id, String name, String bio, String email, List<ArtworkEntity> Artwork) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.email = email;
        this.Artwork = Artwork;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<ArtworkEntity> getArtworks() {
        return Artwork;
    }
    public void setArtworks(List<ArtworkEntity> Artwork) {
        this.Artwork = Artwork;
    }
}