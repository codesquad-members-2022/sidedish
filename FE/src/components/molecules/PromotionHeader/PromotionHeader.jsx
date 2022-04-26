import { PromotionLabel } from "@/components/atoms/Label/PromotionLabel.jsx";
import { PromotionTitle } from "@/components/atoms/Title/PromotionTitle.jsx";
import "./PromotionHeader.scss";

export function PromotionHeader() {
  return (
    <div className="promotion-header">
      <PromotionLabel />
      <PromotionTitle />
    </div>
  );
}
