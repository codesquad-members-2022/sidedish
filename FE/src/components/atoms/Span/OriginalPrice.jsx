import "./OriginalPrice.scss";

export function OrigialPrice({ discountPrice, originalPrice }) {
  return (
    <span
      className={
        discountPrice
          ? "menu-article__price-previous"
          : "menu-article__price-now"
      }
    >
      {originalPrice}
    </span>
  );
}
