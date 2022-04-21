import React from "react";
import Card from '../card/Card';
import dishes from '../../data/dishes';

const Main = () => {
  return (
    <>
      {dishes.map((dish, index) => {
        return <Card key={index} dish={dish} />
      })}
    </>
  );
};

export default Main;
