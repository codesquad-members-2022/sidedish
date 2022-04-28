import styled from 'styled-components';

const BadgeStyle = styled.div`
  width: ${({ type }) => (type === 'EVENT' ? '87px' : '76px')};
  height: 30px;
  border-radius: 20px;
  background-color: ${({ theme: { colors }, type }) => (type === 'EVENT' ? colors.green : colors.orange)};
  color: ${props => props.theme.colors.white};
  font-size: ${props => props.theme.fontSize.xSmall};
  font-weight: ${props => props.theme.fontWeight.medium};
  text-align: center;
  line-height: 30px;
`;

export { BadgeStyle };
