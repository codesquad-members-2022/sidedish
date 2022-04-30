import { useContext } from 'react';
import styled from 'styled-components';

import { moneyToWon } from '../../common/utils';
import BADGE from '../../constants/badge';
import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import Tag from '../Tag';
import Text from '../Text';

const CardWrap = styled.li`
  padding: 10px;
`;

const CardImg = styled.img`
  width: 100%;
  margin-bottom: 8px;
`;

const CardText = styled.div`
  margin: 8px 0px;
`;

const CardDescription = styled.div`
  margin: 8px 0px;
  display: ${(props) => (props.type === 'modal' ? 'none' : 'block')};
`;

const OriginPrice = styled(Text)`
  margin-left: 8px;
  color: ${colors.greyThree};
  text-decoration: line-through;
`;

const BadgeWrap = styled.div`
  display: ${(props) => (props.type === 'modal' ? 'none' : 'flex')};
`;

const FoodCard = ({ food, type = '' }) => {
  const ModalInfo = useContext(ModalInfoContextStore);

  const onCardClick = () => {
    if (ModalInfo.modalDisplay === 'none') {
      ModalInfo.setModalDetail('food');
      ModalInfo.setCardInfo(food);
      ModalInfo.setThumbImg([food.images.sideOne, food.images.sideTwo]);
      ModalInfo.setTopImg(food.images.mainUrl);
      ModalInfo.setModalDisplay('block');
    }
  };

  const displayPrice = food.discountPrice ? food.discountPrice : food.price;
  const originPrice = food.price ? food.price : '';

  return (
    <CardWrap onClick={onCardClick}>
      <CardImg src={food.images.mainUrl} alt={food.title} />
      <CardText>
        <Text font={type === 'modal' ? FONT.XSMALL : FONT.MEDIUM_BOLD}>
          {food.title}
        </Text>
      </CardText>
      <CardDescription type={type}>
        <Text font={FONT.SMALL} textColor={colors.greyTwo}>
          {food.description}
        </Text>
      </CardDescription>
      <CardText>
        <Text font={type === 'modal' ? FONT.SMALL_BOLD : FONT.MEDIUM_BOLD}>
          {moneyToWon(displayPrice)}
        </Text>
        <OriginPrice font={type === 'modal' ? FONT.XSMALL : FONT.SMALL}>
          {moneyToWon(originPrice)}
        </OriginPrice>
      </CardText>
      <BadgeWrap type={type}>
        <Tag badge={BADGE[food.badge]} />
      </BadgeWrap>
    </CardWrap>
  );
};
export default FoodCard;
