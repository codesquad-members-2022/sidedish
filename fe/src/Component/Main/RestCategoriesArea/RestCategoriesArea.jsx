import { useState } from "react";
import BtnShowAndHideArea from "./BtnShowAndHideArea";
import RestCategories from "./RestCategories/RestCategories";

const RestCategoriesArea = () => {
  const [isShow, setIsShow] = useState(false);

  return (
    <>
      {isShow && <RestCategories />}
      <BtnShowAndHideArea state={{ isShow, setIsShow }} />
    </>
  );
};

export default RestCategoriesArea;
