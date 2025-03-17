package com.example.ArtGallery.dto;

import lombok.Data;

@Data
public class ArtPiecesResponse {
    private Long id;
    private String title;
    private String artist;
    private String type;
    private int year;
}
