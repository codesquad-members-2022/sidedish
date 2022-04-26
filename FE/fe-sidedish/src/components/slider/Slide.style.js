import styled, { css } from 'styled-components';
import { CARD_SIZE } from '../../constants/card';
import { BUTTON_TYPE } from '../../constants/slide';

const Wrapper = styled.div`
  overflow: hidden;
`;

const PaginationContainer = styled.div`
  position: absolute;
  top: 50%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 10px;
  width: 100%;
  transform: translateY(-50%);
`;

const Pagination = styled.div`
  position: relative;
  top: -1px;

  * {
    color: ${({ theme }) => theme.color.grey1};
    font-size: ${({ theme }) => theme.fontSize.medium};
  }
`;

const CurrentPage = styled.span`
  font-weight: ${({ theme }) => theme.fontSize.medium};
`;

const TotalPage = styled.span``;

const Button = styled.button`
  position: absolute;
  ${({ type }) => type === BUTTON_TYPE.PREV && 'left: -60px;'}
  ${({ type }) => type === BUTTON_TYPE.NEXT && 'right: -60px;'}
  width: 32px;
  height: 32px;
  font-size: 0;
  ${({ disabled, theme }) => disabled && `path { stroke: ${theme.color.grey3}}` }
`;

const CardList = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 24px;
`;

const Container = styled.div`
  position: relative;
  ${({ cardSize }) => cardSize === CARD_SIZE.SMALL && SmallSlider}
`;

const SmallSlider = () => css`
  width: 864px;

  ${CardList} {
    gap: 16px;
  }

  ${PaginationContainer} {
    display: flex;
    width: fit-content;
    top: -25%;
    right: 0;
    transform: none;
  }

  ${Button} {
    position: relative;
    left: 0;
    right: 0;
  }
`;

export {
  Container,
  Wrapper,
  PaginationContainer,
  Pagination,
  CurrentPage,
  TotalPage,
  Button,
  CardList,
};
