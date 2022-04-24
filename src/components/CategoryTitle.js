import React from 'react';
import styled from 'styled-components';

import { color } from '../css/variables';

const CategoryTitle = ({ title, banner = null }) => {
  return (
    <StyledTitle>
      {banner && <StyledSpan>{banner}</StyledSpan>}
      {banner ? <StyledH2>{title}</StyledH2> : <StyledH4>{title}</StyledH4>}
    </StyledTitle>
  );
};

const StyledTitle = styled.div`
  display: flex;
`;

const StyledSpan = styled.span`
  margin-right: 20px;
  padding: 10px;
  border-radius: 20px;
  border: 1px solid ${color.black};
`;

const StyledH2 = styled.h2`
  font-size: 35px;
  font-weight: bolder;
`;

const StyledH4 = styled.h4`
  font-size: 20px;
`;

export default CategoryTitle;
