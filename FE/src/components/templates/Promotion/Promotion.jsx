import { useState } from "react";
import { PromotionHeader } from "@/components/molecules/PromotionHeader/PromotionHeader.jsx";
import { PromotionBar } from "@/components/molecules/PromotionBar/PromotionBar.jsx";
import { MenuSection } from "@/components/organisms/MenuSection/MenuSection.jsx";
import { imageSize } from "@/constant/constant";

export function Promotion() {
  const [dataID, setDataID] = useState(1);

  return (
    <section className="promotion-section">
      <PromotionHeader />
      <PromotionBar setDataID={setDataID} />
      <MenuSection dataName={"best"} dataID={dataID} size={imageSize.promotion} />
    </section>
  );
}
