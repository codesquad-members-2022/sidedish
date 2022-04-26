import { labelTitles } from "@/constant/constant";
import "./MenuLabel.scss";

export function MenuLabel({ labelID }) {
  if (labelID > labelTitles.length) return "";
  return (
    <label className={`menu-article__label${labelID}`}>
      {labelTitles[labelID - 1]}
    </label>
  );
}
