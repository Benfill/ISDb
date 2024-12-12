package io.benfill.isdb.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank(message = "Song's title is required")
	@NotNull(message = "Song's title is required")
	@Column(nullable = false)
	private String title;

	@NotNull(message = "Song's duration is required")
	@Column(nullable = false)
	private Integer duration;

	@NotNull(message = "Song's number is required")
	@Column(nullable = false)
	private Integer number;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;
}
