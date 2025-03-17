package com.example.ArtGallery.mapper.Impl;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.dto.ArtPiecesResponse;
import com.example.ArtGallery.mapper.ArtPiecesMapper;
import com.example.ArtGallery.model.ArtPieces;
import org.springframework.stereotype.Component;

@Component
public class ArtPiecesMapperImpl implements ArtPiecesMapper {
    @Override
    public ArtPieces toArtPiece(ArtPiecesRequest request) {
        ArtPieces artPieces = new ArtPieces();
        artPieces.setTitle(request.getTitle());
        artPieces.setArtist(request.getArtist());
        artPieces.setYear(request.getYear());
        artPieces.setType(request.getType());
        return artPieces;
    }

    @Override
    public ArtPiecesResponse toResponse(ArtPieces artPieces) {
        ArtPiecesResponse artPiecesResponse = new ArtPiecesResponse();
        artPiecesResponse.setId(artPieces.getId());
        artPiecesResponse.setTitle(artPieces.getTitle());
        artPiecesResponse.setArtist(artPieces.getArtist());
        artPiecesResponse.setYear(artPieces.getYear());
        artPiecesResponse.setType(artPieces.getType());
        return artPiecesResponse;
    }
}
