import React from "react";
import Exhibition from "../exhibition/Exhibition";
import Category from "../category/Category";
import { dish10 } from "../../data/dishes";

const Main = () => {
  return (
    <>
      <Exhibition />
      <Category {...dish10} />
    </>
  );
};

export default Main;
