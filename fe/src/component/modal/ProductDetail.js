import React from "react";
import styled from "styled-components";
import DetailImage from "./DetailImage";
import DetailInfo from "./DetailInfo";

const ProductDetail = styled.div`
  display: flex;
  justify-content: space-between;
  height: 500px;
  border-bottom: 1px solid black;
`;

const ProductDetails = () => {
  return (
    <ProductDetail>
      <DetailImage />
      <DetailInfo />
    </ProductDetail>
  );
};

export default ProductDetails;
