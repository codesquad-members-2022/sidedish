import React from 'react';
import { BadgeStyle } from './Badge.style';

const Badge = ({ type }) => {
  const badgeName = {
    LAUNCHING: '런칭특가',
    EVENT: '이벤트특가',
  };

  return <BadgeStyle type={type}>{badgeName[type]}</BadgeStyle>;
};

export default Badge;
