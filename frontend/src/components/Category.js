import { useState } from "react";
import { Carousel } from "./Carousel";
import { SIZES } from "../convention";

export const Category = ({ cats }) => {
  const [extended, setExtended] = useState(false);

  return (
    <>
      {cats.map((cat) => (
        <Carousel key={cat.id} id={cat.id} name={cat.name} size={SIZES.medium}></Carousel>
      ))}
    </>
  );
};
