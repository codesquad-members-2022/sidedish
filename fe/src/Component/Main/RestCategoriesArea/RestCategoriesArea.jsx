import { useState } from "react";
import BtnShowAndHideArea from "./BtnShowAndHideArea";

const RestCategories = () => {};

const RestCategoriesArea = () => {
  const [showing, setShowing] = useState(false);

  return (
    <>
      <RestCategories />
      <BtnShowAndHideArea state={{ showing, setShowing }} />
    </>
  );
};

export default RestCategoriesArea;
