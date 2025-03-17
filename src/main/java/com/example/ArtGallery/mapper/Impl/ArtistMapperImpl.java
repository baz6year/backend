package com.example.ArtGallery.mapper.Impl;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.dto.ArtistResponse;
import com.example.ArtGallery.mapper.ArtistMapper;
import com.example.ArtGallery.model.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapperImpl implements ArtistMapper {
    @Override
    public Artist toArtist(ArtistRequest artistRequest) {
        Artist artist = new Artist();
        artist.setName(artistRequest.getName());
        return artist;
    }

    @Override
    public ArtistResponse toArtistResponse(Artist artist) {
        ArtistResponse artistResponse = new ArtistResponse();
        artistResponse.setId(artist.getId());
        artistResponse.setName(artist.getName());
        return artistResponse;
    }
}
