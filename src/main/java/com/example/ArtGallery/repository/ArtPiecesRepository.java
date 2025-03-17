package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.ArtPieces;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtPiecesRepository extends JpaRepository<ArtPieces, Long> {
    @Transactional
    void deleteArtPiecesById(Long id);
}
