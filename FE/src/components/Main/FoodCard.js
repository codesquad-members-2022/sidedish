import { useContext } from 'react';
import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import modalFoods from '../../mocks/modalFoods';
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
      ModalInfo.setCardInfo({ ...food, ...modalFoods[food.detail_hash] });
      ModalInfo.setThumbImg(modalFoods[food.detail_hash].thumb_images);
      ModalInfo.setTopImg(food.image);
      ModalInfo.setModalDisplay('block');
    }
  };
  return (
    <CardWrap onClick={onCardClick}>
      <CardImg src={food.image} alt={food.alt} />
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
          {food.s_price}
        </Text>
        <OriginPrice font={type === 'modal' ? FONT.XSMALL : FONT.SMALL}>
          {food.n_price}
        </OriginPrice>
      </CardText>
      <BadgeWrap type={type}>
        {food?.badge?.map((badgeName, idx) => (
          <Tag key={badgeName + idx} badge={badgeName} />
        ))}
      </BadgeWrap>
    </CardWrap>
  );
};
export default FoodCard;
