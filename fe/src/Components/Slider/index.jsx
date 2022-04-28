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
    width: auto !important;
    display: inline-flex !important;
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

const useSlide = ({ mode, slideRef, slideViewItemLength }) => {
  const initialPageIndex = 1;
  const minSlideIndex = 0;
  const [curSlideIndex, setCurSlideIndex] = useState(minSlideIndex);
  const [maxSlideIndex, setMaxSlideIndex] = useState(minSlideIndex);
  const [curPageIndex, setCurPageIndex] = useState(initialPageIndex);
  const [lastPageIndex, setLastPageIndex] = useState(initialPageIndex);
  const [slideUnitWidth, setSlideUnitWidth] = useState(0);

  const handleClickPrevButton = () => {
    const tempSlideIndex = curSlideIndex - slideViewItemLength;
    let nextSlideIndex = tempSlideIndex;

    if (mode !== 'page' && tempSlideIndex < minSlideIndex) {
      nextSlideIndex = minSlideIndex;
    }

    const nextSlidePageIndex =
      Math.floor(nextSlideIndex / slideViewItemLength) + 1;
    setCurSlideIndex(nextSlideIndex);
    setCurPageIndex(nextSlidePageIndex);
  };

  const handleClickNextButton = () => {
    const tempSlideIndex = curSlideIndex + slideViewItemLength;
    let nextSlideIndex = tempSlideIndex;

    if (mode !== 'page') {
      if (tempSlideIndex < minSlideIndex) {
        nextSlideIndex = minSlideIndex;
      } else if (tempSlideIndex > maxSlideIndex) {
        nextSlideIndex = maxSlideIndex;
      }
    }

    const nextSlidePageIndex =
      Math.floor(nextSlideIndex / slideViewItemLength) + 1;
    setCurSlideIndex(nextSlideIndex);
    setCurPageIndex(nextSlidePageIndex);
  };

  useEffect(() => {
    if (!slideRef) {
      return;
    }

    const slideItemLength = slideRef.children.length;
    const _slideUnitWidth = slideRef.clientWidth / slideItemLength;
    const tempSlideIndex = slideItemLength - slideViewItemLength;

    const _maxSlideIndex =
      mode === 'page'
        ? (Math.ceil(slideItemLength / slideViewItemLength) - 1) *
          slideViewItemLength
        : tempSlideIndex < 0
        ? minSlideIndex
        : tempSlideIndex;

    const _lastPageIndex = Math.ceil(slideItemLength / slideViewItemLength);

    setSlideUnitWidth(_slideUnitWidth);
    setLastPageIndex(_lastPageIndex);
    setMaxSlideIndex(_maxSlideIndex);
  }, [slideRef, slideViewItemLength]);

  return [
    curSlideIndex,
    minSlideIndex,
    maxSlideIndex,
    slideUnitWidth,
    curPageIndex,
    lastPageIndex,
    handleClickPrevButton,
    handleClickNextButton,
  ];
};

export const Slider = ({
  children,
  mode,
  margin = 0,
  slideRef,
  animation,
  slideViewItemLength,
  prevIcon,
  nextIcon,
  prevButtonClassName,
  nextButtonClassName,
  pageIndexWrapperClassName,
  curPageIndexClassName = null,
  lastPageIndexClassName = null,
}) => {
  const [
    curSlideIndex,
    minSlideIndex,
    maxSlideIndex,
    slideUnitWidth,
    curPageIndex,
    lastPageIndex,
    handleClickSliderPrevButton,
    handleClickSliderNextButton,
  ] = useSlide({
    mode,
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
        disabled={curSlideIndex <= minSlideIndex}
      >
        {prevIcon || <span>◀</span>}
      </SlideButton>
      <SlideButton
        className={nextButtonClassName}
        onClick={handleClickSliderNextButton}
        disabled={curSlideIndex >= maxSlideIndex}
      >
        {nextIcon || <span>▶</span>}
      </SlideButton>
      <div className={pageIndexWrapperClassName}>
        {curPageIndexClassName && (
          <span className={curPageIndexClassName}>{curPageIndex}</span>
        )}
        {curPageIndexClassName && (
          <span className={lastPageIndexClassName}>{lastPageIndex}</span>
        )}
      </div>
    </SliderWrapper>
  );
};
