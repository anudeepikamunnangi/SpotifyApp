package com.spotify.musicservice.controller;

import com.spotify.musicservice.dto.Album;
import com.spotify.musicservice.dto.SpotifyPlaylist;
import com.spotify.musicservice.dto.SpotifyTracks;
import com.spotify.musicservice.service.SpotifyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.model_objects.specification.Track;


@RestController
@Slf4j
@RequestMapping("/api/v1.0/music")
public class SpotifyController {


    private final SpotifyService spotifyService;

    @Autowired
    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @Operation(summary = "Store access Token")
    @GetMapping("/login")
    public ResponseEntity<Object> getSpotifyAccessToken() {
        // Obtain the access token
        log.trace("Inside SpotifyController getSpotifyAccessToken");
        return new ResponseEntity<>(spotifyService.getSpotifyAccessToken(), HttpStatus.OK);
    }
    @Operation(summary = "Get Top Telugu Songs")
    @GetMapping("/topTeluguSongs")
    public ResponseEntity<Object> getTopTeluguSongs() {
        log.trace("Inside SpotifyController getTopTeluguSongs");
        return new ResponseEntity<>(spotifyService.getTopTeluguSongs(), HttpStatus.OK);
    }
    @Operation(summary = "Get Top love Songs")
    @GetMapping("/topLoveSongs")
    public ResponseEntity<Object> getLoveSongs() {
        log.trace("Inside SpotifyController getLoveSongs");
        return new ResponseEntity<>(spotifyService.getLoveSongs(), HttpStatus.OK);
    }

    @Operation(summary = "Get Korean Songs")
    @GetMapping("/topKoreanSongs")
    public ResponseEntity<Object> getKoreanSongs() {
        log.trace("Inside SpotifyController getLoveSongs");
        return new ResponseEntity<>(spotifyService.getKoreanSongs(), HttpStatus.OK);
    }
    @Operation(summary = "Get Top love Songs")
    @GetMapping("/topTeluguLoveSongs")
    public ResponseEntity<Object> getTeluguLoveSongs() {
        log.trace("Inside SpotifyController getTeluguLoveSongs");
        return new ResponseEntity<>(spotifyService.getTeluguLoveSongs(), HttpStatus.OK);
    }
    @Operation(summary = "Get 2K Hindi Songs")
    @GetMapping("/allHindiSongs")
    public ResponseEntity<Object> getAllHindiSongs(){
        log.trace("Inside SpotifyController getAllHindiSongs");
        return new ResponseEntity<>(spotifyService.getAllHindiSongs(), HttpStatus.OK);
    }

    @Operation(summary = "Get Top 50 Global Songs")
    @GetMapping("/top50GlobalSongs")
    public ResponseEntity<Object> getTop50GlobalSongs(){
        log.trace("Inside SpotifyController getTop50GlobalSongs");
        return new ResponseEntity<>(spotifyService.getTop50GlobalSongs(), HttpStatus.OK);
    }

    @Operation(summary = "Get Bill Board 100 Playlist")
    @GetMapping("/billBoard100Playlist")
    public ResponseEntity<Object> getBillBoard100Playlist() {
        log.trace("Inside SpotifyController getBillBoard100Playlist");
        return new ResponseEntity<>(spotifyService.getBillBoard100Playlist(), HttpStatus.OK);
    }

    @Operation(summary = "Get Top Hits Playlist")
    @GetMapping("/todayTopHitsPlaylist")
    public ResponseEntity<Object> getTodayTopHitsPlaylist() {
        log.trace("Inside SpotifyController getTodayTopHitsPlaylist");
        return new ResponseEntity<>(spotifyService.getTodayTopHitsPlaylist(), HttpStatus.OK);
    }
    @Operation(summary = "Get Discover Weekly Playlist")
    @GetMapping("/todayDiscoverWeeklyPlaylist")
    public ResponseEntity<Object> getDiscoverWeeklyPlaylist() {
        log.trace("Inside SpotifyController getDiscoverWeeklyPlaylist");
        return new ResponseEntity<>(spotifyService.getDiscoverWeeklyPlaylist(), HttpStatus.OK);
    }

    @Operation(summary = "Get a track by its id")
    @GetMapping("/track")
    public ResponseEntity<Object> getTrack(@RequestParam String trackId ) {
        log.trace("Inside SpotifyController getTrack");
        return new ResponseEntity<>(spotifyService.getTrack(trackId), HttpStatus.OK);
    }

    @Operation(summary = "Search tracks by name")
    @GetMapping("/searchTracks")
    public ResponseEntity<Object> search(@RequestParam String query) {
        log.trace("Inside SpotifyController search");
        return new ResponseEntity<>(spotifyService.search(query), HttpStatus.OK);
    }
    @Operation(summary = "Search album by Id")
    @GetMapping("/album/{albumId}")
    public ResponseEntity<Album> getAlbumById(@PathVariable String albumId){
        Album album = spotifyService.getAlbum(albumId);
        if (album != null){
            return ResponseEntity.ok(album);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
