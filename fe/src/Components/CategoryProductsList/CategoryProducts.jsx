import { useState } from 'react';
import styled from 'styled-components';

import { IconFonts, Fonts } from '@/Constants';
import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { RetryButton } from '@/Components/Button';
import { LoadingSpinner } from '@/Components/LoadingSpinner';
import { ProductCard } from '@/Components/ProductCard';
import { MySlider } from '@/Components/Slider';

/* 슬라이더 */
const prevButtonClassName = 'prevButton';
const nextButtonClassName = 'nextButton';
/*const SLIDE_VIEW_LENGTH = 4;
const SLIDE_MARGIN = 24;
const SLIDE_CONTAINER = 'slide-container';
const SLIDER_PREV_BUTTON = 'slider-prev-button';
const SLIDER_NEXT_BUTTON = 'slider-next-button';
/* ****** */

const CategoryProductsWrapper = styled.li`
  width: 1280px;
  margin-top: 80px;

  &:first-child {
    margin-top: 56px;
  }

  &:last-child {
    margin-bottom: 80px;
  }

  .prevButton {
    left: -60px;
  }

  .nextButton {
    right: -60px;
  }
`;

const Header = styled.header`
  margin-bottom: 40px;
`;

const ProductCardList = styled.ul`
  display: inline-flex;
  justify-content: flex-start;
`;

const LS_MARGIN = 300;
const LS_RADIUS = 50;
const LS_BORDER_WIDTH = 10;
const RT_MARGIN = 300;

export const CategoryProducts = ({ categoryId }) => {
  const [categoryProductsData, isLoaded, isError, setRetry] = useFetch(
    `${API_URL}/categories/${categoryId}/items`
  );

  const [mySlideRef, setMySlideRef] = useState(null);

  const handleClickRetryButton = () => {
    setRetry(true);
  };

  if (isError) {
    return <RetryButton onClick={handleClickRetryButton} margin={RT_MARGIN} />;
  }

  if (!isLoaded) {
    return (
      <LoadingSpinner
        margin={LS_MARGIN}
        radius={LS_RADIUS}
        borderWidth={LS_BORDER_WIDTH}
      />
    );
  }

  const categoryProducts = categoryProductsData.result_body;
/*  console.log('slidePageIndex', slidePageIndex);*/
  return (
    <CategoryProductsWrapper>
      <Header className={Fonts.XL_BOLD}>{categoryProducts.title}</Header>

      <MySlider
        margin={0}
        slideRef={mySlideRef}
        animation={true}
        slideViewItemLength={4}
        prevButtonClassName={prevButtonClassName}
        nextButtonClassName={nextButtonClassName}
      >
        <ProductCardList
          ref={e => {
            setMySlideRef(e);
          }}
        >
          {categoryProducts.contents.map(categoryProduct => (
            <ProductCard
              size={'md'}
              data={categoryProduct}
              key={categoryProduct.id}
            />
          ))}
        </ProductCardList>
      </MySlider>
    </CategoryProductsWrapper>
  );
};
