package com.example.ArtGallery.dto;

import lombok.Data;

@Data
public class ArtPiecesRequest {
    private String title;
    private String artist;
    private String type;
    private int year;
}
