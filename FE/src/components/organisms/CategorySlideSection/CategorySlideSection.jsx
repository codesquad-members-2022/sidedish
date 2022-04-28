import { useState, useEffect } from "react";
import { fetchData } from "@/util/util.js";
import "./CategorySlideSection.scss";
import { MenuArticle } from "@/components/organisms/Article/MenuArticle";

export function CategorySlideSection({
  dataName,
  dataID,
  size,
  pageIndex,
  setPageIndex,
  setMaxIndex,
}) {
  const [cards, setCards] = useState([]);
  const [data, setData] = useState([]);

  useEffect(() => {
    // const DATA_URL = `https://1913e3dd-462b-48a9-899e-03457e73c38c.mock.pstmn.io/api/items/event?${dataName}Id=${dataID}`;
    // fetchData(DATA_URL).then((data) => setCards(data));
    const totalData = require(`../../../${dataName}.json`);
    const categoryData = totalData[dataID];
    setData(categoryData);
    setPageIndex(0);
    setMaxIndex((categoryData.length / 4) >> 0);
  }, [dataID]);

  useEffect(() => {
    const startIndex = 0 + pageIndex * 4;
    const selectedData = data.slice(startIndex, startIndex + 4);
    setCards(selectedData);
  }, [pageIndex]);

  return (
    <section className="category-slide-section">
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
