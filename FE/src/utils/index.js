import { DEFAULT_MEAL_IMAGE } from "constants";

export function setDefaultMealImage(imageUrl) {
  return imageUrl || DEFAULT_MEAL_IMAGE;
}
