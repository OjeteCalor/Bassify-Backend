package es.metrica.Bassify_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.metrica.Bassify_Backend.models.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long>{
}
