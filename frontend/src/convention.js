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

export const SIZES = {
  large: "large",
  medium: "medium",
  small: "small",
};
export const queries = {
  category: (id) => `category_id=${id}`,
  specialCategory: (id) => `special_category_id=${id}`,
};
export const cardListArea = {
  large: [1281, 565],
  medium: [1280, 479],
  small: [864, 226],
};
export const Queries = {
  categories: "categories",
  specialCategories: "specialCategories",
  products: "products",
  product: "product",
};

export const requestQuery = {
  queries: {
    categories: (id = undefined) => "/mocks/categories.json",
    specialCategories: (id = undefined) => "/mocks/specialCategories.json",
    product: (id = undefined) => "/mocks/product.json",
    products: (id = undefined) => "/mocks/categoryProducts.json",
  },
  makeQuery: (target, id = undefined) => {
    return requestQuery.queries[target](id);
  },
};
