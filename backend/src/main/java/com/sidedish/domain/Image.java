package com.sidedish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Image {
	private Long id;
	private Long productId;
	private String imagePath;
}
