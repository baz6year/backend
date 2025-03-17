package com.example.ArtGallery.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL)
    private List<ArtPieces> artworks;
}


