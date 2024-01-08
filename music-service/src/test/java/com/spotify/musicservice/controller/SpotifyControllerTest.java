//package com.spotify.musicservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.spotify.musicservice.dto.*;
//import com.spotify.musicservice.service.SpotifyService;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.http.MediaType;
//
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class SpotifyControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private SpotifyService spotifyService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//    @InjectMocks
//    private  SpotifyController spotifyController;
//
//    @Test
//    void testGetSpotifyAccessToken() throws Exception {
//        // Mocking service method
//        when(spotifyService.getSpotifyAccessToken()).thenReturn("mockedAccessToken");
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/login")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("mockedAccessToken"));
//    }
//
//    @Test
//    void testGetTopTeluguSongs() throws Exception {
//        // Mocking service method
//        when(spotifyService.getTopTeluguSongs()).thenReturn(new SpotifyPlaylist(/* Mocked SpotifyPlaylist object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/get-top-telugu-songs")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testGetAllHindiSongs() throws Exception {
//        // Mocking service method
//        when(spotifyService.getAllHindiSongs()).thenReturn(new SpotifyPlaylist(/* Mocked SpotifyPlaylist object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/all-2k-hindi-songs")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testGetTop50GlobalSongs() throws Exception {
//        // Mocking service method
//        when(spotifyService.getTop50GlobalSongs()).thenReturn(new SpotifyPlaylist(/* Mocked SpotifyPlaylist object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/top-50-global-songs")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testGetBillBoard100Playlist() throws Exception {
//        // Mocking service method
//        when(spotifyService.getBillBoard100Playlist()).thenReturn(new SpotifyPlaylist(/* Mocked SpotifyPlaylist object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/bill-board-100-playlist")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//
//    @Test
//    void testGetTodayTopHitsPlaylist() throws Exception {
//        // Mocking service method
//        when(spotifyService.getTodayTopHitsPlaylist()).thenReturn(new SpotifyPlaylist(/* Mocked SpotifyPlaylist object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/today-top-hits-playlist")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//    @Test
//    void testGetDiscoverWeeklyPlaylist() throws Exception {
//        // Mocking service method
//        when(spotifyService.getDiscoverWeeklyPlaylist()).thenReturn(new SpotifyPlaylist(/* Mocked SpotifyPlaylist object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/today-discover-weekly-playlist")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//    @Test
//    void testGetTrackById() throws Exception {
//        // Mocking service method
//        String trackId = "someTrackId";
//        when(spotifyService.getTrack(trackId)).thenReturn(new Track()/* Mocked Track object */);
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/get-track")
//                        .param("trackId", trackId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testGetAlbumById() throws Exception {
//        // Mocking service method
//        String albumId = "someAlbumId";
//        when(spotifyService.getAlbum(albumId)).thenReturn(new Album(/* Mocked SpotifyTracks object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/album/{albumId}", albumId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testSearch() throws Exception {
//        // Mocking service method
//        String query = "someQuery";
//        when(spotifyService.search(query)).thenReturn(new SpotifyTracks(/* Mocked SpotifyTracks object */));
//
//        // Performing the test
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/music/search")
//                        .param("query", query)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    // Add more test cases for other endpoints following a similar pattern
//}
