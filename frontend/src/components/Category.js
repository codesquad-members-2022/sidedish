import { useEffect, useState } from "react";
import { CardList } from "./CardList";
import { SIZES } from "../convention";

export const Category = ({ cats }) => {
  const [extended, setExtended] = useState(false);
  return (
    <>
      {cats.map((cat) => (
        <CardList id={cat.id} name={cat.name} size={SIZES.medium}></CardList>
      ))}
    </>
  );
};
