package team14.sidedish.menu;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import team14.sidedish.order.OrderInfo;
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
		private final BigDecimal price;
		private int discountedPrice;
		private final List<String> image;
		private List<String> event;

		@Builder
		public SubCategory(Long menuId, String menuName, String description, BigDecimal originalPrice, List<String> image) {
			this.menuId = menuId;
			this.menuName = menuName;
			this.description = description;
			this.price = originalPrice;
			this.image = image;
		}

		@Override
		public void setDiscountedPrice(BigDecimal discountedPrice) {
			this.discountedPrice = discountedPrice.intValue();
		}

		@Override
		public void setEvent(List<String> events) {
			this.event = events;
		}
	}

	@Data
	public static class DetailResponse {
		private SubCategory menu;

		private final DeliveryInfo orderInfo;

		private final CategoryResponse with;

		public DetailResponse(
			SubCategory menu,
			boolean orderStatus,
			CategoryResponse categoryResponse) {
			this.menu = menu;
			this.orderInfo = new DeliveryInfo(orderStatus);
			this.with = categoryResponse;
		}

		public void setSavedCharge(int price) {
			this.orderInfo.setSavedCharge(price);
		}
	}

	@Data
	@RequiredArgsConstructor
	public static class DeliveryInfo {
		private int savedCharge;
		private final String deliveryInfo;
		private final DeliveryCharge deliveryCharge;
		private final String orderStatus;

		public DeliveryInfo(boolean orderStatus) {
			Function<Boolean, String> availableOrder = (status) -> status ? "sale" :"sold out";
			DeliveryCharge deliveryCharge = new DeliveryCharge(
				OrderInfo.getDeliveryCharge(),
				OrderInfo.getDeliveryFreeCondition(),
				OrderInfo.DELIVERY_CHARGE.getDescription());
			this.deliveryInfo = OrderInfo.DELIVERY_INFO.getDescription();
			this.deliveryCharge = deliveryCharge;
			this.orderStatus = availableOrder.apply(orderStatus);
		}

		/**
		 * 할인 적용 안됐을 때는 원금, 할인 적용시에는 할인된 금액을 파라미터로 전달받습니다.
		 * @param price
		 */
		public void setSavedCharge(int price) {
			this.savedCharge = OrderInfo.SAVED_CHARGE.calculate(price);
		}
	}

	@Data
	@RequiredArgsConstructor
	public static class DeliveryCharge {
		private final int baseCharge;
		private final int freeCondition;
		private final String message;
	}
}
