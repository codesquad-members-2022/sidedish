import styled from "styled-components";
import { useEffect, useState } from "react";
import { Category } from "./Category";

const Wrapper = styled.div`
  height: 786px;
`;
export const BestProduct = ({ themes }) => {
  console.log(themes);
  const [selected, setSelected] = useState(0);
  useEffect(() => {});
  return (
    <Wrapper>
      <ul></ul>
      <nav>
        <ul></ul>
      </nav>
      <span></span>
      <span></span>
    </Wrapper>
  );
};
