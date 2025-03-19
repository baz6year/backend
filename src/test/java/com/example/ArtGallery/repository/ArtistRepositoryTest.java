package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.Artist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    private Artist artist;

    @BeforeEach
    void setUp() {
        artist = new Artist();
        artist.setName("Leonardo da Vinci");
        artistRepository.save(artist);
    }

    @Test
    void testFindByName() {
        Optional<Artist> foundArtist = artistRepository.findByName("Leonardo da Vinci");

        assertTrue(foundArtist.isPresent());
        assertEquals("Leonardo da Vinci", foundArtist.get().getName());
    }

    @Test
    void testDeleteByName() {
        artistRepository.deleteByName("Leonardo da Vinci");

        Optional<Artist> deletedArtist = artistRepository.findByName("Leonardo da Vinci");
        assertFalse(deletedArtist.isPresent());
    }
}
