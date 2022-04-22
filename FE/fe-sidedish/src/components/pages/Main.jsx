import React from "react";
import Category from '../category/Category';
import { dish10 } from '../../data/dishes';

const Main = () => {
  return (
    <>
      <Category { ...dish10 } />
    </>
  );
};

export default Main;
