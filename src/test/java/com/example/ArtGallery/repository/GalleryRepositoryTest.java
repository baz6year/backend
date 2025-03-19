package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class GalleryRepositoryTest {

    @Autowired
    private GalleryRepository galleryRepository;

    private Gallery gallery;

    @BeforeEach
    void setUp() {
        gallery = new Gallery();
        gallery.setName("Modern Art Gallery");
        galleryRepository.save(gallery);
    }

    @Test
    void testFindByName() {
        Optional<Gallery> foundGallery = galleryRepository.findByName("Modern Art Gallery");
        assertTrue(foundGallery.isPresent());
        assertEquals("Modern Art Gallery", foundGallery.get().getName());
    }

    @Test
    void testFindByNameNotFound() {
        Optional<Gallery> foundGallery = galleryRepository.findByName("Non Existent Gallery");
        assertFalse(foundGallery.isPresent());
    }
}
