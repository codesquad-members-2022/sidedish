import styled from "styled-components";
import { useState, useCallback } from "react";
import Category from "./Category.js";
import { Horizon } from "../styles/utils.js";

const MainCategories = ({ data }) => {
  const [isFold, setIsFold] = useState(true);

  const handleMoreBtnClick = useCallback(() => {
    if (isFold) {
      setIsFold(false);
    } else {
      setIsFold(true);
    }
  }, [isFold]);

  return (
    <>
      {data.map((category, index) => (
        <>
          <Category
            dish={category.data}
            category={category.key}
            key={category.key}
            display={index === 0 ? "block" : isFold ? "none" : "block"}
          />
          <Horizon
            display={
              index === data.length - 1 ? "none" : isFold ? "none" : "block"
            }
          />
        </>
      ))}
      <Wrapper>
        <MoreBtn onClick={handleMoreBtnClick}>모든 카테고리 보기</MoreBtn>
      </Wrapper>
    </>
  );
};

const Wrapper = styled.div`
  text-align: center;
`;

const MoreBtn = styled.button`
  box-sizing: border-box;
  padding: 1.6rem 2.4rem;
  margin: 8.5rem auto 5.6rem;
  background-color: transparent;
  font-size: ${({ theme }) => theme.fontSize.large};
  border: 1px solid ${({ theme }) => theme.color.grey4};
  color: ${({ theme }) => theme.color.grey1};
  cursor: pointer;
`;

export default MainCategories;
