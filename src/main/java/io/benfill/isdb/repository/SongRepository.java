package io.benfill.isdb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.benfill.isdb.model.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, Long> {
	List<Song> findByTitleLike(String title, Pageable pageable);

}
