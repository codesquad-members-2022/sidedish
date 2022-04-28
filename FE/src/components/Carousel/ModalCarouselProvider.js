import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import LeftArrowIcon from '../Icons/LeftArrowIcon';
import RightArrowIcon from '../Icons/RightArrowIcon';
import Text from '../Text';

const CarouselWrapper = styled.div`
  position: relative;
  width: 100%;
  height: 100%;
  overflow: hidden;
`;

const Slider = styled.div`
  display: flex;
  width: ${({ slidesLen }) => `${slidesLen * 100}%`};
  overflow: hidden;
  transform: ${({ curPage }) => `translateX(-${curPage * 50}%)`};
  transition: transform 1s;
`;

const Slide = styled.div`
  width: 100%;
  height: 100%;
`;

const ButtonWrap = styled.button`
  position: absolute;
  background-color: ${colors.none};
  cursor: ${({ isLastPage, isStartPage }) =>
    isLastPage || isStartPage ? 'default' : 'pointer'};
  ${({ css }) => css};
`;

const PageStatus = styled.div`
  position: absolute;
  width: 5%;
  top: 1.5em;
  right: 4.2em;
  display: flex;
  justify-content: space-between;
`;

const SubTitle = styled.div`
  position: absolute;
  top: 1.5em;
  left: 2em;
`;

const ButtonPrev = ({ onButtonClick, css, isStartPage, transitioning }) => (
  <ButtonWrap
    isPrev={true}
    onClick={onButtonClick}
    css={css}
    isStartPage={isStartPage}
    disabled={!!isStartPage || transitioning}
  >
    <LeftArrowIcon isStartPage={isStartPage} />
  </ButtonWrap>
);

const ButtonNext = ({ onButtonClick, css, isLastPage, transitioning }) => (
  <ButtonWrap
    isPrev={false}
    onClick={onButtonClick}
    css={css}
    isLastPage={isLastPage}
    disabled={!!isLastPage || transitioning}
  >
    <RightArrowIcon isLastPage={isLastPage} />
  </ButtonWrap>
);

const ModalCarouselProvider = ({
  maxPage,
  curPage,
  transitioning,
  slides,
  onClickNext,
  onClickPrev,
  onTransitionEnd,
  buttonPrevCss,
  buttonNextCss,
}) => {
  const isStartPage = curPage === 0;
  const isLastPage = curPage === maxPage - 1;

  return (
    <CarouselWrapper>
      <Slider
        onTransitionEnd={onTransitionEnd}
        slidesLen={slides.length}
        maxPage={maxPage}
        curPage={curPage}
      >
        {slides.map((slide, idx) => (
          <Slide key={`slide-${idx}`}>{slide}</Slide>
        ))}
      </Slider>
      <SubTitle>
        <Text font={FONT.LARGE_BOLD}>함께하면 더 맛있는 상품</Text>
      </SubTitle>
      <ButtonPrev
        isStartPage={isStartPage}
        onButtonClick={onClickPrev}
        transitioning={transitioning}
        css={buttonPrevCss}
      />
      <PageStatus>
        <div>{curPage + 1}</div>/<div>{maxPage}</div>
      </PageStatus>
      <ButtonNext
        isLastPage={isLastPage}
        onButtonClick={onClickNext}
        transitioning={transitioning}
        css={buttonNextCss}
      />
    </CarouselWrapper>
  );
};

export default ModalCarouselProvider;
