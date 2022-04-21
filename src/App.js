import React, { useEffect, useState } from 'react';

import { fetchData } from './utility/util';
import Header from './Header';
import MainCard from './MainCard';
import SubCard from './SubCard';

const App = () => {
  const [mainCardData, setMainCardData] = useState([]);
  const [mainDishData, setMainDishData] = useState([]);
  const [sideDishData, setSideDishData] = useState([]);
  const [soupData, setSoupData] = useState([]);

  const getSideDishData = async (url, setData) => {
    const response = await fetchData(url);
    setData(response.data);
  };

  useEffect(() => {
    const mainCardUrl = 'data/mainCard.json';
    const mainDishUrl = 'data/mainDish.json';
    const sideDishUrl = 'data/sideDish.json';
    const soupUrl = 'data/soup.json';

    getSideDishData(mainCardUrl, setMainCardData);
    getSideDishData(mainDishUrl, setMainDishData);
    getSideDishData(sideDishUrl, setSideDishData);
    getSideDishData(soupUrl, setSoupData);
  }, []);

  return (
    <>
      <Header />
      <MainCard mainCardData={mainCardData} />
      <SubCard mainCardData={mainCardData} />
    </>
  );
};

export default App;
