package es.metrica.Bassify_Backend.toolbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import es.metrica.Bassify_Backend.models.logic.toolbox.DeezerPreview;

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
		
		assertNull(DeezerPreview.getTrackPreview("Artista Inexistente", "Cancion Inexistente"));
	}
}
