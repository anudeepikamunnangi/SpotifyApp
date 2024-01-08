package com.spotify.wishlistservice.service;

import com.spotify.wishlistservice.exception.ServerConnectionException;
import com.spotify.wishlistservice.feignclient.AuthenticationClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthenticationClient authenticationClient;

    @Test
    public void testValidateToken_SuccessfulValidation_ReturnsUserInfoMap() {
        // Arrange
        String token = "validToken";
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userId", "123");
        userInfo.put("username", "anu");
        ResponseEntity<Map<String, String>> successfulResponse = new ResponseEntity<>(userInfo, HttpStatus.OK);

        when(authenticationClient.validateToken(token)).thenReturn(successfulResponse);

        // Act
        Map<String, String> result = authService.validateToken(token);

        // Assert
        assertEquals(userInfo, result);
    }

    @Test
    public void testValidateToken_FailedValidation_UnAuthorizedException() {
        // Arrange
        String token = "invalidToken";
        ResponseEntity<Map<String, String>> failedResponse = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        when(authenticationClient.validateToken(token)).thenReturn(failedResponse);

        // Act & Assert
        assertThrows(ServerConnectionException.class, () -> authService.validateToken(token));
    }

    @Test
    public void testValidateToken_FailedValidationWithSpecificHttpStatus_UnAuthorizedException() {
        // Arrange
        String token = "invalidToken";
        ResponseEntity<Map<String, String>> failedResponse = new ResponseEntity<>(HttpStatus.FORBIDDEN);

        when(authenticationClient.validateToken(token)).thenReturn(failedResponse);

        // Act & Assert
        assertThrows(ServerConnectionException.class, () -> authService.validateToken(token));
    }

    @Test
    public void testValidateToken_HttpClientErrorException_UnAuthorizedException() {
        // Arrange
        String token = "invalidToken";

        // Simulate HttpClientErrorException with 401 status code
        when(authenticationClient.validateToken(token)).thenThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED));

        // Act & Assert
        assertThrows(ServerConnectionException.class, () -> authService.validateToken(token));
    }

    @Test
    public void testValidateToken_RestClientException_ServerConnectionException() {
        // Arrange
        String token = "validToken";

        // Simulate RestClientException
        when(authenticationClient.validateToken(token)).thenThrow(new RestClientException("Connection refused"));

        // Act & Assert
        assertThrows(ServerConnectionException.class, () -> authService.validateToken(token));
    }

    @Test
    public void testValidateToken_GenericException_ServerConnectionException() {
        // Arrange
        String token = "validToken";

        // Simulate a generic exception
        when(authenticationClient.validateToken(token)).thenThrow(new RuntimeException("Unexpected error"));

        // Act & Assert
        assertThrows(ServerConnectionException.class, () -> authService.validateToken(token));
    }
}