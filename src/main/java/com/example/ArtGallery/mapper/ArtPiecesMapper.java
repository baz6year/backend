package com.example.ArtGallery.mapper;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.dto.ArtPiecesResponse;
import com.example.ArtGallery.model.ArtPieces;

public interface ArtPiecesMapper {
    ArtPieces toArtPiece(ArtPiecesRequest request);
    ArtPiecesResponse toResponse(ArtPieces artPieces);
}
