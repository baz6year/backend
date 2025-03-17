package com.example.ArtGallery.mapper;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.dto.ArtistResponse;
import com.example.ArtGallery.model.Artist;

public interface ArtistMapper {
    Artist toArtist(ArtistRequest artistRequest);
    ArtistResponse toArtistResponse(Artist artist);
}
