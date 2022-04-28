import { DEFAULT_MEAL_IMAGE } from "constants";

export const getMealImage = (imageUrl) => {
  return imageUrl || DEFAULT_MEAL_IMAGE;
};
