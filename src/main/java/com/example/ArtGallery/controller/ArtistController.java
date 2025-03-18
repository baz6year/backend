package com.example.ArtGallery.controller;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.model.Artist;
import com.example.ArtGallery.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/artist")
public class ArtistController {
    private ArtistService artistService;

    @PostMapping("/add")
     public Artist addArtist(ArtistRequest artistRequest){
        return artistService.addArtist(artistRequest);
    }
    @GetMapping("/get/{it}")
    public Artist getArtist(Long id){
        return artistService.getArtist(id);
    }
    @PutMapping("/update/{id}")
    public Artist updateArtist(ArtistRequest artistRequest, @PathVariable Long id){
        return artistService.updateArtist(artistRequest, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteArtist(@PathVariable Long id){
        artistService.deleteArtist(id);
    }

}
