package com.example.ArtGallery;

import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.model.Artist;
import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.repository.ArtistRepository;
import com.example.ArtGallery.repository.GalleryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader {
    private final ArtistRepository artistRepository;
    private final GalleryRepository galleryRepository;

    @PostConstruct
    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            br.lines().skip(1).forEach(line -> {
                String[] data = line.split(",");
                Artist artist = artistRepository.findByName(data[0]).orElse(new Artist(data[0]));
                Gallery gallery = galleryRepository.findByName(data[2]).orElse(new Gallery(data[2]));

                ArtPieces artPieces = new ArtPieces(data[1], artist, gallery);
                artist.getArtPieces().add(artPieces);
                gallery.getArtPieces().add(artPieces);

                artistRepository.save(artist);
                galleryRepository.save(gallery);
            });
        } catch (IOException e) {
            log.error("Ошибка загрузки CSV: {}", e.getMessage());
        }
    }
}

