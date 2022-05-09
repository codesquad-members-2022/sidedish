import { MenuTitle } from "@/components/atoms/P/MenuTitle";
import { MenuDetail } from "@/components/atoms/P/MenuDetail";
import { MenuPrices } from "@/components/molecules/MenuPrices/MenuPrices";
import "./MenuDescription.scss";

export function MenuDescription({ card }) {
  const { itemName, description, discountPrice, originalPrice } = card;
  return (
    <div className="menu-article__description">
      <MenuTitle menuTitle={itemName} />
      <MenuDetail menuDetail={description} />
      <MenuPrices discountPrice={discountPrice} originalPrice={originalPrice} />
    </div>
  );
}
