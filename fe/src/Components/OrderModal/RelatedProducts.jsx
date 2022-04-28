import { useState } from 'react';
import styled from 'styled-components';

import { Fonts, IconFonts } from '@/Constants';
import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { ProductCard } from '@/Components/ProductCard';
import { Slider } from '@/Components/Slider';

/* 슬라이더 */
const SLIDER_MODE = 'page';
const SLIDER_MARGIN = 16;
const SLIDE_VIEW_LENGTH = 5;
const SLIDER_PREV_BUTTON = 'related-products-slider-prev-button';
const SLIDER_NEXT_BUTTON = 'related-products-slider-next-button';
const SLIDER_PAGE_INDEX_WRAPPER = 'related-products-slider-page-index-wrapper';
const SLIDER_CUR_PAGE = 'related-products-slider-cur-page';
const SLIDER_LAST_PAGE = 'related-products-slider-last-page';

const ControllerIcon = styled.i`
  font-size: 18px;
`;

/**********/

const RelatedProductsWrapper = styled.div`
  width: 960px;
  padding: 48px;
  border: 1px solid black;

  .${SLIDER_PREV_BUTTON},
    .${SLIDER_NEXT_BUTTON},
    .${SLIDER_PAGE_INDEX_WRAPPER} {
    position: absolute;
    top: -28px;
  }

  .${SLIDER_PREV_BUTTON}, .${SLIDER_NEXT_BUTTON} {
    display: block;
    width: 24px;
    height: 24px;
  }

  .${SLIDER_PREV_BUTTON} {
    right: 46px;
  }

  .${SLIDER_NEXT_BUTTON} {
    right: -14px;
  }

  .${SLIDER_PAGE_INDEX_WRAPPER} {
    top: -30px;
    display: flex;
    width: 24px;
    height: 24px;
    align-items: center;
    justify-content: center;
    right: 16px;
  }

  .${SLIDER_CUR_PAGE}, .${SLIDER_LAST_PAGE} {
    display: block;
    font-size: 16px;
  }

  .${SLIDER_CUR_PAGE}::after {
    content: "/";
    margin: 0 4px;
  }

`;

const ProductCardList = styled.ul`
  display: inline-flex;
  justify-content: flex-start;
  overflow: hidden;
  margin-top: 28px;
  width: 100%;
`;

export const RelatedProducts = ({ categoryId = 1, productCardSize = 'sm' }) => {
  const [categoryProductsData, isLoaded, isError, setRetry] = useFetch(
    `${API_URL}/categories/${categoryId}/items`
  );

  const [slideRef, setSlideRef] = useState(null);

  if (isError) {
    // TODO: 에러 핸들링
    return <span>다시시도</span>
  }
  
  if (!isLoaded) {
    return <>Loading...</>;
  }

  const relatedProducts = categoryProductsData.result_body;

  return (
    <RelatedProductsWrapper>
      <header className={Fonts.LG_BOLD}>함께하면 더욱 맛있는 상품</header>

      <Slider
        mode={SLIDER_MODE}
        margin={SLIDER_MARGIN}
        slideRef={slideRef}
        animation={false}
        slideViewItemLength={SLIDE_VIEW_LENGTH}
        prevIcon={<ControllerIcon className={IconFonts.PREV_BUTTON} />}
        nextIcon={<ControllerIcon className={IconFonts.NEXT_BUTTON} />}
        prevButtonClassName={SLIDER_PREV_BUTTON}
        nextButtonClassName={SLIDER_NEXT_BUTTON}
        pageIndexWrapperClassName={SLIDER_PAGE_INDEX_WRAPPER}
        curPageIndexClassName={SLIDER_CUR_PAGE}
        lastPageIndexClassName={SLIDER_LAST_PAGE}
      >
        <ProductCardList
          ref={e => {
            setSlideRef(e);
          }}
        >
          {relatedProducts.contents.map(relatedProduct => (
            <ProductCard
              size={productCardSize}
              data={relatedProduct}
              key={relatedProduct.id}
            />
          ))}
        </ProductCardList>
      </Slider>
    </RelatedProductsWrapper>
  );
};
