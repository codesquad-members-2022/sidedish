import "./Promotion.scss";
import React, { useState } from "react";

export function Promotion() {
  const [cards, setCards] = useState([]);
  return (
    <section className="promotion-section">
      <PromotionHeader />
      <PromotionBar dataName={"best"} setCards={setCards} />
      <PromotionSection cards={cards} />
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

function PromotionBar({ dataName, setCards }) {
  // const [dataID, setDataID] = useState(1);
  return (
    <nav className="promotion-bar">
      <li
        className="promotion-bar__category"
        data_id={1}
        onClick={({ target }) => {
          const dataID = target.getAttribute("data_id");
          // setDataID(dataID);
          updateCards(dataName, dataID, setCards);
        }}
      >
        풍성한 고기 반찬
      </li>
      <li
        className="promotion-bar__category"
        data_id={2}
        onClick={({ target }) => {
          const dataID = target.getAttribute("data_id");
          // setDataID(dataID);
          updateCards(dataName, dataID, setCards);
        }}
      >
        편리한 반찬 세트
      </li>
      <li
        className="promotion-bar__category"
        data_id={3}
        onClick={({ target }) => {
          const dataID = target.getAttribute("data_id");
          // setDataID(dataID);
          updateCards(dataName, dataID, setCards);
        }}
      >
        맛있는 제철 요리
      </li>
      <li
        className="promotion-bar__category"
        data_id={4}
        onClick={({ target }) => {
          const dataID = target.getAttribute("data_id");
          // setDataID(dataID);
          updateCards(dataName, dataID, setCards);
        }}
      >
        우리 아이 영양 반찬
      </li>
    </nav>
  );
}

function updateCards(dataName, dataID, setCards) {
  async function fetchData() {
    const DATA_URL = `https://1913e3dd-462b-48a9-899e-03457e73c38c.mock.pstmn.io/api/item?${dataName}_id=${dataID}`;
    const response = await fetch(DATA_URL);
    const data = await response.json();
    setCards(data);
  }
  fetchData();
}

function PromotionSection({ cards }) {
  const menuArticles = cards.map((card, index) => {
    return (
      <article className="menu-article" key={`article${index}`}>
        <figure className="menu-article__figure">
          <img src={card.main_image}></img>
        </figure>
        <div className="menu-article__description">
          <p className="menu-article__title">{card.item_name}</p>
          <p className="menu-article__detail">{card.description}</p>
          <div className="menu-article__prices">
            {card.dc_price && (
              <span className="menu-article__price-now">{card.dc_price}</span>
            )}
            <span
              className={
                card.dc_price
                  ? "menu-article__price-previous"
                  : "menu-article__price-now"
              }
            >
              {card.or_price}
            </span>
          </div>
        </div>
        <Label labelID={card.label_id} />
      </article>
    );
  });

  return <section className="menu-section">{menuArticles}</section>;
}

function Label({ labelID }) {
  if (labelID === 1) {
    return <label className="menu-article__label1">런칭특가</label>;
  } else if (labelID === 2) {
    return <label className="menu-article__label2">이벤트특가</label>;
  } else if (labelID === 3) {
    return "";
  }
}
