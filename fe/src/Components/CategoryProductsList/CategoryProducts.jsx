import { useState, useRef, useEffect } from 'react';
import styled from 'styled-components';

import { IconFonts, Fonts } from '@/Constants';
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
      ${props => -(props.curSlideIndex * props.slideUnitWidth)}px,
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
    console.log(2222);
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

const parse = categoryProductsData => {
  const title = categoryProductsData.content[0].mainCategory;
  return {
    title,
    content: categoryProductsData.content,
  };
};

export const CategoryProducts = props => {
  const categoryId = props.categoryId;
  const [categoryProductsData, isLoaded, isError, setRetry] = useFetch(
    `/category/${categoryId}`
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

  if (isError) return <RetryButton onClick={handleClickRetryButton} />;
  if (!isLoaded) return <LoadingSpinner />;

  /* 임시: API 나오면 아마 삭제될 것 같습니다 */
  const parsedCategoryProductsData = parse(categoryProductsData);

  return (
    <CategoryProductsWrapper>
      <Header className={Fonts.XL_BOLD}>
        {parsedCategoryProductsData.title}
      </Header>
      <SliderWrapper>
        <Slider
          margin={SLIDE_MARGIN}
          slideUnitWidth={slideUnitWidth}
          curSlideIndex={curSlideIndex}
        >
          <ProductCardList className={SLIDE_CONTAINER} ref={slideRef}>
            {parsedCategoryProductsData.content.map(categoryProductData => (
              <ProductCard
                size={'md'}
                data={categoryProductData}
                key={categoryProductData.id}
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
