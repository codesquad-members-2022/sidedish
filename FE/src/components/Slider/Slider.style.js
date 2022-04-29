import styled from 'styled-components';
import { ReactComponent as ArrowLeft } from 'assets/arrow_left.svg';
import { ReactComponent as ArrowRight } from 'assets/arrow_right.svg';

const SliderWrapper = styled.div`
  padding: ${({ type }) => (type === 'small' ? '48px' : '60px 80px')};
  position: relative;
  display: ${({ display }) => display};
`;

const SliderHeader = styled.div`
  display: flex;
  justify-content: space-between;
`;

const SliderTitle = styled.h2`
  font-size: ${({ theme: { fontSize }, type }) => (type === 'small' ? fontSize.large : fontSize.xLarge)};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  color: ${({ theme: { colors } }) => colors.gray1};
`;

const SliderPageIndex = styled.div`
  font-size: ${({ theme: { fontSize } }) => fontSize.small};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  color: ${({ theme: { colors } }) => colors.black};
  margin-right: 30px;
  align-items: center;
  line-height: 30px;
`;

const SliderContainer = styled.div`
  margin-top: ${({ type }) => (type === 'small' ? '28px' : '40px')};
  width: ${({ width }) => width + 'px'};
  overflow: hidden;
`;

const SliderList = styled.ul`
  display: flex;
  justify-content: space-between;
  width: ${({ width }) => width};
  transition: all 1s ease;
  transform: translateX(${({ xposition }) => xposition + 'px'});
`;

const ArrowIconStyle = {
  position: 'absolute',
  cursor: 'pointer',
};

const ArrowLeftIcon = styled(ArrowLeft)`
  ${ArrowIconStyle};
  width: ${({ type }) => (type === 'small' ? '6px' : '11px')};
  height: ${({ type }) => (type === 'small' ? '12px' : '20px')};
  left: ${({ type }) => (type === 'small' ? '818px' : '36px')};
  top: ${({ type }) => (type === 'small' ? '59px' : '50%')};
  path {
    stroke: ${({ theme: { colors }, active }) => (active === 'true' ? colors.black : colors.gray3)};
  }
`;

const ArrowRightIcon = styled(ArrowRight)`
  ${ArrowIconStyle};
  width: ${({ type }) => (type === 'small' ? '6px' : '11px')};
  height: ${({ type }) => (type === 'small' ? '12px' : '20px')};
  right: ${({ type }) => (type === 'small' ? '48px' : '36px')};
  top: ${({ type }) => (type === 'small' ? '59px' : '50%')};
  path {
    stroke: ${({ theme: { colors }, active }) => (active === 'true' ? colors.black : colors.gray3)};
  }
`;

export {
  SliderWrapper,
  SliderHeader,
  SliderTitle,
  SliderPageIndex,
  SliderContainer,
  SliderList,
  ArrowLeftIcon,
  ArrowRightIcon,
};
