package com.spotify.musicservice.service;

import com.spotify.musicservice.dto.Album;
import com.spotify.musicservice.dto.SpotifyPlaylist;
import com.spotify.musicservice.dto.Track;
import com.spotify.musicservice.model.SpotifyAccessToken;

public interface SpotifyService {
    String getSpotifyAccessToken();
    SpotifyPlaylist getTopTeluguSongs();


    SpotifyPlaylist getAllHindiSongs();
    SpotifyPlaylist getLoveSongs();
    SpotifyPlaylist getTeluguLoveSongs();
    SpotifyPlaylist getKoreanSongs();
    SpotifyPlaylist getTop50GlobalSongs();

    Album getAlbum(String albumId);

    SpotifyPlaylist getBillBoard100Playlist();

    SpotifyPlaylist getTodayTopHitsPlaylist();

    SpotifyPlaylist getDiscoverWeeklyPlaylist();

    Track getTrack(String trackId);

    Object search(String query);

}
