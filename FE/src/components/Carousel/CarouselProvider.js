import styled from 'styled-components';

import colors from '../../constants/colors';
import LeftArrowIcon from '../Icons/LeftArrowIcon';
import RightArrowIcon from '../Icons/RightArrowIcon';

const CarouselWrapper = styled.div`
  position: relative;
  width: 100vw;
`;

const Slider = styled.div`
  display: flex;
  width: ${({ slidesLen }) => `${slidesLen * 100}vw`};
  overflow: hidden;
  transform: ${({ curPage }) => `translateX(-${curPage * 100}vw)`};
  transition: transform 1s;
`;

const Slide = styled.div`
  width: 100vw;
  height: 100%;
`;

const ButtonWrap = styled.button`
  position: absolute;
  background-color: ${colors.none};
  cursor: ${({ isLastPage, isStartPage }) =>
    isLastPage || isStartPage ? 'default' : 'pointer'};
  ${({ css }) => css};
`;

const ButtonPrev = ({ onButtonClick, css, isStartPage }) => (
  <ButtonWrap
    isPrev={true}
    onClick={onButtonClick}
    css={css}
    isStartPage={isStartPage}
    disabled={!!isStartPage}
  >
    <LeftArrowIcon isStartPage={isStartPage} />
  </ButtonWrap>
);

const ButtonNext = ({ onButtonClick, css, isLastPage }) => (
  <ButtonWrap
    isPrev={false}
    onClick={onButtonClick}
    css={css}
    isLastPage={isLastPage}
    disabled={!!isLastPage}
  >
    <RightArrowIcon isLastPage={isLastPage} />
  </ButtonWrap>
);

const CarouselProvider = ({
  maxPage,
  curPage,
  slides,
  onClickNext,
  onClickPrev,
  buttonPrevCss,
  buttonNextCss,
}) => {
  const isStartPage = curPage === 0;
  const isLastPage = curPage === maxPage - 1;

  return (
    <CarouselWrapper>
      <Slider slidesLen={slides.length} maxPage={maxPage} curPage={curPage}>
        {slides.map((slide, idx) => (
          <Slide key={`slide-${idx}`}>{slide}</Slide>
        ))}
      </Slider>
      <ButtonPrev
        isStartPage={isStartPage}
        onButtonClick={onClickPrev}
        css={buttonPrevCss}
      />
      <ButtonNext
        isLastPage={isLastPage}
        onButtonClick={onClickNext}
        css={buttonNextCss}
      />
    </CarouselWrapper>
  );
};

export default CarouselProvider;
