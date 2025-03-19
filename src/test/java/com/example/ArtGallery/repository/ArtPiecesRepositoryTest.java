package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.model.Artist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ArtPiecesRepositoryTest {

    @Autowired
    private ArtPiecesRepository artPiecesRepository;

    @Autowired
    private ArtistRepository artistRepository;

    private Artist artist;
    private ArtPieces artPiece;

    @BeforeEach
    void setUp() {
        artist = new Artist();
        artist.setName("Leonardo da Vinci");
        artistRepository.save(artist);

        artPiece = new ArtPieces();
        artPiece.setTitle("Mona Lisa");
        artPiece.setArtist(artist);
        artPiecesRepository.save(artPiece);
    }

    @Test
    void testDeleteArtPiecesById() {
        artPiecesRepository.deleteArtPiecesById(artPiece.getId());

        Optional<ArtPieces> deletedArtPiece = artPiecesRepository.findById(artPiece.getId());
        assertFalse(deletedArtPiece.isPresent());
    }
}
