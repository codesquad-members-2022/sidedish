import styled from 'styled-components';
import { ReactComponent as Plus } from 'assets/plus.svg';
import { ReactComponent as Minus } from 'assets/minus.svg';

const ModalWrapper = styled.div`
  box-sizing: border-box;
  display: ${props => (props.visible ? 'block' : 'none')};
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 1000;
  overflow: auto;
  outline: 0;
  user-select: none;
`;

const ModalOverlay = styled.div`
  box-sizing: border-box;
  display: ${props => (props.visible ? 'block' : 'none')};
  position: fixed;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.6);
  z-index: 999;
`;

const ModalInner = styled.div`
  box-sizing: border-box;
  position: relative;
  box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.5);
  background-color: ${({ theme: { colors } }) => colors.white};
  width: 960px;
  height: 992px;
  top: 50%;
  transform: translateY(-50%);
  margin: 0 auto;
  padding: 76px 0 64px 0;
  border-radius: 5px;
  border: 1px solid ${({ theme: { colors } }) => colors.black};
`;

const CloseBtn = styled.button`
  width: 30px;
  height: 26px;
  color: ${({ theme: { colors } }) => colors.grey2};
  position: absolute;
  top: 32px;
  right: 48px;
`;

const ContentsWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  padding: 0 48px 48px;
  border-bottom: 1px solid ${({ theme: { colors } }) => colors.black};
`;

const ThumbnailWrapper = styled.div`
  width: 392px;
  height: 472px;
`;

const ThumbnailList = styled.ul`
  display: flex;
  width: 100%;
  height: 72px;
  margin-top: 8px;
`;

const DescriptionWrapper = styled.div`
  width: 440px;
  height: 472px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

const InnerDescription = styled.div`
  display: flex;
  height: 100%;
  flex-direction: column;
`;

const PrimaryDescription = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100px;
`;

const FlexWrapper = styled.div`
  display: flex;
  padding: 5px;
`;

const SmallFont = styled.p`
  font-size: ${({ theme: { fontSize } }) => fontSize.xSmall};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.regular};
  color: ${({ theme: { colors }, type }) => (type === 'title' ? colors.grey2 : colors.black)};
  width: ${({ type }) => type === 'title' && '80px'};
`;

const PrimaryFont = styled.h2`
  font-size: ${({ theme: { fontSize } }) => fontSize.large};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  margin-left: ${({ margin }) => margin + 'px'};
`;

const OldPrice = styled.p`
  font-size: ${({ theme: { fontSize } }) => fontSize.small};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  color: ${({ theme: { colors } }) => colors.grey3};
`;

const SecondaryDescription = styled.div`
  display: flex;
  flex-direction: column;
  padding: 10px 0;
  border-top: 1px solid ${({ theme: { colors } }) => colors.grey4};
  border-bottom: 1px solid ${({ theme: { colors } }) => colors.grey4};
  margin: 20px 0;
`;

const OrderWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: ${({ theme: { fontSize } }) => fontSize.medium};
`;

const CounterWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 80px;
`;

const PlusIcon = styled(Plus)`
  cursor: pointer;
`;

const MinusIcon = styled(Minus)`
  cursor: pointer;
`;

const TotalOrderWrapper = styled.div`
  display: flex;
  align-items: center;
`;

const TotalOrder = styled.p`
  font-size: ${({ theme: { fontSize } }) => fontSize.medium};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.regular};
  color: ${({ theme: { colors } }) => colors.grey2};
  margin-right: 16px;
`;

const OrderBtn = styled.button`
  width: 100%;
  height: 58px;
  background-color: ${({ theme: { colors } }) => colors.black};
  color: ${({ theme: { colors } }) => colors.white};
  font-size: ${({ theme: { fontSize } }) => fontSize.large};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.display};
`;

export {
  ModalWrapper,
  ModalOverlay,
  ModalInner,
  CloseBtn,
  ContentsWrapper,
  ThumbnailWrapper,
  ThumbnailList,
  DescriptionWrapper,
  InnerDescription,
  PrimaryDescription,
  PrimaryFont,
  SecondaryDescription,
  OrderWrapper,
  CounterWrapper,
  PlusIcon,
  MinusIcon,
  TotalOrderWrapper,
  TotalOrder,
  OrderBtn,
  OldPrice,
  FlexWrapper,
  SmallFont,
};
