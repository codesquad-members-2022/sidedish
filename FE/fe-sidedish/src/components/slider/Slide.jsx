import * as S from './Slide.style';
import { CARD_SIZE } from '../../constants/card';
import { BUTTON_TYPE, FIRST_PAGE, SLIDES_PER_VIEW } from '../../constants/slide';
import SlideCardList from './SlideCardList';
import SlideButton from './SlideButton';
import SlidePagination from './SlidePagination';
import { useState } from 'react';

const Slide = ({ cardSize, cardList }) => {
  const [currentPage, setCurrentPage] = useState(FIRST_PAGE);

  const isSmallSlide = cardSize === CARD_SIZE.SMALL;
  const totalPage = Math.ceil(cardList.length / SLIDES_PER_VIEW[cardSize]);

  const isButtonDisabled = buttonType =>
    buttonType === BUTTON_TYPE.PREV ? currentPage === FIRST_PAGE : currentPage === totalPage;

  const changeCurrentPage = buttonType => () => {
    if (buttonType === BUTTON_TYPE.PREV) setCurrentPage(currentPage - 1);
    else setCurrentPage(currentPage + 1);
  };
  return (
    <S.Container cardSize={cardSize}>
      <S.Wrapper>
        <SlideCardList cardSize={cardSize} cardList={cardList} currentPage={currentPage} />
      </S.Wrapper>
      <S.PaginationContainer>
        <SlideButton
          isButtonDisabled={isButtonDisabled}
          changeCurrentPage={changeCurrentPage(BUTTON_TYPE.PREV)}
          buttonType={BUTTON_TYPE.PREV}
        />
        {isSmallSlide && <SlidePagination currentPage={currentPage} totalPage={totalPage} />}
        <SlideButton
          isButtonDisabled={isButtonDisabled}
          changeCurrentPage={changeCurrentPage(BUTTON_TYPE.NEXT)}
          buttonType={BUTTON_TYPE.NEXT}
        />
      </S.PaginationContainer>
    </S.Container>
  );
};

export default Slide;
