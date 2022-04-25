import styled from 'styled-components';

import Colors from '@/Constants/Colors';
import Fonts from '@/Constants/Fonts';

const getBadgeName = type => {
  switch (type) {
    case 'launch':
      return '런칭특가';
    case 'event':
      return '이벤트특가';
    default:
      return '할인';
  }
};

const getBadgeBackgroundColor = type => {
  switch (type) {
    case 'launch':
      return Colors.ORANGE;
    case 'event':
      return Colors.GREEN;
    default:
      return Colors.GREY;
  }
};

const Badge = styled.button`
  padding: 6px 16px;
  color: ${Colors.WHITE};
  border-radius: 999px;
  background-color: ${props => props.backgroundColor};
  display: inline-block;
`;

export const DiscountBadge = ({ type }) => {
  return (
    <Badge
      className={Fonts.FONTS_SM}
      backgroundColor={getBadgeBackgroundColor(type)}
    >
      {getBadgeName(type)}
    </Badge>
  );
};
