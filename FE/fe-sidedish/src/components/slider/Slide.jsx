import * as S from './Slider.style';
import { CARD_SIZE } from '../../constants/card';
import { ButtonType } from '../../constants/slider';
import SlideButton from './SlideButton';
import Card from '../card/Card';
import SmallCard from '../card/SmallCard';

const Slider = ({ cardSize, cardList }) => {
  return (
    <S.Container>
      <S.Wrapper>
        <S.CardList>
          {cardList.map(item => {
            switch (cardSize) {
              case CARD_SIZE.SMALL:
                return <SmallCard key={item.menuId} {...item} />
              default:
                return <Card key={item.menuId} cardSize={cardSize} dish={item} />
            }
          })}
        </S.CardList>
      </S.Wrapper>
      <SlideButton buttonType={ButtonType.PREV} />
      <SlideButton buttonType={ButtonType.NEXT} />
    </S.Container>
  );
};

export default Slider;
