import styled from 'styled-components';

import colors from '../../constants/colors';
import subContents from '../../mocks/subContents';
import ModalCarouselProvider from '../Carousel/ModalCarouselProvider';
import useCarousel from '../Carousel/useCarousel';
import FoodCards from '../Main/FoodCards';

const FOOD_PER_PAGE = 5;

const RelatedProductWrap = styled.div`
  width: 100%;
  height: 40%;
  background-color: ${colors.offWhite};
`;

const RelatedProduct = () => {
  const maxPage = Math.ceil(subContents[0].foods.length / FOOD_PER_PAGE);

  const getSlideDataByPage = (page) => {
    const startIndex = page * FOOD_PER_PAGE;
    return (
      <FoodCards
        foods={subContents[0].foods.slice(
          startIndex,
          startIndex + FOOD_PER_PAGE,
        )}
        size={FOOD_PER_PAGE}
        type={'modal'}
      />
    );
  };

  const carousel = useCarousel({
    getSlideDataByPage,
    maxPage,
    buttonPrevCss: `
      top: 1.5em;
      right: 7.6em;
    `,
    buttonNextCss: `
    top: 1.5em;
      right: 3.4em;
    `,
  });
  return (
    <RelatedProductWrap>
      <ModalCarouselProvider {...carousel} />
    </RelatedProductWrap>
  );
};
export default RelatedProduct;
