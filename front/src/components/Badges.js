import React from 'react';
import styled from 'styled-components';
function Badges({ badge_title }) {
  const badgeColores = {
    이벤트특가: '#6DD028',
    런칭특가: '#FF8E14',
  };
  return (
    <BadgeWrap>
      {badge_title.map((badgeTitle, index) => (
        <Badge key={index} background={badgeColores[badgeTitle]}>
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
  background: ${props => props.background};
  border-radius: 999px;
  font-size: 12px;
  line-height: 18px;
  color: #ffffff;
`;

export default Badges;
