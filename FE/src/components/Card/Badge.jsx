import { badgeName } from 'constants/productInfo';
import React from 'react';
import { BadgeStyle } from './Badge.style';

const Badge = ({ type }) => {
  return <BadgeStyle type={type}>{badgeName[type]}</BadgeStyle>;
};

export default Badge;
