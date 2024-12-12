package io.benfill.isdb.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "albums")
@Getter
@Setter
@Builder
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank(message = "Album's title is required")
	@NotNull(message = "Album's title is required")
	@Column(nullable = false)
	private String title;

	@NotBlank(message = "Album's artist is required")
	@NotNull(message = "Album's artist is required")
	@Column(nullable = false)
	private String artist;

	@NotNull(message = "Album's year is required")
	@Column(nullable = false)
	private Integer year;

	@JsonManagedReference
	@OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Song> songs;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

}
