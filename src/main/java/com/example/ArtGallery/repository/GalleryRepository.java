package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
    Optional<Gallery> findByName(String datum);
}
