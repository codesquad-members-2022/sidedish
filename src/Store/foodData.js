import { fetchData } from '../util/fetchApi';

export const FOOD_DATA = {};

export async function setfoodData() {
  FOOD_DATA.main = await fetchData('main');
  FOOD_DATA.soup = await fetchData('soup');
  FOOD_DATA.side = await fetchData('side');
}
