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

export const cardListArea = {
  large: [1281, 565],
  medium: [1280, 479],
  small: [864, 226]
};

export const Queries = {
  categories: "categories",
  products: "products",
  specialCategories: "specialCategories",
  specialProducts: "specialProducts",
  product: "product"
};

export const requestQuery = {
  queries: {
    categories: (id = undefined) => `/api/categories`,
    products: (id = undefined) => `/api/products?categoryId=${id}`,
    specialCategories: (id = undefined) => "/api/themes",
    specialProducts: (id) => `/api/products?themeId=${id}`,
    product: (id = undefined) => "/mocks/product.json"
  },
  makeQuery: (target, id) => {
    return requestQuery.queries[target](id);
  }
};
