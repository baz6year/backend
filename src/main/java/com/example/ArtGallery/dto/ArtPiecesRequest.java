package com.example.ArtGallery.dto;

import lombok.Data;

@Data
public class ArtPiecesRequest {
    private String title;
    private String artistName;
    private String type;
    private int year;
}
