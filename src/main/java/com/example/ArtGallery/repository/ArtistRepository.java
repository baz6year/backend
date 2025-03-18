package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(String name);
    void deleteByName(String name);

}
