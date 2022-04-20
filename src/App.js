import React, { useEffect, useState } from 'react';
import Header from './Header';
import MainCard from './MainCard';
import { fetchData } from './utility/util';

const App = () => {
  const [mainCardData, setMainCardData] = useState([]);
  const [mainDishData, setMainDishData] = useState([]);
  const [sideDishData, setSideDishData] = useState([]);
  const [soupData, setSoupData] = useState([]);

  useEffect(() => {
    const mainCardUrl = 'data/mainCard.json';
    const mainDishUrl = 'data/mainDish.json';
    const sideDishUrl = 'data/sideDish.json';
    const soupUrl = 'data/soup.json';

    const getData = async (url, setData) => {
      const response = await fetchData(url);
      setData(response.data);
    };

    getData(mainCardUrl, setMainCardData);
    getData(mainDishUrl, setMainDishData);
    getData(sideDishUrl, setSideDishData);
    getData(soupUrl, setSoupData);
  }, [setMainCardData, setMainDishData, setSideDishData, setSoupData]);

  return (
    <>
      <Header />
      <MainCard data={(mainCardData, mainDishData)} />
    </>
  );
};

export default App;
