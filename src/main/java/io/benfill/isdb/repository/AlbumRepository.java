package io.benfill.isdb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.benfill.isdb.model.Album;

public interface AlbumRepository extends MongoRepository<Album, Long> {
	List<Album> findByTitleLike(String title, Pageable pageable);

	List<Album> findByArtistLike(String artist, Pageable pageable);
}
