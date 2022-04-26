import * as S from './Slide.style';
import { CARD_SIZE } from '../../constants/card';
import { SLIDES_PER_VIEW, MARGIN } from '../../constants/slide';
import Card from '../card/Card';
import SmallCard from '../card/SmallCard';
import { useEffect, useState } from 'react';

const SlideCardList = ({ cardSize, cardList, currentPage }) => {
  const [translate, setTranslate] = useState(0);
  const [extraMargin, setExtraMargin] = useState(0);

  const extraCard = cardList.length % SLIDES_PER_VIEW[cardSize];
  const extraRatio = extraCard / SLIDES_PER_VIEW[cardSize] || 1;
  const totalPage = Math.ceil(cardList.length / SLIDES_PER_VIEW[cardSize]);

  const margin = (currentPage - 1) * MARGIN[cardSize] - extraMargin;
  const maxTranslate = 100 * (totalPage - 2) + 100 * extraRatio;

  const getNewCssValues = () => {
    if (currentPage === 1) return [0];
    else if (currentPage === totalPage) return [maxTranslate, (1 - extraRatio) * MARGIN[cardSize]];
    else return (currentPage - 1) * 100 >= translate ? [translate + 100] : [translate - 100];
  };

  useEffect(() => {
    const [newTranslate, newExtraMargin = extraMargin] = getNewCssValues();
    setTranslate(newTranslate);
    setExtraMargin(newExtraMargin);
  }, [currentPage]);

  return (
    <S.CardList translate={translate} margin={margin}>
      {cardList.map(item => {
        switch (cardSize) {
          case CARD_SIZE.SMALL:
            return <SmallCard key={item.menuId} {...item} />;
          default:
            return <Card key={item.menuId} cardSize={cardSize} dish={item} />;
        }
      })}
    </S.CardList>
  );
};

export default SlideCardList;
