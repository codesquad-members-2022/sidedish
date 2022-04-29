import { useState, useEffect } from "react";
import { fetchData } from "@/util/util.js";
import "./MenuSection.scss";
import { MenuArticle } from "@/components/organisms/Article/MenuArticle";

export function MenuSection({ dataName, dataID, size }) {
  const [cards, setCards] = useState([]);

  useEffect(() => {
    const DATA_URL = `http://3.39.7.35:8080/api/items/event?${dataName}Id=${dataID}`;
    fetchData(DATA_URL).then((data) => setCards(data));
  }, [dataID]);
  return (
    <section className="menu-section">
      {cards.map((card, index) => (
        <MenuArticle
          card={card}
          index={index}
          key={`article${index}`}
          size={size}
        />
      ))}
    </section>
  );
}
