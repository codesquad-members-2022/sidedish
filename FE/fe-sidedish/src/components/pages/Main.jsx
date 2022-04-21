import React from "react";
import Card from '../card/Card';
import SmallCard from '../card/SmallCard';
import dishes from '../../data/dishes';

const Main = () => {
  return (
    <>
      {dishes.map(dish => {
        return <Card key={dish.id} dish={dish} />
      })}
      {dishes.map(dish => {
        return <SmallCard key={dish.id} {...dish} />
      })}
    </>
  );
};

export default Main;
