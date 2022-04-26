import * as S from './Slide.style';
import { CARD_SIZE } from '../../constants/card';
import Card from '../card/Card';
import SmallCard from '../card/SmallCard';

const SlideCardList = ({ cardSize, cardList }) => {
  return (
    <S.CardList>
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
