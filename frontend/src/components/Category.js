import { useState } from "react";
import { Carousel } from "./Carousel";
import { SIZES } from "../convention";
import styled from "styled-components";
import { HorizontalLine } from "./HorizontalLine";

const ExtendingButton = styled.div`
  padding: 16px 24px;
  border: 1px solid #ebebeb;
  margin-bottom: 56px;
`;

const CarouselWrapper = styled.div`
  position: relative;
  padding: 56px 80px;
`

export const Category = ({ cats }) => {
  const [extended, setExtended] = useState(false);
  const displayTargetCategories = extended ? cats : [cats[0]];

  return (
    <>
      {displayTargetCategories.map((cat) => (
        <CarouselWrapper key={cat.id}>
          <HorizontalLine  position={0} color={"Grey4"} />
          <Carousel id={cat.id} name={cat.name} size={SIZES.medium} />
        </CarouselWrapper>
      ))}
      <ExtendingButton onClick={() => setExtended(!extended)}>
        {extended ? "확장 카테고리 접기" : "모든 카테고리 보기"}
      </ExtendingButton>
    </>
  );
};
