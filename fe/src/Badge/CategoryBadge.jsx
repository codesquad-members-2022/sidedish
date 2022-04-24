import styled from 'styled-components';

import Colors from '@/Constants/Colors';

const Badge = styled.button`
  padding: 8px 16px;
  border: 2px solid ${Colors.BLACK};
  border-radius: 999px;
  background-color: ${Colors.PALE_GREY};
`;

export const CategoryBadge = ({ name = '기획전' }) => {
  return <Badge className={'fonts-md'}>{name}</Badge>;
};
