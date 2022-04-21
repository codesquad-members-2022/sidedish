import React from 'react';
import styled from 'styled-components';
import { flexBetween } from '../css/mixins';
import GnbItem from './GnbItem';

const Gnb = ({ gnbInfo }) => {
  return (
    <GnbBox>
      {gnbInfo.map(({ title, contents }, idx) => (
        <GnbItem key={idx} title={title} contents={contents} />
      ))}
    </GnbBox>
  );
};

const GnbBox = styled.section`
  ${flexBetween}
  &:hover {
    height: 150px;
    ul {
      display: block;
      position: absolute;
      margin-top: 10px;
    }
  }
`;

export default Gnb;
