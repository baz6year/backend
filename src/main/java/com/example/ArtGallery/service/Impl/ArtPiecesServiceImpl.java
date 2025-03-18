package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.dto.ArtPiecesResponse;
import com.example.ArtGallery.mapper.ArtPiecesMapper;
import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.repository.ArtPiecesRepository;
import com.example.ArtGallery.service.ArtPiecesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtPiecesServiceImpl implements ArtPiecesService {
    private final ArtPiecesRepository artPiecesRepository;
    private final ArtPiecesMapper artPiecesMapper;

    @Override
    public ArtPieces createArtPiece(ArtPiecesRequest request) {
        return artPiecesRepository.save(artPiecesMapper.toArtPiece(request));
    }

    @Override
    public ArtPieces getArtPiece(Long id) {
        return artPiecesRepository.findById(id).orElse(null);
    }

    @Override
    public ArtPieces updateArtPiece(Long id, ArtPiecesRequest request) {
        ArtPieces artPieces = artPiecesRepository.findById(id).orElse(null);
        artPieces.setTitle(request.getTitle());
        artPieces.setArtistName(request.getArtistName());
        artPieces.setType(request.getType());
        artPieces.setYear(request.getYear());
        return artPiecesRepository.save(artPieces);
    }

    @Override
    public void deleteArtPiece(Long id) {
        artPiecesRepository.deleteArtPiecesById(id);
    }

    public List<ArtPiecesResponse> getArtPiecesByArtist(Long artistId) {
        List<ArtPieces> artPieces = artPiecesRepository.findByArtistId(artistId);
        return artPieces.stream()
                .map(artPiecesMapper::toArtPiecesResponse) // Convert each entity to DTO
                .collect(Collectors.toList());
    }


}
