const priceToString = (price) => {
  return typeof price === Number
    ? price.toLocaleString() + "원"
    : Number(price).toLocaleString() + "원";
};

const fetch_config = {
  headers: {
    Origin: "http://15.165.204.34:8080/",
    mode: "no-cors",
    Accept: "application/json",
  },
};

const myfetch = (url) => {
  return fetch(url, fetch_config).then((res) => res.json());
};
export { priceToString, fetch_config, myfetch };
