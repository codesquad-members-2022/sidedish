import React from "react";
import Card from '../card/Card';
import SmallCard from '../card/SmallCard';
import { dish3 } from '../../data/dishes';

const Main = () => {
  return (
    <>
      {dish3.map(dish => {
        return <Card key={dish.menuId} dish={dish} />
      })}
      {dish3.map(dish => {
        return <SmallCard key={dish.menuId} {...dish} />
      })}
    </>
  );
};

export default Main;
