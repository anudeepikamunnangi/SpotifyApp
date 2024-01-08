package com.spotify.wishlistservice.controller;

import com.spotify.wishlistservice.dto.TrackDto;
import com.spotify.wishlistservice.dto.WishlistDto;
import com.spotify.wishlistservice.service.AuthService;
import com.spotify.wishlistservice.service.WishlistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


    @ExtendWith(MockitoExtension.class)
    public class WishlistControllerTest {

        @Mock
        private WishlistService wishlistService;

        @Mock
        private AuthService authService;

        @InjectMocks
        private WishlistController wishlistController;

        @Test
        public void testGetUserWishList() {
            // Mocking
            String token = "yourAuthToken";
            String username = "testUser";
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put(username, "userId123");
            when(authService.validateToken(token)).thenReturn(userInfo);
            when(wishlistService.getUserWishlist(username)).thenReturn(new WishlistDto());

            // Test
            ResponseEntity<Object> response = wishlistController.getUserWishLisl(token, username);

            // Assertions
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            verify(authService, times(1)).validateToken(token);
            verify(wishlistService, times(1)).getUserWishlist(username);
        }

        @Test
        public void testSaveTrackToWishlist() {
            // Mocking
            String token = "yourAuthToken";
            String username = "testUser";
            TrackDto trackDto = new TrackDto();
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put(username, "userId123");
            when(authService.validateToken(token)).thenReturn(userInfo);
            when(wishlistService.saveTrackToWishlist(username, trackDto)).thenReturn(trackDto);

            // Test
            ResponseEntity<Object> response = wishlistController.saveTrackToWishlist(token, username, trackDto);

            // Assertions
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertNotNull(response.getBody());
            verify(authService, times(1)).validateToken(token);
            verify(wishlistService, times(1)).saveTrackToWishlist(username, trackDto);
        }

        @Test
        public void testDeleteTrackByUsernameAndTrackId() {
            // Mocking
            String token = "yourAuthToken";
            String username = "testUser";
            String trackId = "track123";
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put(username, "userId123");
            when(authService.validateToken(token)).thenReturn(userInfo);
            when(wishlistService.deleteTrackByUsernameAndTrackId(username, trackId)).thenReturn("Track deleted successfully");

            // Test
            ResponseEntity<Object> response = wishlistController.deleteTrackByUsernameAndTrackId(token, username, trackId);

            // Assertions
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            verify(authService, times(1)).validateToken(token);
            verify(wishlistService, times(1)).deleteTrackByUsernameAndTrackId(username, trackId);
        }
    }
