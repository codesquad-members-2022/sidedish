export type Product = {
  id: number;
  name: string;
  description: string;
  price: number;
  final_price: number;
  discount: IDName[];
  early_morning_delivery: boolean;
  nationwide_delivery: boolean;
  delivery_rate: number;
  free_delivery_threshold: number;
  primary_image: string;
  variant_image: string[];
};
export type IDName = {
  id: number;
  name: string;
};

export interface Category extends IDName {
  subcategories: string[];
}

export type Products = {
  requestDetail: {
    categoryId?: number;
    fullName?: string;
    specialCategoryId?: number;
    per_page?: number;
    sort: string;
  };
  products: Product[];
};
export type Categories = {
  categories: Category[];
};
export type SpecialCategories = {
  specialCategories: IDName[];
};
