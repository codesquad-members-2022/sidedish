import { optionalNum, SIZES } from "./types";
import { themeColors } from "./styles/styled";

type tagType = {
  [key: number]: { color: keyof themeColors; order: number };
};
export const tagConvetion: tagType = {
  1: {
    color: "Green",
    order: 1,
  },
  2: {
    color: "Orange",
    order: 2,
  },
};

export const cardGapLength = {
  [SIZES.large]: 24,
  [SIZES.medium]: 24,
  [SIZES.small]: 16,
};

export const thumbnailSize = {
  [SIZES.large]: 411,
  [SIZES.medium]: 302,
  [SIZES.small]: 160,
};

export const cardNumPerPage = {
  [SIZES.large]: 3,
  [SIZES.medium]: 4,
  [SIZES.small]: 5,
};

export const queries = {
  category: (id: number) => `category_id=${id}`,
  specialCategory: (id: number) => `special_category_id=${id}`,
};
export const cardListArea = {
  [SIZES.large]: [1281, 565],
  [SIZES.medium]: [1280, 479],
  [SIZES.small]: [864, 226],
};

export enum Queries {
  categories = "categories",
  specialCategories = "specialCategories",
  products = "products",
  specialProducts = "specialProducts",
  product = "product",
}

export const requestQuery = {
  queries: {
    categories: (id: optionalNum) => `/api/categories`,
    products: (id: optionalNum) => `/api/products?categoryId=${id}`,
    specialCategories: (id: optionalNum) => "/api/specialCategories",
    specialProducts: (id: optionalNum) => `/api/products?specialCategoryId=${id}`,
    product: (id: optionalNum) => `/api/products/${id}`
  },
  makeQuery: (target: keyof typeof Queries, id: optionalNum) => {
    return requestQuery.queries[target](id);
  }
};
