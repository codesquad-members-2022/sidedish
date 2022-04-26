export const makePriceFormat = (priceString) => {
  return priceString ? Number(priceString).toLocaleString() + "원" : "";
};
