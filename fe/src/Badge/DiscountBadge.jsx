import styled from 'styled-components';
import Colors from '../Constants/Colors';

const getBadgeName = type => {
  if (type === 'launch') return '런칭특가';
  if (type === 'event') return '이벤트특가';
  throw Error('DiscountBadge type must be launch or event');
};

const getBadgeBackgroundColor = type => {
  if (type === 'launch') return Colors.ORANGE;
  if (type === 'event') return Colors.GREEN;
  throw Error('DiscountBadge type must be launch or event');
};

const Badge = styled.button`
  padding: 6px 16px;
  color: ${Colors.WHITE};
  border-radius: 999px;
  background-color: ${props => props.backgroundColor};
`;

export const DiscountBadge = ({ type }) => {
  return (
    <Badge
      className={'fonts-sm'}
      backgroundColor={getBadgeBackgroundColor(type)}
    >
      {getBadgeName(type)}
    </Badge>
  );
};
