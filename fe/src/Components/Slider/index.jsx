import { useState, useEffect } from 'react';
import styled from 'styled-components';

const SliderWrapper = styled.div`
  width: 100%;
  position: relative;
`;

const SlideWindow = styled.div`
  width: 100%;
  overflow: hidden;

  > * {
    overflow: visible !important;
    transform: translate3d(
      ${({ curSlideIndex, slideUnitWidth }) =>
        -(curSlideIndex * slideUnitWidth)}px,
      0,
      0
    );
    transition: ${({ animation }) =>
      animation ? 'transform 250ms ease-in-out' : 'none'};

    > * {
      margin-right: ${({ margin }) => margin}px !important;
    }
  }
`;

const SlideButton = styled.button`
  position: absolute;

  top: 50%;
  width: 32px;
  height: 32px;
  transform: translateY(-50%);

  &:hover {
    opacity: 0.7;
  }

  &:active {
    opacity: 0.4;
  }

  &:disabled {
    opacity: 0.2;
    cursor: default;
  }
`;

const Icon = styled.i`
  font-size: 24px;
`;

const useSlide = ({ slideRef, slideViewItemLength }) => {
  const initialPageIndex = 1;
  const minSlideIndex = 0;
  const [curSlideIndex, setCurSlideIndex] = useState(minSlideIndex);
  const [maxSlideIndex, setMaxSlideIndex] = useState(minSlideIndex);
  const [slidePageIndex, setSlidePageIndex] = useState(initialPageIndex);
  const [slideUnitWidth, setSlideUnitWidth] = useState(0);

  const handleClickPrevButton = () => {
    const tempSlideIndex = curSlideIndex - slideViewItemLength;
    let nextSlideIndex;

    if (tempSlideIndex < minSlideIndex) {
      nextSlideIndex = minSlideIndex;
    } else {
      nextSlideIndex = tempSlideIndex;
    }

    const nextSlidePageIndex =
      Math.floor(nextSlideIndex / slideViewItemLength) + 1;
    setCurSlideIndex(nextSlideIndex);
    setSlidePageIndex(nextSlidePageIndex);
  };

  const handleClickNextButton = () => {
    const tempSlideIndex = curSlideIndex + slideViewItemLength;
    let nextSlideIndex;

    if (tempSlideIndex < minSlideIndex) {
      nextSlideIndex = minSlideIndex;
    } else if (tempSlideIndex > maxSlideIndex) {
      nextSlideIndex = maxSlideIndex;
    } else {
      nextSlideIndex = tempSlideIndex;
    }

    const nextSlidePageIndex =
      Math.floor(nextSlideIndex / slideViewItemLength) + 1;
    setCurSlideIndex(nextSlideIndex);
    setSlidePageIndex(nextSlidePageIndex);
  };

  useEffect(() => {
    if (!slideRef) {
      return;
    }

    const _maxSlideIndex = slideRef.children.length - slideViewItemLength;

    setSlideUnitWidth(slideRef.clientWidth / slideRef.children.length);

    if (_maxSlideIndex < 0) {
      setMaxSlideIndex(minSlideIndex);
    } else {
      setMaxSlideIndex(_maxSlideIndex);
    }
  }, [slideRef, slideViewItemLength]);

  return [
    curSlideIndex,
    minSlideIndex,
    maxSlideIndex,
    slideUnitWidth,
    slidePageIndex,
    handleClickPrevButton,
    handleClickNextButton,
  ];
};

export const MySlider = ({
  children,
  margin,
  slideRef,
  animation,
  slideViewItemLength,
  prevButtonClassName,
  nextButtonClassName,
}) => {
  const [
    curSlideIndex,
    minSlideIndex,
    maxSlideIndex,
    slideUnitWidth,
    slidePageIndex,
    handleClickSliderPrevButton,
    handleClickSliderNextButton,
  ] = useSlide({
    slideRef,
    slideViewItemLength: slideViewItemLength,
  });

  return (
    <SliderWrapper>
      <SlideWindow
        margin={margin}
        slideUnitWidth={slideUnitWidth}
        curSlideIndex={curSlideIndex}
        animation={animation}
      >
        {children}
      </SlideWindow>
      <SlideButton
        className={prevButtonClassName}
        onClick={handleClickSliderPrevButton}
        disabled={curSlideIndex === minSlideIndex}
      >
        <Icon className={'ic-prev'} />
      </SlideButton>
      <SlideButton
        className={nextButtonClassName}
        onClick={handleClickSliderNextButton}
        disabled={curSlideIndex === maxSlideIndex}
      >
        <Icon className={'ic-next'} />
      </SlideButton>
    </SliderWrapper>
  );
};