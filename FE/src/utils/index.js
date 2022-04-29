import { DEFAULT_MEAL_IMAGE } from "constants";

export const getMealImage = (imageUrl) => {
  return imageUrl || DEFAULT_MEAL_IMAGE;
};

export const changeNumberToKoreanLocale = (number) => `${number.toLocaleString("ko-KR")}원`;

export const showOriginalPrice = (originalPrice, fixedPrice) =>
  originalPrice === fixedPrice ? <></> : <span>{changeNumberToKoreanLocale(originalPrice)}</span>;
