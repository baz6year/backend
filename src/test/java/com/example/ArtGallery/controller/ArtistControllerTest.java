package com.example.ArtGallery.controller;

import com.example.ArtGallery.dto.ArtistRequest;
import com.example.ArtGallery.model.Artist;
import com.example.ArtGallery.service.ArtistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArtistController.class)
class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtistService artistService;

    @Autowired
    private ObjectMapper objectMapper;

    private Artist artist;
    private ArtistRequest artistRequest;

    @BeforeEach
    void setUp() {
        artist = new Artist(1L, "Leonardo da Vinci");
        artistRequest = new ArtistRequest("Leonardo da Vinci");
    }

    @Test
    void addArtist_ShouldReturnArtist() throws Exception {
        when(artistService.addArtist(any(ArtistRequest.class))).thenReturn(artist);

        mockMvc.perform(post("/artist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(artistRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Leonardo da Vinci"));
    }

    @Test
    void getArtist_ShouldReturnArtist() throws Exception {
        when(artistService.getArtist(1L)).thenReturn(artist);

        mockMvc.perform(get("/artist/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Leonardo da Vinci"));
    }

    @Test
    void updateArtist_ShouldReturnUpdatedArtist() throws Exception {
        when(artistService.updateArtist(any(ArtistRequest.class), eq(1L))).thenReturn(artist);

        mockMvc.perform(put("/artist/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(artistRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Leonardo da Vinci"));
    }

    @Test
    void deleteArtist_ShouldReturnNoContent() throws Exception {
        doNothing().when(artistService).deleteArtist(1L);

        mockMvc.perform(delete("/artist/delete/1"))
                .andExpect(status().isOk());
    }
}
