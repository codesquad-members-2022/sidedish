import * as S from './Slide.style';
import { CARD_SIZE } from '../../constants/card';
import {
  BUTTON_TYPE,
  FIRST_PAGE,
  SLIDES_PER_VIEW,
  SMALL_SLIDES_PER_VIEW,
} from '../../constants/slide';
import SlideCardList from './SlideCardList';
import SlideButton from './SlideButton';
import SlidePagination from './SlidePagination';
import { useState } from 'react';

const Slide = ({ cardSize, cardList }) => {
  const [currentPage, setCurrentPage] = useState(FIRST_PAGE);

  const isSmallSlide = cardSize === CARD_SIZE.SMALL;
  const totalPage = isSmallSlide
    ? Math.ceil(cardList.length / SMALL_SLIDES_PER_VIEW)
    : Math.ceil(cardList.length / SLIDES_PER_VIEW);

  return (
    <S.Container cardSize={cardSize}>
      <S.Wrapper>
        <SlideCardList cardSize={cardSize} cardList={cardList} />
      </S.Wrapper>
      <S.PaginationContainer>
        <SlideButton buttonType={BUTTON_TYPE.PREV} />
        {isSmallSlide && <SlidePagination currentPage={currentPage} totalPage={totalPage} />}
        <SlideButton buttonType={BUTTON_TYPE.NEXT} />
      </S.PaginationContainer>
    </S.Container>
  );
};

export default Slide;
