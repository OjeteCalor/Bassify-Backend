package es.metrica.Bassify_Backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import es.metrica.Bassify_Backend.models.entity.User;
import es.metrica.Bassify_Backend.models.entity.WeightedPreference;
import es.metrica.Bassify_Backend.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestJPA {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testFindUser() {
		User u = new User();
		u.setSpotifyId("pepitoCraft");
		entityManager.persist(u);
		entityManager.flush();
		
		Optional<User> found = userRepository.findBySpotifyId("pepitoCraft");
		assertTrue(found.isPresent());
		assertEquals("pepitoCraft", found.get().getSpotifyId());
	}
	
	@Test
	void testFindTrack() {
		User u = new User();
		u.setSpotifyId("despacito");
		entityManager.persist(u);
		entityManager.flush();
		
		Optional<User> found = userRepository.findBySpotifyId("despacito");
		assertTrue(found.isPresent());
		assertEquals("despacito", found.get().getSpotifyId());
	}
	
	@Test
	void testUserPreferences() {
	    User u = new User();
	    u.setSpotifyId("pepito");
	    WeightedPreference w = new WeightedPreference();
	    w.setGenre("Rock");
	    w.setUser(u);
	    WeightedPreference w2 = new WeightedPreference();
	    w2.setGenre("Pop");
	    w2.setUser(u);
	    
	    Set<WeightedPreference> preferences = new HashSet<>();
	    preferences.add(w);
	    preferences.add(w2);
	    
	    u.setPreferences(preferences);
	    
	    entityManager.persist(u);
	    entityManager.flush();
	    
	    Optional<User> found = userRepository.findBySpotifyId("pepito");
	    
	    assertTrue(found.isPresent());
	    assertEquals(preferences.toString(), found.get().getPreferences().toString());
	}
}
