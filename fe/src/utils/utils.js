const priceToString = (price) => {
  return typeof price === Number
    ? price.toLocaleString() + "원"
    : Number(price).toLocaleString() + "원";
};

export { priceToString };
