import styled, { css } from "styled-components";
import { ProductCard } from "./ProductCard-temp";

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

export const Category = ({
  category_id,
  size,
  data,
  theme = false,
  name = null,
  subcategories = undefined,
}) => {
  return (
    <>
      {name && <CategoryTitle size={size}>{name}</CategoryTitle>}
      <ProductCardWrapper size={size}>
        {data.map((productData) => (
          <ProductCard
            key={productData.id}
            size={size}
            productData={productData}
          ></ProductCard>
        ))}
      </ProductCardWrapper>
    </>
  );
};
