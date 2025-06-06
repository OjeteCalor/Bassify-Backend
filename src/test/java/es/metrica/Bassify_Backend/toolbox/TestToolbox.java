package es.metrica.Bassify_Backend.toolbox;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import es.metrica.Bassify_Backend.models.logic.toolbox.AccesToken;
import es.metrica.Bassify_Backend.models.logic.toolbox.DeezerPreview;
import es.metrica.Bassify_Backend.models.logic.toolbox.TokenPetition;
import es.metrica.Bassify_Backend.properties.PropertiesSingleton;

class TestToolbox {
	
	@Test
	void testDeezerPreview() {
		assertEquals(DeezerPreview.getTrackPreview("Ojete Calor", "Tonta Gilipo").split("\\?")[0], 
				"http://cdnt-preview.dzcdn.net/api/1/1/4/e/c/0/4ec809e33b3d8c3474f2783304030b00.mp3");
		
		assertEquals(DeezerPreview.getTrackPreview("Ojete Calor", "Viejoven").split("\\?")[0], 
				"http://cdnt-preview.dzcdn.net/api/1/1/9/9/c/0/99c1b8d14758f74f06a1a25257101e0e.mp3");
		
		assertEquals(DeezerPreview.getTrackPreview("Ojete Calor", "Mocatriz").split("\\?")[0], 
				"http://cdnt-preview.dzcdn.net/api/1/1/7/2/9/0/729e09a56936c379795eeff7b25b5a6f.mp3");
		
		assertEquals(DeezerPreview.getTrackPreview("Amador Rivas", "Mandanga Style").split("\\?")[0], 
				"http://cdnt-preview.dzcdn.net/api/1/1/0/f/b/0/0fb9525af824a7b5db3a87fda130c4ea.mp3");
		
		assertEquals(DeezerPreview.getTrackPreview("Eminem", "Slim Shady").split("\\?")[0], 
				DeezerPreview.getTrackPreview("Eminem", "Slim Shady").split("\\?")[0]);
		
		assertEquals(DeezerPreview.getTrackPreview("Tata Golosa", "Chiki Chiki").split("\\?")[0], 
				DeezerPreview.getTrackPreview("Rodolfo Chikilcuatre", "Chiki Chiki").split("\\?")[0]);
		
		assertDoesNotThrow(() -> DeezerPreview.getTrackPreview("Artista Inexistente", "Cancion Inexistente"));
		assertDoesNotThrow(() -> DeezerPreview.getTrackPreview("😀", "😀"));
		
		assertNull(DeezerPreview.getTrackPreview("Artista Inexistente", "Cancion Inexistente"));
		assertNull(DeezerPreview.getTrackPreview("😀", "😀"));
		
		assertNotNull(DeezerPreview.getTrackPreview("", ""));
		assertNotNull(DeezerPreview.getTrackPreview("Shit Infested Roach Human Carcass", "Shit Infested Roach Human Carcass"));
	}
	
	@Test
	void testRefreshToken() {
		Properties p = PropertiesSingleton.getProperties();
		
		assertNotNull(AccesToken.getAccessToken(p.getProperty("refreshToken")));
		assertNotNull(AccesToken.getAccessToken(p.getProperty("refreshToken")));
		assertNotNull(AccesToken.getAccessToken(p.getProperty("refreshToken")));
		assertThrows(HttpClientErrorException.class, () -> AccesToken.getAccessToken("no_valido"));
		assertThrows(HttpClientErrorException.class, () -> AccesToken.getAccessToken("no_valido"));
	}
	
	@Test
	void testAccessToken() {
		Properties p = PropertiesSingleton.getProperties();
		
		assertNotNull(TokenPetition.getUserId(AccesToken.getAccessToken(p.getProperty("refreshToken"))));
		assertNotNull(TokenPetition.getUserId(AccesToken.getAccessToken(p.getProperty("refreshToken"))));
		assertNotNull(TokenPetition.getUserId(AccesToken.getAccessToken(p.getProperty("refreshToken"))));
		assertNotNull(TokenPetition.getUserId(AccesToken.getAccessToken(p.getProperty("refreshToken"))));
		assertThrows(NullPointerException.class, () -> TokenPetition.getUserId("no_valido"));
		assertThrows(NullPointerException.class, () -> TokenPetition.getUserId("no_valido"));
	}
}
