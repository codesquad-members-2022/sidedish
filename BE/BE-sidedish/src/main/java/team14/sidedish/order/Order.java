package team14.sidedish.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("SIDEDISH_ORDER")
public class Order {
	@Id
	private Long orderId;
	private int orderQuantity;
	private int orderReserveAmount;
	private String deliveryInformation;
	private int deliveryCharge;
	private LocalDateTime orderDate;
	@Column("USERS_ID")
	private Long userId;
	@Column("MENU_ID")
	private Long menuId;

	public static Order of(
		int orderQuantity,
		int orderReserveAmount,
		String deliveryInformation,
		int deliveryCharge,
		Long userId,
		Long menuId) {
		return new Order(null, orderQuantity, orderReserveAmount, deliveryInformation, deliveryCharge, LocalDateTime.now(), userId, menuId);
	}

	public Order(
		Long orderId,
		int orderQuantity,
		int orderReserveAmount,
		String deliveryInformation,
		int deliveryCharge,
		LocalDateTime orderDate,
		Long userId,
		Long menuId) {
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.orderReserveAmount = orderReserveAmount;
		this.deliveryInformation = deliveryInformation;
		this.deliveryCharge = deliveryCharge;
		this.orderDate = orderDate;
		this.userId = userId;
		this.menuId = menuId;
	}
}
