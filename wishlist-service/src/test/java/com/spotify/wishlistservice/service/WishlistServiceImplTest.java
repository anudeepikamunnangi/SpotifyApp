package com.spotify.wishlistservice.service;

import com.spotify.wishlistservice.dto.TrackDto;
import com.spotify.wishlistservice.dto.WishlistDto;
import com.spotify.wishlistservice.exception.ResourceNotFoundException;
import com.spotify.wishlistservice.model.Track;
import com.spotify.wishlistservice.model.Wishlist;
import com.spotify.wishlistservice.repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WishlistServiceImplTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Test
    void testGetUserWishlist_ValidUsername_WishlistExists() {
        String username = "testUser";
        Wishlist wishlist = new Wishlist();
        when(wishlistRepository.findById(username)).thenReturn(Optional.of(wishlist));

        WishlistDto wishlistDto = new WishlistDto();
        when(modelMapper.map(wishlist, WishlistDto.class)).thenReturn(wishlistDto);

        WishlistDto result = wishlistService.getUserWishlist(username);

        assertEquals(wishlistDto, result);
    }

    @Test
    void testGetUserWishlist_InvalidUsername_WishlistDoesNotExist() {
        String username = "nonExistingUser";
        when(wishlistRepository.findById(username)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> wishlistService.getUserWishlist(username));
    }

    @Test
    void testSaveTrackToWishlist_ValidUsernameAndNewTrack_WishlistExists() {
        String username = "testUser";
        TrackDto trackDto = new TrackDto();
        Wishlist existingWishlist = new Wishlist();
        existingWishlist.setTracks(new ArrayList<>());
        Track track = new Track();
        when(wishlistRepository.findById(username)).thenReturn(Optional.of(existingWishlist));
        when(modelMapper.map(trackDto, Track.class)).thenReturn( new Track());

        wishlistService.saveTrackToWishlist(username, trackDto);
        verify(wishlistRepository).save(existingWishlist);
        assertEquals(1,existingWishlist.getTracks().size());

    }

    // Add more test cases for saveTrackToWishlist for different scenarios

    @Test
    void testDeleteTrackByUsernameAndTrackId_WishlistExistsAndTrackRemoved() {
        String username = "testUser";
        String trackIdToRemove = "track123";

        // Existing wishlist with tracks
        List<Track> tracks = new ArrayList<>();
        Track trackToRemove = new Track();
        trackToRemove.setId(trackIdToRemove);
        tracks.add(trackToRemove);

        Wishlist existingWishlist = new Wishlist();
        existingWishlist.setTracks(tracks);

        // Mocking repository behavior
        when(wishlistRepository.findById(username)).thenReturn(Optional.of(existingWishlist));

        // Calling the method
        String result = wishlistService.deleteTrackByUsernameAndTrackId(username, trackIdToRemove);

        // Verifying behavior
        verify(wishlistRepository).save(existingWishlist); // Verify that save was called
        assertEquals("Track with Id: " + trackIdToRemove + " deleted.", result); // Ensure correct result
        assertTrue(existingWishlist.getTracks().isEmpty()); // Ensure track was removed
    }

    @Test
    void testDeleteTrackByUsernameAndTrackId_WishlistDoesNotExist() {
        String username = "testUser";
        String trackIdToRemove = "track123";

        // Mocking repository behavior
        when(wishlistRepository.findById(username)).thenReturn(Optional.empty());

        // Calling the method
          assertThrows(ResourceNotFoundException.class,()->
                  wishlistService.deleteTrackByUsernameAndTrackId(username,trackIdToRemove));
        verify(wishlistRepository, never()).save(any(Wishlist.class)); // Verify that save was not called

    }


}




