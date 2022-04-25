export const makePriceFormat = (priceString) => {
  return (Number(priceString) || "").toLocaleString();
};
