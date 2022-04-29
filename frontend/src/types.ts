export type Product = {
  id: number;
  name: string;
  description: string;
  basePrice: number;
  finalPrice: number;
  discounts: IDName[];
  mileage: number;
  stock: number;
  earlyMorningDelivery: boolean;
  nationwideDelivery: boolean;
  deliveryRate: number;
  freeDeliveryThreshold: number;
  primaryImage: string;
  variantImages: string[];
};
export type IDName = {
  id: number;
  name: string;
};

export interface Category extends IDName {
  description: string;
  subcategories: IDName[];
}

export type Products = {
  requestDetail: {
    categoryId?: number;
    specialCategoryId?: number;
    page?: number;
    pageSize?: number;
    sort?: string;
  };
  products: Product[];
};
export type Categories = {
  categories: Category[];
};
export type SpecialCategories = {
  specialCategories: IDName[];
};

export enum SIZES {
  large = "large",
  medium = "medium",
  small = "small",
}

export type optionalNum = number | undefined;
export type SizeProp = {
  size: keyof typeof SIZES;
};
