package com.example.ArtGallery.mapper.Impl;

import com.example.ArtGallery.dto.GalleryRequest;
import com.example.ArtGallery.dto.GalleryResponse;
import com.example.ArtGallery.mapper.GalleryMapper;
import com.example.ArtGallery.model.Gallery;
import org.springframework.stereotype.Component;

@Component
public class GalleryMapperImpl implements GalleryMapper {
    @Override
    public Gallery toGallery(GalleryRequest galleryRequest) {
        Gallery gallery = new Gallery();
        gallery.setName(galleryRequest.getName());
        gallery.setDescription(galleryRequest.getDescription());
        gallery.setAddress(galleryRequest.getAddress());
        return gallery;
    }

    @Override
    public GalleryResponse toGalleryResponse(Gallery gallery) {
        GalleryResponse galleryResponse = new GalleryResponse();
        galleryResponse.setId(gallery.getId());
        galleryResponse.setName(gallery.getName());
        galleryResponse.setDescription(gallery.getDescription());
        galleryResponse.setAddress(gallery.getAddress());
        return galleryResponse;
    }
}
