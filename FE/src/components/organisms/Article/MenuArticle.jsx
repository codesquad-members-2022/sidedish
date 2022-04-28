import { FigureWithSize } from "@/components/atoms/Figure/FigureWithSize";
import { imageSize } from "@/constant/constant";
import { MenuDescription } from "@/components/molecules/Description/MenuDescription";
import { MenuLabel } from "@/components/atoms/Label/MenuLabel";

export function MenuArticle({ card, index, size }) {
  //[isHoverd, setHovered] = useState(false)
  //Figure로 스티커를 만들어두고display:none >> hover:block     position: absolute margin:30 0 0 150
  return (
    <article className="menu-article" key={`article${index}`}>
      <FigureWithSize
        className="menu-article__figure"
        src={card.main_image}
        alt="menu-image"
        size={size}
      />
      <MenuDescription card={card} />
      <MenuLabel labelID={card.label_id} />
    </article>
  );
}
