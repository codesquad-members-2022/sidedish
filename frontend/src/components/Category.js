import { useEffect, useState } from "react";
import styled, { css } from "styled-components";
import { ProductCard } from "./ProductCard";

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
  id,
  name,
  size,
  theme = false,
  subcategories = undefined,
}) => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    (async () => {
      let query;
      query = theme ? `api/products/theme_id?=${id}` : `products.json`;
      const res = await (await fetch(query)).json();
      const {
        products: { data },
      } = res;
      setProducts(data);
    })();
  }, [theme, id]);
  console.log(products);
  return (
    <>
      <CategoryTitle size={size}>{name}</CategoryTitle>
      <ProductCardWrapper size={size}>
        {products &&
          products.map((productData, key) => (
            <ProductCard key={key} size={size} {...productData}></ProductCard>
          ))}
      </ProductCardWrapper>
      <SlideButtons size={size}></SlideButtons>
    </>
  );
};
