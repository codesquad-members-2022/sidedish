import { useState } from "react";
import { Carousel } from "./Carousel";
import { SIZES } from "../convention";
import styled from "styled-components";

const ExtendingButton = styled.div`
  padding: 16px 24px;
  border: 1px solid #ebebeb;
  margin-bottom: 56px;
`;

export const Category = ({ cats }) => {
  const [extended, setExtended] = useState(false);
  const displayTargetCategories = extended ? cats : [cats[0]];

  return (
    <>
      {displayTargetCategories.map((cat) => (
        <Carousel key={cat.id} id={cat.id} name={cat.name} size={SIZES.medium}></Carousel>
      ))}
      <ExtendingButton onClick={() => setExtended(!extended)}>
        {extended ? "확장 카테고리 접기" : "모든 카테고리 보기"}
      </ExtendingButton>
    </>
  );
};
