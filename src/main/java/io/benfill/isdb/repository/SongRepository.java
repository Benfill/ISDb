package io.benfill.isdb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.benfill.isdb.model.Song;

public interface SongRepository extends MongoRepository<Song, String> {
	List<Song> findByTitleLike(String title, Pageable pageable);

	List<Song> findByAlbumId(String albumId);

}
