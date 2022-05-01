import styled from 'styled-components';

const CardWrapper = styled.div`
  display: flex;
  flex-direction: column;
  cursor: pointer;
`;

const Title = styled.h3`
  font-size: ${({ theme, size }) => theme.fontSize[size]};
  font-weight: ${({ theme, size }) => (size === 'small' ? theme.fontWeight.regular : theme.fontWeight.bold)};
  color: ${props => props.theme.colors.grey1};
  margin-right: 8px;
  margin-bottom: ${({ size }) => (size === 'small' ? '8px' : 0)};
  width: ${({ size }) => (size === 'small' ? '160px' : '320px')};
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
`;

const SubTitle = styled.p`
  font-size: ${props => props.theme.fontSize.small};
  color: ${props => props.theme.colors.grey2};
  margin: 8px 0;
`;

const PriceBox = styled.div`
  display: flex;
`;

const NormalPrice = styled(Title)`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  width: auto;
`;

const SalePrice = styled.p`
  font-size: ${props => props.theme.fontSize.small};
  color: ${props => props.theme.colors.grey3};
  text-decoration: line-through;
`;

const DescriptionWrapper = styled.div`
  margin: 16px 0;
`;

export { CardWrapper, Title, SubTitle, PriceBox, NormalPrice, SalePrice, DescriptionWrapper };
