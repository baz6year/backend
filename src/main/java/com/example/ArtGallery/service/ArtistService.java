package com.example.ArtGallery.service;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.model.Artist;

import java.util.List;

public interface ArtistService {
    Artist addArtist(ArtistRequest artistRequest);
    Artist getArtist(int id);
    Artist updateArtist(ArtistRequest artistRequest);
    void deleteArtist(int id);

}
