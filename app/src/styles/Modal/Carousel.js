import styled from "styled-components";

const Container = styled.div`
  padding: 4.8rem 4.8rem 0 4.8rem;
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Title = styled.h3`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
`;

const Counter = styled.div`
  display: flex;
  gap: 0.8rem;
`;

const Btn = styled.button`
  background-repeat: no-repeat;
  background-position: center;
  width: 2.4rem;
  border: none;
  background-color: ${({ theme }) => theme.color.white};
  cursor: pointer;
`;

const LeftBtn = styled(Btn)`
  background-image: url(${({ src }) => src});
`;

const RightBtn = styled(Btn)`
  background-image: url(${({ src }) => src});
`;

const PageText = styled.div`
  font-size: ${({ theme }) => theme.fontSize.small};
  line-height: 2.4rem;
`;

const CurrentPage = styled(PageText)`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const DividePage = styled(PageText)`
  font-weight: ${({ theme }) => theme.fontWeight.regular};
`;

const TotalPage = styled(DividePage)`
  font-weight: ${({ theme }) => theme.fontWeight.regular};
`;

const CardCarousel = styled.div`
  overflow: hidden;
  width: 86.4rem;
  height: 23.6rem;
  margin-top: 2.8rem;
`;

const CardCarouselInner = styled.div`
  display: flex;
  flex-wrap: nowrap;
  gap: ${({ gap }) => `${gap / 10}rem`};
  transition: all 1s;
`;

const Card = styled.div`
  flex-shrink: 0;
  flex-basis: ${({ size }) => `${size / 10}rem`};
  cursor: pointer;
`;

const CardImg = styled.img`
  width: 100%;
`;

const CardTitle = styled.h3`
  margin-top: 0.8rem;
  line-height: 2.4rem;
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.small};
  color: ${({ theme }) => theme.color.grey1};
`;

const CardPrices = styled.div`
  display: flex;
  gap: 0.8rem;
`;

const SPrice = styled.div`
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const NPrice = styled.div`
  font-size: ${({ theme }) => theme.fontSize.small};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  color: ${({ theme }) => theme.color.grey3};
  text-decoration: line-through;
`;

export {
  Container,
  Header,
  Title,
  Counter,
  LeftBtn,
  RightBtn,
  CurrentPage,
  DividePage,
  TotalPage,
  CardCarousel,
  CardCarouselInner,
  Card,
  CardImg,
  CardTitle,
  CardPrices,
  SPrice,
  NPrice,
};
