import List from "./List";
import Card from "../UI/Card";
import "./Tab.css";
import React, { useEffect, useState } from "react";

const Tab = () => {
  const [infor, setInfor] = useState([
    { id: 1, title: "풍성한 고기반찬" },
    { id: 2, title: "편리한 반찬세트" },
    { id: 3, title: "맛있는 제철요리" },
    { id: 4, title: "우리 아이 영향 반찬" },
  ]);

  const [cards, setCards] = useState([]);
  const [activeTab, setActiveTab] = useState(1);

  useEffect(() => {
    fetch("https://api.codesquad.kr/onban/main")
      .then((res) => res.json())
      .then((data) => setCards(data.body[activeTab]));
  });
  const onClickHandler = (event) => {
    setActiveTab(event.target.id);
  };

  return (
    <div>
      <ul className="tab-list">
        {infor.map((v) => {
          return (
            <li
              id={v.id}
              key={v.id}
              className={v.id.toString() === activeTab ? "active" : ""}
              onClick={onClickHandler}
            >
              {v.title}
            </li>
          );
        })}
      </ul>

      <div className="card-wrapper">
        <Card
          key={cards.detail_hash}
          image={cards.image}
          alt={cards.alt}
          title={cards.title}
          description={cards.description}
          s_price={cards.s_price}
          n_price={cards.n_price}
          badge={cards.badge}
        />
      </div>
    </div>
  );
};

export default Tab;
