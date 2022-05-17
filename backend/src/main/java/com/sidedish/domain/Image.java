package com.sidedish.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Image {

	@Id @GeneratedValue
	@Column(name = "image_id")
	private Long id;
	private Long productId;
	private String imagePath;
}
