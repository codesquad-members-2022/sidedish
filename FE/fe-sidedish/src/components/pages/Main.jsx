import React from "react";
import Card from '../card/Card';
import SmallCard from '../card/SmallCard';
import dishes from '../../data/dishes';

const Main = () => {
  return (
    <>
      {dishes.map((dish, index) => {
        return <Card key={index} dish={dish} />
      })}
      {dishes.map((dish, index) => {
        return <SmallCard key={index} {...dish} />
      })}
    </>
  );
};

export default Main;
