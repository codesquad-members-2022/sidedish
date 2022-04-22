import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
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

const OriginPrice = styled(Text)`
  margin-left: 8px;
  color: ${colors.greyThree};
  text-decoration: line-through;
`;

const BadgeWrap = styled.div`
  display: flex;
`;

const FoodCard = ({ food }) => (
  <CardWrap>
    <CardImg src={food.image} alt={food.alt} />
    <CardText>
      <Text font={FONT.MEDIUM_BOLD}>{food.title}</Text>
    </CardText>
    <CardText>
      <Text font={FONT.SMALL} textColor={colors.greyTwo}>
        {food.description}
      </Text>
    </CardText>
    <CardText>
      <Text font={FONT.MEDIUM_BOLD}>{food.s_price}</Text>
      <OriginPrice font={FONT.SMALL}>{food.n_price}</OriginPrice>
    </CardText>
    <BadgeWrap>
      {food?.badge?.map((badgeName, idx) => (
        <Tag key={badgeName + idx} badge={badgeName} />
      ))}
    </BadgeWrap>
  </CardWrap>
);

export default FoodCard;
