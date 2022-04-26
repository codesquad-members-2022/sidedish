import styled from "styled-components";
import Label from "../core/Label";
import { LABEL_ATTRIBUTES } from "../consts/constants";
import DivisionLine from "../core/Line";
import OrderDetail from "./OrderDetail";
import OrderNumber from "./OrderNumber";
import OrderBtn from "./OrderBtn";
import Blank from "../core/Blank";
import { makePriceFormat } from "../util/makePriceFormat";

const PopupOrderContents = ({ title, normalPrice, salePrice, badge }) => {
  const labelList = badge.map((string, ind) => {
    return string === "런칭특가" ? <Label key={ind} {...LABEL_ATTRIBUTES.LAUNCH} /> : <Label key={ind} {...LABEL_ATTRIBUTES.EVENT} />;
  });
  return (
    <>
      <PopupOrderContentsContainer>
        <Title>{title}</Title>
        <NormalPrice>{makePriceFormat(normalPrice)}</NormalPrice>
        <SalePrice>
          {labelList}
          {makePriceFormat(salePrice)}
        </SalePrice>
        <DivisionLine color="#EBEBEB" height="1px" />
        <OrderDetail />
        <DivisionLine color="#EBEBEB" height="1px" />
        <OrderNumber />
        <Blank />
        <OrderBtn />
      </PopupOrderContentsContainer>
    </>
  );
};

const PopupOrderContentsContainer = styled.div`
  display: flex;
  flex-direction: column;
  flex-grow: 1;
`;

const Title = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  padding-bottom: 16px;
`;

const NormalPrice = styled.div`
  font-weight: 500;
  font-size: 14px;
  line-height: 24px;
  color: #bcbcbc;
  padding-bottom: 8px;
`;

const SalePrice = styled.div`
  display: flex;
  align-items: center;
  font-weight: 500;
  font-size: 20px;
  padding-bottom: 24px;
`;

export default PopupOrderContents;
