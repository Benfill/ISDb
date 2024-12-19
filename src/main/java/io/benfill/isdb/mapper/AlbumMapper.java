package io.benfill.isdb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.benfill.isdb.dto.request.AlbumDtoReq;
import io.benfill.isdb.dto.response.AlbumDtoResp;
import io.benfill.isdb.model.Album;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
	@Mapping(target = "id", source = "entity.id")
	@Mapping(target = "createdAt", source = "entity.createdAt")
	@Mapping(target = "updatedAt", source = "entity.updatedAt")
	AlbumDtoResp entityToDto(Album entity);

	@Mapping(target = "id", source = "entity.id")
	@Mapping(target = "createdAt", source = "entity.createdAt")
	@Mapping(target = "updatedAt", source = "entity.updatedAt")
	List<AlbumDtoResp> entitiesToDtos(List<Album> entities);

	Album DtoToentity(AlbumDtoReq dto);
}
