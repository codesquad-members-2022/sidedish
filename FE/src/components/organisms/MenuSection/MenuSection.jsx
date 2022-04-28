import { useState, useEffect } from "react";
import { fetchData } from "@/util/util.js";
import "./MenuSection.scss";
import { MenuArticle } from "@/components/organisms/Article/MenuArticle";

export function MenuSection({ dataName, dataID }) {
  const [cards, setCards] = useState([]);

  useEffect(() => {
    // const DATA_URL = `https://1913e3dd-462b-48a9-899e-03457e73c38c.mock.pstmn.io/api/items/event?${dataName}Id=${dataID}`;
    const totalData = require("../../../fakeDB.json");
    const data = totalData[dataID];
    setCards(data);
    // fetchData(DATA_URL).then((data) => setCards(data));
  }, [dataID]);

  return (
    <section className="menu-section">
      {cards.map((card, index) => (
        <MenuArticle card={card} index={index} key={`article${index}`} />
      ))}
    </section>
  );
}
