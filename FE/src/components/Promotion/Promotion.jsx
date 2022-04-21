import "./Promotion.scss";
import React, { useState } from "react";

export function Promotion() {
  return (
    <section className="promotion-section">
      <PromotionHeader />
      <PromotionBar />
      <MenuSection className="menu-section" />
    </section>
  );
}

function PromotionHeader() {
  return (
    <div className="promotion-header">
      <label className="promotion-header__label">기획전</label>
      <h2 className="promotion-header__title">
        한 번 주문하면 두 번 반하는 반찬
      </h2>
    </div>
  );
}

function PromotionBar() {
  return (
    <nav className="promotion-bar">
      <li className="promotion-bar__category">풍성한 고기 반찬</li>
      <li className="promotion-bar__category">편리한 반찬 세트</li>
      <li className="promotion-bar__category">맛있는 제철 요리</li>
      <li className="promotion-bar__category">우리 아이 영양 반찬</li>
    </nav>
  );
}

function MenuSection() {
  return (
    <section className="menu-section">
      <article className="menu-article">
        <figure className="menu-article__figure">
          <img
            width="411px"
            height="411px"
            src="https://user-images.githubusercontent.com/92678171/164159697-1c8ef07a-141e-464b-b4e5-bb73e2119535.png"
          ></img>
        </figure>
        <p className="menu-article__title">오리 주물럭</p>
        <p className="menu-article__detail">맛있는 오리고기와 오징어의 조합</p>
        <div className="menu-article__prices">
          <span className="menu-article__price-now">12640</span>
          <span className="menu-article__price-previous">15800</span>
        </div>
        <label className="menu-article__label">런칭특가</label>
      </article>
    </section>
  );
}
