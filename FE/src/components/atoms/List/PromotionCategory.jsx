import "./PromotionCategory.scss";

export function PromotionCategory({
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
