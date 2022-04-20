import styled from 'styled-components';

const getBadgeName = type => {
  if (type === 'launch') return '런칭특가';
  if (type === 'event') return '이벤트특가';
  throw Error('DiscountBadge type must be launch or event');
};

const getBadgeBackgroundColor = type => {
  if (type === 'launch') return '#FF8E14';
  if (type === 'event') return '#6dd028';
  throw Error('DiscountBadge type must be launch or event');
};

const Root = styled.button`
  padding: 6px 16px;
  color: #fff;
  border-radius: 999px;
  background-color: ${props => props.backgroundColor};
`;

export const DiscountBadge = ({ type }) => {
  return (
    <Root
      className={'fonts-sm'}
      backgroundColor={getBadgeBackgroundColor(type)}
    >
      {getBadgeName(type)}
    </Root>
  );
};
