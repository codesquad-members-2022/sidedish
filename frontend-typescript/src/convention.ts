export const tagConvetion = {
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
  large: 24,
  medium: 24,
  small: 16,
};

export const thumbnailSize = {
  large: 411,
  medium: 302,
  small: 160,
};

export const cardNumPerPage = {
  large: 3,
  medium: 4,
  small: 5,
};

export enum SIZES {
  large = "large",
  medium = "medium",
  small = "small",
}
export const queries = {
  category: (id: number) => `category_id=${id}`,
  specialCategory: (id: number) => `special_category_id=${id}`,
};
export const cardListArea = {
  large: [1281, 565],
  medium: [1280, 479],
  small: [864, 226],
};

export enum Queries {
  categories = "categories",
  specialCategories = "specialCategories",
  products = "products",
  product = "product",
}

export const requestQuery = {
  queries: {
    categories: (id = undefined) => "/mocks/categories.json",
    specialCategories: (id = undefined) => "/mocks/specialCategories.json",
    product: (id = undefined) => "/mocks/product.json",
    products: (id = undefined) => "/mocks/categoryProducts.json",
  },
  makeQuery: (target: keyof typeof Queries, id = undefined) => {
    return requestQuery.queries[target](id);
  },
};
