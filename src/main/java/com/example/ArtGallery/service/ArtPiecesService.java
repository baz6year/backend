package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.dto.ArtPiecesResponse;
import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.model.Artist;

import java.util.List;

public interface ArtPiecesService {
    ArtPieces createArtPiece(ArtPiecesRequest request);
    ArtPieces getArtPiece(Long id);
    ArtPieces updateArtPiece(Long id, ArtPiecesRequest request);
    void deleteArtPiece(Long id);
    List<ArtPiecesResponse> getArtPiecesByArtist(Long artistId);
}
