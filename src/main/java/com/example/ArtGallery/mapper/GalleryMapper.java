package com.example.ArtGallery.mapper;

import com.example.ArtGallery.dto.GalleryRequest;
import com.example.ArtGallery.dto.GalleryResponse;
import com.example.ArtGallery.model.Gallery;

public interface GalleryMapper {
    Gallery toGallery(GalleryRequest galleryRequest);
    GalleryResponse toGalleryResponse(Gallery gallery);
}
