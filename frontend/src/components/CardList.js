import styled, { css } from "styled-components";
import { ProductCard } from "./ProductCard";
import { useEffect } from "react";
import {
  useCategories,
  useFetch,
  useProducts,
  useSpecialCategories,
} from "../fetcher";

const CategoryTitle = styled.span`
  ${(props) =>
    props.size === "large" &&
    css`
      display: none;
    `}

  ${(props) =>
    props.size === "medium" &&
    css`
      line-height: 38px;
      font-size: 24px;
    `}

  ${(props) =>
    props.size === "small" &&
    css`
      line-height: 30px;
      font-size: 20px;
    `}
`;

const ProductCardWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 34px;
  ${(props) =>
    props.size === "large" &&
    css`
      width: 1281px;
      height: 565px;
    `}

  ${(props) =>
    props.size === "medium" &&
    css`
      width: 1280px;
      height: 479px;
    `}

  ${(props) =>
    props.size === "small" &&
    css`
      width: 864px;
      height: 226px;
    `}
`;

const SlideButtons = styled.div``;

export const CardList = ({ size, id, special = false }) => {
  const categoryData = useFetch(id, special);
  return (
    <>
      {categoryData && (
        <>
          {!special && (
            <CategoryTitle size={size}>
              {categoryData["full_name"]}
            </CategoryTitle>
          )}
          <ProductCardWrapper size={size}>
            {categoryData.products.map((product) => (
              <ProductCard
                key={product.id}
                size={size}
                {...product}
              ></ProductCard>
            ))}
          </ProductCardWrapper>
        </>
      )}
    </>
  );
};
