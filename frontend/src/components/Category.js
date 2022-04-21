import { useState } from "react";
import styled from "styled-components";
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

export const Category = ({ categoryID, categoryName, size }) => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchpProducts = async () => {
      await (await fetch(`/api/products/${categoryID}`)).json();
      setProducts(products.data);
    };
    fetchpProducts();
  }, []);

  return (
    <>
      <CategoryTitle size={size}>{categoryName}</CategoryTitle>
      <ProductCardWrapper size={size}>
        $
        {products.map((productData) => (
          <ProductCard size={size} {...productData}></ProductCard>
        ))}
      </ProductCardWrapper>
      <SlideButtons size={size}></SlideButtons>
    </>
  );
};
