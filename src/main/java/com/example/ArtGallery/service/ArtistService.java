package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.model.Artist;

import java.util.List;

public interface ArtistService {
    Artist addArtist(ArtistRequest artistRequest);
    Artist getArtist(Long id);
    Artist updateArtist(ArtistRequest artistRequest, Long id);
    void deleteArtist(Long id);

}
