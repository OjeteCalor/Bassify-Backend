package es.metrica.Bassify_Backend;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import es.metrica.Bassify_Backend.controllers.UserController;
import es.metrica.Bassify_Backend.models.dto.UserDTO;
import es.metrica.Bassify_Backend.models.dto.UserLoginDTO;
import es.metrica.Bassify_Backend.services.UserService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
class TestUserMockito {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserService userService;
    
    @Test
    void testLogin_error() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setSpotifyId("pepito");
        userDto.setRefreshToken("token_ejemplo_malo");
        
        when(userService.login(any(UserDTO.class)))
                .thenReturn(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));

        mockMvc.perform(post("/api/v1/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
            .andExpect(status().is4xxClientError());
    }
    
    @Test
    void testLogin_success() throws Exception {
        UserDTO userDto = new UserDTO();
        userDto.setSpotifyId("menganito");
        userDto.setRefreshToken("token_ejemplo_valido");
        
        UserLoginDTO userLoginDto = new UserLoginDTO();
        userLoginDto.setSpotifyId("menganito");

        when(userService.login(any(UserDTO.class)))
                .thenReturn(ResponseEntity.ok(userLoginDto));

        mockMvc.perform(post("/api/v1/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"spotifyId\": \"menganito\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.spotifyId").value("menganito"));
    }
}
