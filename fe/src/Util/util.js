const getPriceType = (price, discountRate) => {
  const calculatedPrice = !discountRate
    ? parseInt(price, 10)
    : parseInt(price * (1 - discountRate / 100), 10);

  const standardizedPrice = `${String(calculatedPrice).slice(0, -3)},${String(
    calculatedPrice
  ).slice(-3)}원`;

  return standardizedPrice[0] !== ","
    ? standardizedPrice
    : standardizedPrice.slice(1);
};

export default getPriceType;
