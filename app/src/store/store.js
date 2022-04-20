const fetchData = (type) => {
  return fetch(`https://api.codesquad.kr/onban/${type}`)
    .then((res) => res.json())
    .then((data) => data);
};

const setData = async () => {
  const data = {};

  data.main = await fetchData("main");
  data.soup = await fetchData("soup");
  data.side = await fetchData("side");

  return data;
};

export default setData;
