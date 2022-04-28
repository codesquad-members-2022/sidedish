import { useState, useRef, useEffect } from 'react';
import styled from 'styled-components';

import { IconFonts, Fonts } from '@/Constants';
import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { RetryButton } from '@/Components/Button';
import { LoadingSpinner } from '@/Components/LoadingSpinner';
import { ProductCard } from '@/Components/ProductCard';

const CategoryProductsWrapper = styled.li`
  width: 1280px;
  margin-top: 80px;

  &:first-child {
    margin-top: 56px;
  }

  &:last-child {
    margin-bottom: 80px;
  }
`;

const Header = styled.header`
  margin-bottom: 40px;
`;

const ProductCardList = styled.ul`
  display: inline-flex;
  justify-content: flex-start;
`;

/* 슬라이더 */
const SLIDE_CONTAINER = 'slide-container';
const SLIDE_MARGIN = 24;
const SLIDE_VIEW_LENGTH = 4;
const SLIDER_PREV_BUTTON = 'slider-prev-button';
const SLIDER_NEXT_BUTTON = 'slider-next-button';

const SliderWrapper = styled.div`
  width: 100%;
  position: relative;
`;

const Slider = styled.div`
  width: 100%;
  overflow: hidden;

  .${SLIDE_CONTAINER} {
    transform: translate3d(
      ${({ curSlideIndex, slideUnitWidth }) =>
        -(curSlideIndex * slideUnitWidth)}px,
      0,
      0
    );
    transition: transform 250ms ease-in-out;

    > * {
      margin-right: ${({ margin }) => margin}px;
    }
  }
`;

const SliderButton = styled.button`
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

  &.${SLIDER_PREV_BUTTON} {
    left: -60px;
  }

  &.${SLIDER_NEXT_BUTTON} {
    right: -60px;
  }
`;

const Icon = styled.i`
  font-size: 24px;
`;

const useSlide = ({ slideRef }) => {
  const minSlideIndex = 0;
  const slideViewItemLength = SLIDE_VIEW_LENGTH;
  const [curSlideIndex, setCurSlideIndex] = useState(minSlideIndex);
  const [maxSlideIndex, setMaxSlideIndex] = useState(minSlideIndex);

  const handleClickPrevButton = () => {
    const nextSlideIndex = curSlideIndex - slideViewItemLength;

    if (nextSlideIndex < minSlideIndex) {
      setCurSlideIndex(minSlideIndex);
    } else {
      setCurSlideIndex(nextSlideIndex);
    }
  };

  const handleClickNextButton = () => {
    const nextSlideIndex = curSlideIndex + slideViewItemLength;

    if (nextSlideIndex < minSlideIndex) {
      setCurSlideIndex(minSlideIndex);
    } else if (nextSlideIndex > maxSlideIndex) {
      setCurSlideIndex(maxSlideIndex);
    } else {
      setCurSlideIndex(nextSlideIndex);
    }
  };

  useEffect(() => {
    if (!slideRef.current) {
      return;
    }

    const _maxSlideIndex =
      slideRef.current.children.length - slideViewItemLength;

    if (_maxSlideIndex < 0) {
      setMaxSlideIndex(minSlideIndex);
    } else {
      setMaxSlideIndex(_maxSlideIndex);
    }
  }, [slideRef.current]);

  return [
    curSlideIndex,
    minSlideIndex,
    maxSlideIndex,
    handleClickPrevButton,
    handleClickNextButton,
  ];
};

/* ****** */

const LS_MARGIN = 300;
const LS_RADIUS = 50;
const LS_BORDER_WIDTH = 10;
const RT_MARGIN = 300;

export const CategoryProducts = ({ categoryId }) => {
  const [categoryProductsData, isLoaded, isError, setRetry] = useFetch(
    `${API_URL}/categories/${categoryId}/items`
  );

  const slideRef = useRef(null);
  const [slideUnitWidth, setSlideUnitWidth] = useState(0);
  const [
    curSlideIndex,
    minSlideIndex,
    maxSlideIndex,
    handleClickSliderPrevButton,
    handleClickSliderNextButton,
  ] = useSlide({
    slideRef,
  });

  const handleClickRetryButton = () => {
    setRetry(true);
  };

  useEffect(() => {
    if (!isLoaded) return;
    const { clientWidth, children } = slideRef.current;
    setSlideUnitWidth(clientWidth / children.length);
  }, [isLoaded]);

  if (isError)
    return <RetryButton onClick={handleClickRetryButton} margin={RT_MARGIN} />;
  if (!isLoaded)
    return (
      <LoadingSpinner
        margin={LS_MARGIN}
        radius={LS_RADIUS}
        borderWidth={LS_BORDER_WIDTH}
      />
    );

  const categoryProducts = categoryProductsData.result_body;

  return (
    <CategoryProductsWrapper>
      <Header className={Fonts.XL_BOLD}>{categoryProducts.title}</Header>
      <SliderWrapper>
        <Slider
          margin={SLIDE_MARGIN}
          slideUnitWidth={slideUnitWidth}
          curSlideIndex={curSlideIndex}
        >
          <ProductCardList className={SLIDE_CONTAINER} ref={slideRef}>
            {categoryProducts.contents.map(categoryProduct => (
              <ProductCard
                size={'md'}
                data={categoryProduct}
                key={categoryProduct.id}
              />
            ))}
          </ProductCardList>
        </Slider>
        <SliderButton
          className={SLIDER_PREV_BUTTON}
          onClick={handleClickSliderPrevButton}
          disabled={curSlideIndex === minSlideIndex}
        >
          <Icon className={IconFonts.PREV_BUTTON} />
        </SliderButton>
        <SliderButton
          className={SLIDER_NEXT_BUTTON}
          onClick={handleClickSliderNextButton}
          disabled={curSlideIndex === maxSlideIndex}
        >
          <Icon className={IconFonts.NEXT_BUTTON} />
        </SliderButton>
      </SliderWrapper>
    </CategoryProductsWrapper>
  );
};
