import { PromotionCategory } from "@/components/atoms/List/PromotionCategory";
import { useState } from "react";
import { categoryText } from "@/constant/constant";
import "./PromotionBar.scss";

export function PromotionBar({ setDataID }) {
  const [clickedListID, setClickedListID] = useState(1);
  const categoryList = categoryText.map((category, index) => {
    return createCategoryList(
      category,
      index,
      clickedListID,
      setDataID,
      setClickedListID
    );
  });
  return <nav className="promotion-bar">{categoryList}</nav>;
}

function createCategoryList(
  category,
  index,
  clickedListID,
  setDataID,
  setClickedListID
) {
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
}
