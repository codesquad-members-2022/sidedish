import { FigureWithSize } from "@/components/atoms/Figure/FigureWithSize";
import { imageSize } from "@/constant/constant";
import { MenuDescription } from "@/components/molecules/Description/MenuDescription";
import { MenuLabel } from "@/components/atoms/Label/MenuLabel";

export function MenuArticle({ card, index }) {
  return (
    <article className="menu-article" key={`article${index}`}>
      <FigureWithSize
        className="menu-article__figure"
        src={card.main_image}
        alt="menu-image"
        size={imageSize.promotion}
      />
      <MenuDescription card={card} />
      <MenuLabel labelID={card.label_id} />
    </article>
  );
}
