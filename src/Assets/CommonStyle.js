import styled, { css } from 'styled-components';

const Inner = styled.div`
  max-width: 1440px;
  padding: 0 80px;
  margin: 0 auto;
`;

const F_basic = css`
  display: flex;
`;

const F_basicCenter = css`
  ${F_basic}
  align-items: center;
`;

const F_Center = css`
  ${F_basic}
  align-items: center;
  justify-content: center;
`;

const F_BtweenCenter = css`
  ${F_basicCenter}
  justify-content: space-between;
`;

const TextEllipsis = css`
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

const Color = {
  black: '#1B1B1B',
  gray1: '#3F3F3F',
  gray2: '#777777',
  gray3: '#BCBCBC',
  gray4: '#EBEBEB',
  offWhite: '#F8F7F7',
  white: '#FFFFFF',
  green: '#6DD028',
  orange: '#FF8E14',
};

export {
  Inner,
  F_basic,
  F_basicCenter,
  F_BtweenCenter,
  F_Center,
  TextEllipsis,
  Color,
};
