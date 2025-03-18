package com.example.ArtGallery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "art_pieces_tb")
public class ArtPieces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;
    private String artistName;
    private int year;
    private String type;

    @ManyToOne @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne @JoinColumn(name = "gallery_id")
    private Gallery gallery;

}






