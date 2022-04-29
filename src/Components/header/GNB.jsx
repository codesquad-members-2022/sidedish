import React from 'react';
import styled from 'styled-components';
import { F_basic, Color } from '../../Assets/CommonStyle';
import List from '../List';

const GNB_style = styled.nav`
  margin: 0 40px;
  > ul {
    ${F_basic}
    > li {
      position: relative;
      padding: 0 12px;
      ul {
        visibility: hidden;
        opacity: 0;
        position: absolute;
        top: 100%;
        left: 0;
        width: 100%;
        padding: 16px 12px;
        > li {
          margin-bottom: 8px;
          &:hover {
            color: ${Color.orange};
            text-decoration: underline;
          }
        }
      }
    }
  }
  &.active {
    > ul ul {
      transition: 0.3s;
      opacity: 1;
      visibility: visible;
    }
    li:hover > a {
      font-weight: 500;
      color: ${Color.orange};
    }
  }
  a {
    display: block;
  }
`;

const GNB = ({ list, isHover, setIsHover }) => {
  const mouseHandler = () => {
    setIsHover(!isHover);
  };

  return (
    <GNB_style
      onMouseEnter={mouseHandler}
      onMouseLeave={mouseHandler}
      className={isHover ? 'active' : null}>
      <List menu={list} />
    </GNB_style>
  );
};

export default GNB;
