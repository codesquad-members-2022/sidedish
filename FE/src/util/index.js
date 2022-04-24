import { DEFAULT_MEAL_IMAGE } from "constant";

export function setDefaultMealImage(imageUrl) {
  return imageUrl || DEFAULT_MEAL_IMAGE;
}
