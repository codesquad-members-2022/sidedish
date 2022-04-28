import { useState } from 'react';
import styled from 'styled-components';

import { IconFonts, Fonts } from '@/Constants';
import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { RetryButton } from '@/Components/Button';
import { LoadingSpinner } from '@/Components/LoadingSpinner';
import { ProductCard } from '@/Components/ProductCard';
import { Slider } from '@/Components/Slider';

/* 슬라이더 */
const SLIDE_VIEW_LENGTH = 4;
const SLIDER_MARGIN = 24;
const SLIDER_PREV_BUTTON = 'slider-prev-button';
const SLIDER_NEXT_BUTTON = 'slider-next-button';
const SLIDER_CUR_PAGE = 'cur-page';
const SLIDER_LAST_PAGE = 'last-page';

const ControllerIcon = styled.i`
  font-size: 24px;
`
/**********/

const CategoryProductsWrapper = styled.li`
  width: 1280px;
  margin-top: 80px;

  &:first-child {
    margin-top: 56px;
  }

  &:last-child {
    margin-bottom: 80px;
  }

  .${SLIDER_PREV_BUTTON} {
    left: -60px;
  }

  .${SLIDER_NEXT_BUTTON} {
    right: -60px;
  }
`;

const Header = styled.header`
  margin-bottom: 40px;
`;

const ProductCardList = styled.ul`
  display: inline-flex;
  justify-content: flex-start;
  overflow: hidden;
  width: 100%;
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

  return (
    <CategoryProductsWrapper>
      <Header className={Fonts.XL_BOLD}>{categoryProducts.title}</Header>

      <Slider
        margin={SLIDER_MARGIN}
        slideRef={mySlideRef}
        animation={true}
        slideViewItemLength={SLIDE_VIEW_LENGTH}
        prevButtonClassName={SLIDER_PREV_BUTTON}
        nextButtonClassName={SLIDER_NEXT_BUTTON}
        prevIcon={<ControllerIcon className={IconFonts.PREV_BUTTON} />}
        nextIcon={<ControllerIcon className={IconFonts.NEXT_BUTTON} />}
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
      </Slider>

      {/* Slider가 없을 때 */}
      {/*<ProductCardList>*/}
      {/*  {categoryProducts.contents.map(categoryProduct => (*/}
      {/*    <ProductCard*/}
      {/*      size={'md'}*/}
      {/*      data={categoryProduct}*/}
      {/*      key={categoryProduct.id}*/}
      {/*    />*/}
      {/*  ))}*/}
      {/*</ProductCardList>*/}
    </CategoryProductsWrapper>
  );
};
