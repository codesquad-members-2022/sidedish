import "./Promotion.scss";
import React, { useState, useEffect } from "react";

export function Promotion() {
  const [dataID, setDataID] = useState(1);
  return (
    <section className="promotion-section">
      <PromotionHeader />
      <PromotionBar setDataID={setDataID} />
      <PromotionSection dataName={"best"} dataID={dataID} />
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

function PromotionCategory({
  index,
  className,
  category,
  setDataID,
  setClickedListID,
}) {
  return (
    <li
      data_id={index + 1}
      className={className}
      onClick={({ target }) => {
        const promotionBarID = target.getAttribute("data_id");
        setClickedListID(promotionBarID);
        setDataID(promotionBarID);
      }}
    >
      {category}
    </li>
  );
}

const categoryText = [
  "풍성한 고기 반찬",
  "편리한 반찬 세트",
  "맛있는 제철 요리",
  "우리 아이 영양 반찬",
];

function PromotionBar({ setDataID }) {
  const [clickedListID, setClickedListID] = useState(1);
  const categoryList = categoryText.map((category, index) => {
    /* 목서버 API에서 받아온 데이터 ID가 1 ~ 4여서,
    초기값을 1로 두고 key값으로 index를 사용했습니다. 추후에 수정하겠습니다.*/
    const className =
      index + 1 === Number(clickedListID)
        ? "promotion-bar__category is-clicked"
        : "promotion-bar__category";
    return (
      <PromotionCategory
        key={`category${index}`}
        index={index}
        className={className}
        category={category}
        setDataID={setDataID}
        setClickedListID={setClickedListID}
      />
    );
  });
  return <nav className="promotion-bar">{categoryList}</nav>;
}

function PromotionSection({ dataName, dataID }) {
  const [cards, setCards] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const DATA_URL = `https://1913e3dd-462b-48a9-899e-03457e73c38c.mock.pstmn.io/api/item/best?${dataName}_id=${dataID}`;
      const response = await fetch(DATA_URL);
      const data = await response.json();
      setCards(data);
    }
    fetchData();
  }, [dataID]);

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
