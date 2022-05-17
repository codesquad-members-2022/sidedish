package com.sidedish.domain.product;

import com.sidedish.domain.user.Member;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Order {

	@Id @GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@OneToMany(mappedBy = "order")
	private List<OrderProduct> products = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	private int quantity;

	private int price;
}
