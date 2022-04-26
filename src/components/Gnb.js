import React, { useState } from 'react';
import styled from 'styled-components';

import { flexBetween } from '../css/mixins';
import GnbItem from './GnbItem';

const Gnb = ({ gnbInfo }) => {
  const [isHover, setIsHover] = useState(false);

  return (
    <GnbBox
      onMouseOver={() => setIsHover(true)}
      onMouseOut={() => setIsHover(false)}
    >
      {gnbInfo.map(({ title, contents }, idx) => (
        <GnbItem
          key={`${title}-${idx}`}
          title={title}
          contents={contents}
          isHover={isHover}
        />
      ))}
    </GnbBox>
  );
};

const GnbBox = styled.section`
  ${flexBetween}
  &:hover {
    height: 150px;
  }
`;

export default Gnb;
