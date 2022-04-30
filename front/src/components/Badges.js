import React from 'react';
import styled from 'styled-components';
import theme from '../theme';
function Badges({ badge_title }) {
  const badgeColores = {
    이벤트특가: 'green',
    런칭특가: 'orange',
  };
  return (
    <BadgeWrap>
      {badge_title.map((badgeTitle, index) => (
        <Badge key={index} backgroundColor={badgeColores[badgeTitle]}>
          {badgeTitle}
        </Badge>
      ))}
    </BadgeWrap>
  );
}

const BadgeWrap = styled.div`
  display: flex;
  gap: 10px;
`;
const Badge = styled.div`
  box-sizing: border-box;
  padding: 6px 16px;
  display: grid;
  place-content: center center;
  background: ${({ theme, backgroundColor }) => theme.colors[backgroundColor]};
  border-radius: 999px;
  font-size: 12px;
  line-height: 18px;
  color: ${({ theme }) => theme.colors.white};
`;

export default Badges;
