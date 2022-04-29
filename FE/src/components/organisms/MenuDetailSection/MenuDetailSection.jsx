import "./MenuDetailSection.scss";
import FigureWithSize from "@/components/atoms/Figure/FigureWithSize.jsx";
import { MenuLabel } from "@/components/atoms/Label/MenuLabel.jsx";
import minus from "@/assets/image/minus.svg";
import plus from "@/assets/image/plus.svg";
import order from "@/assets/image/order.svg";
import { MenuPrices } from "@/components/molecules/MenuPrices/MenuPrices.jsx";
import { useState } from "react";

export default function MenuDetailSection({ card }) {
  const [orderQuantity, setOrderQuantity] = useState(1);

  return (
    <>
      <section className="menu-detail">
        <div className="menu-detail__image-box">
          <FigureWithSize
            src={card.mainImage}
            alt={card.itemName}
            size="392px"
            className="menu-detail__main-image"
          />
          <div className="menu-detail__sub-images">
            <FigureWithSize
              src={card.mainImage}
              alt={card.itemName}
              size="72px"
              className="menu-detail__sub-image"
            />
            <FigureWithSize
              src={card.mainImage}
              alt={card.itemName}
              size="72px"
              className="menu-detail__sub-image"
            />
          </div>
        </div>
        <div className="menu-detail__description">
          <div className="menu-detail__menu-info">
            <div className="menu-detail__menu-title">{card.itemName}</div>
            <MenuLabel labelID={card.labelId} />
            <MenuPrices
              className="menu-detail__menu-prices"
              discountPrice={card.discountPrice}
              originalPrice={card.originalPrice}
            />
          </div>
          <div className="menu-detail__additional-info">
            <div className="menu-detail__additional-content">
              <label className="menu-detail__additional-label">적립금</label>
              <span className="menu-detail__additional-text">
                {calculateMileage(card.discountPrice, card.originalPrice)}
              </span>
            </div>
            <div className="menu-detail__additional-content">
              <label className="menu-detail__additional-label">배송정보</label>
              <span className="menu-detail__additional-text">
                서울 경기 새벽 배송, 전국 택배 배송
              </span>
            </div>
            <div className="menu-detail__additional-content">
              <label className="menu-detail__additional-label">배송비</label>
              <span className="menu-detail__additional-text">
                2,500원 (40,000원 이상 구매 시 무료)
              </span>
            </div>
          </div>
          <div className="menu-detail__order">
            <div className="menu-detail__order-info">
              <div className="menu-detail__order-option">
                <figure
                  onClick={() => {
                    if (orderQuantity > 1) setOrderQuantity(orderQuantity - 1);
                  }}
                >
                  <img src={minus} alt="minus" />
                </figure>
                <span className="menu-detail__order-quantity">
                  {orderQuantity}
                </span>
                <figure
                  onClick={() => {
                    if (orderQuantity < card.stock)
                      setOrderQuantity(orderQuantity + 1);
                  }}
                >
                  <img src={plus} alt="plus" />
                </figure>
              </div>
              <div className="menu-detail__order-price">
                <span className="menu-detail__order-text">총 주문금액</span>
                <span className="menu-detail__order-total">
                  {calculateTotalPrice(
                    card.discountPrice,
                    card.originalPrice,
                    orderQuantity
                  )}
                </span>
              </div>
            </div>
            <button className="menu-detail__order-button">
              <img src={order} alt="order" />
            </button>
          </div>
        </div>
      </section>
    </>
  );
}

function calculateMileage(discountprice, originalPrice) {
  if (discountprice) return (discountprice * 0.01) >> 0;
  return (originalPrice * 0.01) >> 0;
}

function calculateTotalPrice(discountprice, originalPrice, quantity) {
  if (discountprice) return discountprice * quantity;
  return originalPrice * quantity;
}
