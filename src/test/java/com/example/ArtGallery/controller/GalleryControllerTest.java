package com.example.ArtGallery.controller;

import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.service.GalleryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.anyLong;

class GalleryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GalleryService galleryService;

    @InjectMocks
    private GalleryController galleryController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(galleryController).build();
    }

    @Test
    void testGetGallery() throws Exception {
        Gallery gallery = new Gallery();
        gallery.setId(1L);
        gallery.setName("Sample Gallery");

        when(galleryService.getGallery(anyLong())).thenReturn(gallery);

        mockMvc.perform(get("/gallery/get")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Sample Gallery"));
    }
}
