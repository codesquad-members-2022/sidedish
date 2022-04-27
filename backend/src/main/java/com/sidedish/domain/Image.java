package com.sidedish.domain;

public class Image {
	private Long id;
	private Long productId;
	private String imagePath;

	public Image(Long id, Long productId, String imagePath) {
		this.id = id;
		this.productId = productId;
		this.imagePath = imagePath;
	}

	public static class Builder {
		private Long id;
		private Long productId;
		private String imagePath;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder productId(Long productId) {
			this.productId = productId;
			return this;
		}

		public Builder imagePath(String imagePath) {
			this.imagePath = imagePath;
			return this;
		}

		public Image build() {
			return new Image(id, productId, imagePath);
		}
	}
}
