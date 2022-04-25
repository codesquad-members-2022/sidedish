import { DEFAULT_MEAL_IMAGE } from "constants";

export function getMealImage(imageUrl) {
  return imageUrl || DEFAULT_MEAL_IMAGE;
}
