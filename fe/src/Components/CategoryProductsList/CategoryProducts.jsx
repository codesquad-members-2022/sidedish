import { useRef, useEffect } from 'react';
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
const SLIDE = 'slide-container';
const SLIDER_PREV_BUTTON = 'slider-prev-button';
const SLIDER_NEXT_BUTTON = 'slider-next-button';

const SliderWrapper = styled.div`
  width: 100%;
  position: relative;
`;

const Slider = styled.div`
  width: 100%;
  overflow: hidden;

  .${SLIDE} {
    transition: transform 250ms ease-in-out;
    
    > * {
      margin-right: ${({ margin = 24 }) => margin}px;
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
  const productCardRef = useRef(null);

  const handleClickRetryButton = () => {
    setRetry(true);
  };

  useEffect(() => {
    if (!isLoaded) return;
    console.log(productCardRef.current.clientWidth);
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
        <Slider margin={24}>
          <ProductCardList className={SLIDE} ref={productCardRef}>
            {parsedCategoryProductsData.content.map(categoryProductData => (
              <ProductCard
                size={'md'}
                data={categoryProductData}
                key={categoryProductData.id}
              />
            ))}
          </ProductCardList>
          <SliderButton className={SLIDER_PREV_BUTTON}>
            <Icon className={IconFonts.PREV_BUTTON} />
          </SliderButton>
          <SliderButton className={SLIDER_NEXT_BUTTON}>
            <Icon className={IconFonts.NEXT_BUTTON} />
          </SliderButton>
        </Slider>
      </SliderWrapper>
    </CategoryProductsWrapper>
  );
};
