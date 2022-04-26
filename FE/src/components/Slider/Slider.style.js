import styled from 'styled-components';
import { ReactComponent as ArrowLeft } from 'assets/arrow_left.svg';
import { ReactComponent as ArrowRight } from 'assets/arrow_right.svg';

const SliderWrapper = styled.div`
  padding: 60px 80px;
`;

const SliderTitle = styled.h2`
  font-size: ${({ theme: { fontSize } }) => fontSize.xLarge};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  color: ${({ theme: { colors } }) => colors.black};
`;

const SliderContainer = styled.div`
  display: flex;
  justify-content: space-between;
  position: relative;
  margin-top: 40px;
`;

const SliderList = styled.ul`
  display: flex;
  justify-content: space-between;
  width: 100%;
`;

const ArrowIconStyle = {
  position: 'absolute',
  top: '50%',
  cursor: 'pointer',
};

const ArrowLeftIcon = styled(ArrowLeft)`
  ${ArrowIconStyle};
  left: -36px;
  path {
    stroke: ${({ theme: { colors }, active }) => (active === 'true' ? colors.black : colors.gray3)};
  }
`;

const ArrowRightIcon = styled(ArrowRight)`
  ${ArrowIconStyle};
  right: -36px;
  path {
    stroke: ${({ theme: { colors }, active }) => (active === 'true' ? colors.black : colors.gray3)};
  }
`;

export { SliderWrapper, SliderTitle, SliderContainer, SliderList, ArrowLeftIcon, ArrowRightIcon };
