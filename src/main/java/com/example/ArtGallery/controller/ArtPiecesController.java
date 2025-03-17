package com.example.ArtGallery.controller;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.service.ArtPiecesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/art-pieces")
public class ArtPiecesController {
    private ArtPiecesService artPiecesService;

    @PostMapping("/create")
    public ArtPieces addArtPieces(@RequestBody ArtPiecesRequest request) {
        return artPiecesService.createArtPiece(request);
    }

    @GetMapping("/get/{id}")
    public ArtPieces getArtPieces(@PathVariable Long id) {
        return artPiecesService.getArtPiece(id);
    }

    @PutMapping("/update/{id}")
    public ArtPieces updateArtPieces(@PathVariable Long id, @RequestBody ArtPiecesRequest request) {
        return artPiecesService.updateArtPiece(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtPieces(@PathVariable Long id) {
        artPiecesService.deleteArtPiece(id);
    }
}
