package com.example.ArtGallery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "artist_tb")
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<ArtPieces> artPieces;
}
