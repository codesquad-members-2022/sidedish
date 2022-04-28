import { useState } from "react";
import { FigureWithSize } from "@/components/atoms/Figure/FigureWithSize";
import { imageSize } from "@/constant/constant";
import { MenuDescription } from "@/components/molecules/Description/MenuDescription";
import { MenuLabel } from "@/components/atoms/Label/MenuLabel";
import { DeliveryLabel } from "@/components/atoms/Label/DeliveryLabel";
import "./MenuArticle.scss";
import { ArticleFigure } from "@/components/atoms/Figure/ArticleFigure";

export function MenuArticle({ card, index, size }) {
  const [isHovered, setIsHovered] = useState(false);

  return (
    <article className="menu-article" key={`article${index}`}>
      <DeliveryLabel
        className="menu-article__delivery"
        deliveryID={card.delivery_id}
        isHovered={isHovered}
        setIsHovered={setIsHovered}
      />
      <ArticleFigure
        className="menu-article__figure"
        src={card.main_image}
        alt="menu-image"
        size={size}
        setIsHovered={setIsHovered}
      />
      <MenuDescription card={card} />
      <MenuLabel labelID={card.label_id} />
    </article>
  );
}
