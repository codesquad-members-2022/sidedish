import styled from 'styled-components';

const CardWrapper = styled.div`
  display: flex;
  flex-direction: column;
  cursor: pointer;
`;

const Thumbnail = styled.div`
  width: 411px;
  height: 411px;
  background-image: url(${({ src }) => src});
  background-repeat: no-repeat;
  background-size: cover;
`;

const Title = styled.h3`
  font-size: ${props => props.theme.fontSize.medium};
  font-weight: ${props => props.theme.fontWeight.bold};
  color: ${props => props.theme.colors.grey1};
  margin-right: 8px;
`;

const SubTitle = styled.p`
  font-size: ${props => props.theme.fontSize.small};
  color: ${props => props.theme.colors.grey2};
  margin: 8px 0;
`;

const PriceBox = styled.div`
  display: flex;
`;

const SalePrice = styled.p`
  font-size: ${props => props.theme.fontSize.small};
  color: ${props => props.theme.colors.grey3};
  text-decoration: line-through;
`;

const Badge = styled.div`
  width: 76px;
  height: 30px;
  border-radius: 20px;
  background-color: ${props => props.theme.colors.orange};
  color: ${props => props.theme.colors.white};
  font-size: ${props => props.theme.fontSize.xSmall};
  font-weight: ${props => props.theme.fontWeight.medium};
  text-align: center;
  line-height: 30px;
`;

const DescriptionWrapper = styled.div`
  margin: 16px 0;
`;

export { CardWrapper, Thumbnail, Title, SubTitle, PriceBox, SalePrice, Badge, DescriptionWrapper };
