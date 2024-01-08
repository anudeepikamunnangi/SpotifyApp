//package com.spotify.musicservice.service;
//import com.spotify.musicservice.dto.Album;
//import com.spotify.musicservice.dto.SpotifyPlaylist;
//import com.spotify.musicservice.dto.SpotifyTracks;
//import com.spotify.musicservice.model.SpotifyAccessToken;
//import com.spotify.musicservice.repository.SpotifyAccessTokenRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//import se.michaelthelin.spotify.requests.IRequest;
//
//import java.net.URI;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class SpotifyServiceImplTest {
//
//    @MockBean
//    private SpotifyAccessTokenRepository spotifyAccessTokenRepository;
//
//    @MockBean
//    private RestTemplate restTemplate;
//
//    // Add more dependencies if needed
//
//    @Test
//    public void testGetSpotifyAccessToken() {
//        // Set up test data and expectations
//        // For example, mock the restTemplate.postForEntity method
//        ResponseEntity<SpotifyAccessToken> mockResponseEntity = new ResponseEntity<>(new SpotifyAccessToken(), HttpStatus.OK);
//        when(restTemplate.postForEntity(anyString(), any(), eq(SpotifyAccessToken.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        String result = spotifyService.getSpotifyAccessToken();
//
//        // Add assertions based on your expected behavior
//        // For example, you might want to verify that the repository save method is called
//        verify(spotifyAccessTokenRepository, times(1)).save(any());
//
//        // Add more assertions based on your specific requirements
//    }
//
//    @Test
//    public void testGetTopTeluguSongs() {
//        // Set up test data and expectations
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        ResponseEntity<SpotifyPlaylist> mockResponseEntity = new ResponseEntity<>(new SpotifyPlaylist(),HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        SpotifyPlaylist result = spotifyService.getTopTeluguSongs();
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class));
//
//    }
//
//    @Test
//    public void testGetAllHindiSongs() {
//        // Set up test data and expectations
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        ResponseEntity<SpotifyPlaylist> mockResponseEntity = new ResponseEntity<>(new SpotifyPlaylist(),HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        SpotifyPlaylist result = spotifyService.getAllHindiSongs();
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class));
//
//
//    }
//
//    @Test
//    public void testGetTop50GlobalSongs() {
//        // Set up test data and expectations
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        ResponseEntity<SpotifyPlaylist> mockResponseEntity = new ResponseEntity<>(new SpotifyPlaylist(),HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        SpotifyPlaylist result = spotifyService.getTop50GlobalSongs();
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class));
//
//
//    }
//
//    @Test
//    public void testGetBillBoard100Playlist() {
//        // Set up test data and expectations
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        ResponseEntity<SpotifyPlaylist> mockResponseEntity = new ResponseEntity<>(new SpotifyPlaylist(),HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        SpotifyPlaylist result = spotifyService.getBillBoard100Playlist();
//
//        // Add assertions based on your expected behavior
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class));
//
//
//    }
//
//    @Test
//    public void testGetTodayTopHitsPlaylist() {
//        // Set up test data and expectations
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
////        String playlistId = "37i9dQZF1DXcBWIGoYBM5M";
////        ResponseEntity<Void> expectedRequestEntity = playListRequest(playlistId);
//        ResponseEntity<SpotifyPlaylist> mockResponseEntity = new ResponseEntity<>(new SpotifyPlaylist(),HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        SpotifyPlaylist result = spotifyService.getTodayTopHitsPlaylist();
//
//        // Add assertions based on your expected behavior
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class));
//
//        assertNotNull(result);
//    }
//
//    @Test
//    public void testGetDiscoverWeeklyPlaylist() {
//        // Set up test data and expectations
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        ResponseEntity<SpotifyPlaylist> mockResponseEntity = new ResponseEntity<>(new SpotifyPlaylist(),HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        SpotifyPlaylist result = spotifyService.getDiscoverWeeklyPlaylist();
//
//        // Add assertions based on your expected behavior
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(SpotifyPlaylist.class));
//
//
//    }
//
//
//
//    @Test
//    public void testGetAlbum() {
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        // Set up test data and expectations
//        ResponseEntity<Album> mockResponseEntity = new ResponseEntity<>(new Album(), HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(Album.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        Album result = spotifyService.getAlbum("albumId123");
//
//        // Add assertions based on your expected behavior
//        // For example, you might want to verify that the restTemplate.exchange method is called
//        verify(restTemplate, times(1)).exchange(any(RequestEntity.class), eq(Album.class));
//
//        // Add more assertions based on your specific requirements
//    }
//
//    @Test
//    public void testSearch() {
//        Optional<SpotifyAccessToken> optionalSpotifyAccessToken = Optional.of(new SpotifyAccessToken("example_token"));
//        when(spotifyAccessTokenRepository.findById(1)).thenReturn(optionalSpotifyAccessToken);
//        // Set up test data and expectations
//        ResponseEntity<SpotifyTracks> mockResponseEntity = new ResponseEntity<>(new SpotifyTracks(), HttpStatus.OK);
//        when(restTemplate.exchange(any(RequestEntity.class), eq(SpotifyTracks.class))).thenReturn(mockResponseEntity);
//
//        // Call the method to be tested
//        SpotifyServiceImpl spotifyService = new SpotifyServiceImpl(spotifyAccessTokenRepository, restTemplate);
//        Object result = spotifyService.search("query123");
//
//        // Add assertions based on your expected behavior
//        // For example, you might want to verify that the restTemplate.exchange method is called
//        verify(restTemplate, times(1)).exchange(argThat(request -> {
//            String expectedUri = "/search?q=query123";
//            return request.getUrl().toString().contains(expectedUri);
//                }),eq(SpotifyTracks.class));
//
//        // Add more assertions based on your specific requirements
//    }
//
//
//}