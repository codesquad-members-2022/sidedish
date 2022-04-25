package team14.sidedish.menu;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import team14.sidedish.specialmenu.enums.SpecialMenuValue;

public class MenuDto {
	@Data
	static class Response {
		private final ExhibitionResponse exhibition;
		private final CategoryResponse categories;
	}

	@Data
	@RequiredArgsConstructor
	static class ExhibitionResponse {
		private final String exhibitionTitle;
		private final List<SpecialMenuValue> categoryNameList;
		private final CategoryResponse specialCategories;

		public ExhibitionResponse(String exhibitionTitle, CategoryResponse specialCategories) {
			this.exhibitionTitle = exhibitionTitle;
			this.categoryNameList = SpecialMenuValue.getSpecialMenuTitles();
			this.specialCategories = specialCategories;
		}
	}

	@Data
	@RequiredArgsConstructor
	static class CategoryResponse {
		private final int categoryId;
		private final String categoryTitle;
		private final List<SubCategory> subCategoryList;
	}

	@Data
	public static class SubCategory implements MenuModel{
		private final Long menuId;
		private final String menuName;
		private final String description;
		private final BigDecimal originalPrice;
		private int discountedPrice;
		private final String image;
		private List<String> event;

		@Builder
		public SubCategory(Long menuId, String menuName, String description, BigDecimal originalPrice, String image) {
			this.menuId = menuId;
			this.menuName = menuName;
			this.description = description;
			this.originalPrice = originalPrice;
			this.image = image;
		}

		public void setDiscountedPrice(BigDecimal discountedPrice) {
			this.discountedPrice = discountedPrice.intValue();
		}
	}
}
