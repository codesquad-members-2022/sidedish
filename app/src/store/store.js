const fetchDishData = (type) => {
  return fetch(`https://api.codesquad.kr/onban/${type}`)
    .then((res) => res.json())
    .then((data) => data);
};

const setData = async () => {
  const data = {};

  data.main = await fetchDishData("main");
  data.soup = await fetchDishData("soup");
  data.side = await fetchDishData("side");

  return () => data;
};

const dishData = setData();

export default dishData;
