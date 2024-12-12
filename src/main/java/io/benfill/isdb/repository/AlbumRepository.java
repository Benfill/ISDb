package io.benfill.isdb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.benfill.isdb.model.Album;

public interface AlbumRepository extends MongoRepository<Album, Long> {

}
