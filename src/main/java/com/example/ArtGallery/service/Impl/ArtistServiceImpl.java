package com.example.ArtGallery.service.Impl;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.mapper.ArtistMapper;
import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.model.Artist;
import com.example.ArtGallery.repository.ArtistRepository;
import com.example.ArtGallery.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;
    @Override
    public Artist addArtist(ArtistRequest artistRequest) {
        return artistRepository.save(artistMapper.toArtist(artistRequest));
    }

    @Override
    public Artist getArtist(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public Artist updateArtist(ArtistRequest artistRequest, Long id) {
        Artist artist = artistRepository.findById(id).orElse(null);
        artist.setName(artistRequest.getName());
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Long id) {

    }


}
