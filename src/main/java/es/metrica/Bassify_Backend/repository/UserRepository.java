package es.metrica.Bassify_Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.metrica.Bassify_Backend.models.entity.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findBySpotifyId(String spotifyId);
}
