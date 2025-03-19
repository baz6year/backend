import com.example.ArtGallery.model.ArtPieces;
import com.example.ArtGallery.model.Artist;
import com.example.ArtGallery.model.Gallery;
import com.example.ArtGallery.repository.ArtPiecesRepository;
import com.example.ArtGallery.repository.ArtistRepository;
import com.example.ArtGallery.repository.GalleryRepository;
import com.example.ArtGallery.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Profile("dev")  // This ensures it runs only in the 'dev' environment
@RequiredArgsConstructor
@Slf4j
public class DataLoader {
    private final ArtistRepository artistRepository;
    private final GalleryRepository galleryRepository;
    private final ArtPiecesRepository artPiecesRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void loadData() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass()
                .getClassLoader().getResourceAsStream("data.csv")))) {
            br.lines().skip(1).forEach(line -> {
                String[] data = line.split(",");
                if (data.length < 7) return;

                String artistName = data[0].trim();
                String title = data[1].trim();
                String galleryName = data[2].trim();
                String galleryDesc = data[3].trim();
                String galleryAddr = data[4].trim();
                int year = Integer.parseInt(data[5].trim());
                String type = data[6].trim();

                Artist artist = artistRepository.findByName(artistName)
                        .orElseGet(() -> artistRepository.save(new Artist()));

                Gallery gallery = galleryRepository.findByName(galleryName)
                        .orElseGet(() -> galleryRepository.save(new Gallery()));

                ArtPieces artPiece = new ArtPieces();
                artPiecesRepository.save(artPiece);
            });

            log.info("Development data loaded.");
        } catch (IOException e) {
            log.error("Failed to load data.csv: {}", e.getMessage());
        }
    }
}
