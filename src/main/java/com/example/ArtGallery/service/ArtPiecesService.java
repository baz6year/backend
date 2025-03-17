package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.model.ArtPieces;

public interface ArtPiecesService {
    ArtPieces createArtPiece(ArtPiecesRequest request);
    ArtPieces getArtPiece(Long id);
    ArtPieces updateArtPiece(Long id, ArtPiecesRequest request);
    void deleteArtPiece(Long id);
}
