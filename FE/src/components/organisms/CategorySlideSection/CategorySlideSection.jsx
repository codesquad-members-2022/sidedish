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
    const DATA_URL = `http://3.39.7.35:8080/api/items?${dataName}Id=${dataID}`;
    fetchData(DATA_URL).then((data) => {
      setData(data);
    });
    setPageIndex(0);
  }, [dataID]);
  useEffect(() => {
    setMaxIndex((data.length / 4) >> 0);
    const startIndex = 0 + pageIndex * 4;
    const selectedData = data.slice(startIndex, startIndex + 4);
    console.log(selectedData);
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
