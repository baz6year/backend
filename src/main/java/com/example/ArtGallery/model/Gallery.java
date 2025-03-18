package com.example.ArtGallery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "gallery_tb")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String address;

    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL)
    private List<ArtPieces> artworks;
}


