package com.example.ArtGallery.controller;

import com.example.ArtGallery.dto.ArtPiecesRequest;
import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.service.ArtPiecesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ArtPiecesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ArtPiecesService artPiecesService;

    @InjectMocks
    private ArtPiecesController artPiecesController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(artPiecesController).build();
    }

    @Test
    void testAddArtPieces() throws Exception {
        ArtPiecesRequest request = new ArtPiecesRequest();
        request.setName("Mona Lisa");
        request.setArtist("Leonardo da Vinci");

        ArtPieces artPiece = new ArtPieces();
        artPiece.setId(1L);
        artPiece.setName("Mona Lisa");
        artPiece.setArtist("Leonardo da Vinci");

        when(artPiecesService.createArtPiece(request)).thenReturn(artPiece);

        mockMvc.perform(post("/art-pieces/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Mona Lisa\", \"artist\": \"Leonardo da Vinci\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Mona Lisa"))
                .andExpect(jsonPath("$.artist").value("Leonardo da Vinci"));
    }

    @Test
    void testGetArtPieces() throws Exception {
        ArtPieces artPiece = new ArtPieces();
        artPiece.setId(1L);
        artPiece.setName("Mona Lisa");
        artPiece.setArtist("Leonardo da Vinci");

        when(artPiecesService.getArtPiece(1L)).thenReturn(artPiece);

        mockMvc.perform(get("/art-pieces/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Mona Lisa"))
                .andExpect(jsonPath("$.artist").value("Leonardo da Vinci"));
    }

    @Test
    void testUpdateArtPieces() throws Exception {
        ArtPiecesRequest request = new ArtPiecesRequest();
        request.setName("Mona Lisa Updated");
        request.setArtist("Leonardo da Vinci");

        ArtPieces updatedArtPiece = new ArtPieces();
        updatedArtPiece.setId(1L);
        updatedArtPiece.setName("Mona Lisa Updated");
        updatedArtPiece.setArtist("Leonardo da Vinci");

        when(artPiecesService.updateArtPiece(1L, request)).thenReturn(updatedArtPiece);

        mockMvc.perform(put("/art-pieces/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Mona Lisa Updated\", \"artist\": \"Leonardo da Vinci\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Mona Lisa Updated"))
                .andExpect(jsonPath("$.artist").value("Leonardo da Vinci"));
    }

    @Test
    void testDeleteArtPieces() throws Exception {
        doNothing().when(artPiecesService).deleteArtPiece(1L);

        mockMvc.perform(delete("/art-pieces/delete/1"))
                .andExpect(status().isNoContent());

        verify(artPiecesService, times(1)).deleteArtPiece(1L);
    }
}
