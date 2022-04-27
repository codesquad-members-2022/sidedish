import React from "react";
import Exhibition from "../exhibition/Exhibition";
import Category from "../category/Category";
import { dish10 } from "../../data/dishes";
import { CARD_SIZE } from '../../constants/card';

const Main = () => {
  return (
    <>
      <Exhibition />
      <Category cardSize={CARD_SIZE.MEDIUM} {...dish10} />
    </>
  );
};

export default Main;
