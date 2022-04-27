import styled from 'styled-components';

const EVENT = '이벤트특가';
const SMALL = 'small';

const Wrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 3000;
`;

const Modal = styled.div`
  width: 960px;
  position: relative;
  background-color: ${({ theme }) => theme.color.white};
  border: 2px solid ${({ theme }) => theme.color.black};
  z-index: 3100;
`;

const CloseButton = styled.button`
  position: absolute;
  top: 32px;
  right: 48px;
  color: ${({ theme }) => theme.color.grey2};
`;

const Background = styled.div`
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: ${({ theme }) => theme.color.black};
  opacity: 0.3;
  z-index: 3000;
`;

const HorizontalLine = styled.div`
  height: ${({ size }) => `${size}px`};
  background-color: ${({ color, theme }) => theme.color[color]};
`;

const FloatContainer = styled.div`
  float: ${({ direction }) => direction};
  width: ${({ direction }) => (direction === 'right' ? '438px' : '')};
`;

const ProductDetailContainer = styled.div`
  padding: 72px 48px 48px;
  ::after {
    content: '';
    display: block;
    clear: both;
  }
`;

const RelateProductContainer = styled.div`
  padding: 48px 48px 64px;
`;

const ImageList = styled.ul`
  margin: 8px 0 0;
  display: flex;
  gap: 8px;
`;

const Image = styled.img`
  display: block;
  width: ${({ size }) => `${size}px`};
  height: ${({ size }) => `${size}px`};
  border: ${({ isMain, theme }) => (isMain ? `1px solid ${theme.color.black}` : 'none')};
  cursor: pointer;
`;

const ProductTitle = styled.h4`
  margin: 0 0 16px;
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
`;

const ProductPrice = styled.div`
  font-weight: ${({ theme }) => theme.fontWeight.medium};
`;

const OriginalPrice = styled.div`
  margin: 0 0 8px;
  font-size: ${({ theme }) => theme.fontSize.small};
  color: ${({ theme }) => theme.color.grey3};
`;

const SaledPrice = styled.span`
  font-size: ${({ theme }) => theme.fontSize.large};
  display: inline-block;
  transform: translateY(2px);
`;

const Badge = styled.span`
  padding: 6px 16px;
  margin: 0 8px 0 0;
  display: inline-block;
  color: ${({ theme }) => theme.color.white};
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
  text-align: center;
  border-radius: 30px;
  background-color: ${({ type, theme }) =>
    type === EVENT ? theme.color.green : theme.color.orange};
`;

const ProductInfoList = styled.ul`
  margin: 24px 0;
  padding: 16px 0 8px;
  border-top: 1px solid ${({ theme }) => theme.color.grey4};
  border-bottom: 1px solid ${({ theme }) => theme.color.grey4};
  li {
    margin: 0 0 8px;
    font-size: ${({ theme }) => theme.fontSize.xSmall};
    span:first-child {
      margin: 0 16px 0 0;
      display: inline-block;
      width: 60px;
      color: ${({ theme }) => theme.color.grey2};
    }
  }
`;

const PriceOrderContainer = styled(FloatContainer)`
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
`;

const TotalAmount = styled.div`
  display: flex;
  justify-content: flex-start;
  gap: 12px;
`;

const TotalCostList = styled.ul`
  text-align: right;
  span {
    display: inline-block;
    width: 100px;
  }
`;

const CostItem = styled.li`
  margin: 0 0 4px;
  display: flex;
  align-items: center;
`;

const CostName = styled.span`
  font-size: ${({ size, theme }) =>
    size === SMALL ? theme.fontSize.small : theme.fontSize.medium};
  color: ${({ theme }) => theme.color.grey2};
`;

const CostPrice = styled.span`
  font-size: ${({ size, theme }) =>
    size === SMALL ? theme.fontSize.medium : theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
`;

const IconButton = styled.button`
  width: 24px;
  height: 24px;
  overflow: hidden;
`;

const SubmitButton = styled.button`
  margin: 64px 0 0;
  width: 438px;
  height: 56px;
  color: ${({ theme }) => theme.color.white};
  cursor: ${({ orderable }) => (orderable ? 'pointer' : 'default')};
  background-color: ${({ orderable, theme }) =>
    orderable ? theme.color.black : theme.color.grey3};
  :hover {
    background-color: ${({ orderable, theme }) =>
      orderable ? theme.color.grey1 : theme.color.grey3};
  }
`;

export {
  Wrapper,
  Modal,
  CloseButton,
  Background,
  HorizontalLine,
  FloatContainer,
  ProductDetailContainer,
  RelateProductContainer,
  ImageList,
  Image,
  ProductTitle,
  ProductPrice,
  OriginalPrice,
  SaledPrice,
  Badge,
  ProductInfoList,
  PriceOrderContainer,
  TotalAmount,
  TotalCostList,
  CostItem,
  CostName,
  CostPrice,
  IconButton,
  SubmitButton,
};
