import styled from 'styled-components';

const StyledSpecialPromotion = styled.div`
  width: 1280px;
  margin: 0 auto;
`;

const SpecialPromotionIcon = styled.img`
  margin-right: 16px;
`;

const SpecialPromotionTitle = styled.h2`
  display: flex;
  align-items: center;
  width: 615px;
  padding: 56px 0px 24px 0px;

  p {
    font-weight: 700;
    font-size: 40px;
  }
`;

const Tab = styled.nav`
  width: 692px;

  ul {
    display: flex;
    align-items: center;
  }

  li {
    margin-right: 32px;
    padding-bottom: 16px;
    font-weight: 500;
    font-size: 20px;
  }

  li:hover {
    cursor: pointer;
  }
`;

const BestSideDishContainer = styled.div`
  padding: 34px 0px 56px 0px;
  margin-bottom: 56px;

  &::before,
  &::after {
    content: '';
    display: block;
    position: absolute;
    left: 0;
    width: 100%;
    height: 1px;
    background-color: #ebebeb;
  }

  &::before {
    margin-top: -34px;
  }

  &::after {
    margin-top: 56px;
  }
`;

const BestSideDishList = styled.ul`
  display: flex;
  justify-content: flex-start;
`;

export {
  StyledSpecialPromotion,
  SpecialPromotionIcon,
  SpecialPromotionTitle,
  Tab,
  BestSideDishContainer,
  BestSideDishList,
};
