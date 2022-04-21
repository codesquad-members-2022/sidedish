import styled from 'styled-components';

const EVENT = '이벤트특가';
const LARGE = 'large';
const SMALL = 'small';

const Container = styled.div`
  width: fit-content;
`;

const ImageContainer = styled.div`
  position: relative;
  margin-bottom: 16px;
`;

const Image = styled.img`
  display: block;
  width: ${({ size }) => 
          size === LARGE ? '411px' : 
          size === SMALL ? '160px' : '302px'};
  ${({ size }) => size === SMALL && 'margin-bottom: 8px'};
`;

const ImageBackground = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: ${({ size }) => size === LARGE ? '411px' : '302px'};
  height: ${({ size }) => size === LARGE ? '411px' : '302px'};
  background-color: rgba(0, 0, 0, 0.1);
  padding: 20px;
`;

const ImageBadge = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 142px;
  height: 142px;
  border: 1px solid ${({ theme }) => theme.color.black};
  border-radius: 50%;
  background-color: rgba(248, 248, 248, 0.8);
  margin-left: auto;

  p {
    padding: 8px 0;

    &:first-of-type {
      border-bottom: 1px solid ${({ theme }) => theme.color.black};
    }
  }
`;

const Title = styled.h3`
  color: ${({ theme }) => theme.color.grey1};
  ${({ theme, size }) => size === SMALL && `font-size: ${theme.fontSize.small}`};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
  letter-spacing: -0.008em;
  margin-bottom: 8px;
`;

const Description = styled.p`
  color: ${({ theme }) => theme.color.grey2};
  font-size: ${({ theme }) => theme.fontSize.small};
  letter-spacing: -0.008em;
  margin-bottom: 8px;
`;

const Prices = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 16px;
`;

const Price = styled.span`
  color: ${({ theme }) => theme.color.grey3};
  font-size: ${({ theme }) => theme.fontSize.small};
  letter-spacing: -0.008em;
  text-decoration: line-through;
`;

const MainPrice = styled.span`
  color: ${({ theme }) => theme.color.black};
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
  letter-spacing: -0.008em;
  text-decoration: none;
`;

const Badges = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
`;

const Badge = styled.span`
  display: block;
  width: 87px;
  height: 30px;
  color: ${({ theme }) => theme.color.white};
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  font-weight: ${({ theme }) => theme.fontWeight.medium};
  line-height: 1.8rem;
  text-align: center;
  border-radius: 30px;
  background-color: ${({ type, theme }) => type === EVENT ? theme.color.green : theme.color.orange};
`;

export {
  Container,
  Image,
  Description,
  ImageBadge,
  ImageContainer,
  Price,
  Prices,
  MainPrice,
  Title,
  Badges,
  Badge,
  ImageBackground
};
