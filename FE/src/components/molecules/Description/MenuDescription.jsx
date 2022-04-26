import { MenuTitle } from "@/components/atoms/P/MenuTitle";
import { MenuDetail } from "@/components/atoms/P/MenuDetail";
import { MenuPrices } from "@/components/molecules/MenuPrices/MenuPrices";
import "./MenuDescription.scss";

export function MenuDescription({ card }) {
  const { item_name, description, dc_price, or_price } = card;
  return (
    <div className="menu-article__description">
      <MenuTitle menuTitle={item_name} />
      <MenuDetail menuDetail={description} />
      <MenuPrices discountPrice={dc_price} originalPrice={or_price} />
    </div>
  );
}
