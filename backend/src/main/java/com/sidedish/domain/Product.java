package com.sidedish.domain;

public class Product {
	private Long id;
	private String title;
	private String description;
	private int price;
	private int stock;
	private EventBadge eventBadge;
	private MainCategory mainCategory;
	private EventCategory eventCategory;

	public Product(Long id, String title, String description, int price, int stock,
		EventBadge eventBadge, MainCategory mainCategory, EventCategory eventCategory) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.eventBadge = eventBadge;
		this.mainCategory = mainCategory;
		this.eventCategory = eventCategory;
	}

	public static class Builder {
		private Long id;
		private String title;
		private String description;
		private int price;
		private int stock;
		private EventBadge eventBadge;
		private MainCategory mainCategory;
		private EventCategory eventCategory;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder price(int price) {
			this.price = price;
			return this;
		}

		public Builder stock(int stock) {
			this.stock = stock;
			return this;
		}

		public Builder eventBadge(EventBadge eventBadge) {
			this.eventBadge = eventBadge;
			return this;
		}

		public Builder mainCategory(MainCategory mainCategory) {
			this.mainCategory = mainCategory;
			return  this;
		}

		public Builder eventCategory(EventCategory eventCategory) {
			this.eventCategory = eventCategory;
			return this;
		}

		public Product build() {
			return new Product(id, title, description, price, stock, eventBadge, mainCategory, eventCategory);
		}
	}
}
