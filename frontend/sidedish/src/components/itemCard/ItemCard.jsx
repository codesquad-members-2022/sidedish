import styled from "styled-components";
import { LABEL_ATTRIBUTES, URL } from "../../consts/constants";
import Label from "../../core/Label";
import fetchData from "../../util/fetchData";
import { makePriceFormat } from "../../util/makePriceFormat";

const ItemCard = ({
  cardClickState,
  setCardClickState,
  setCardInfoState,
  dishId,
  image,
  title,
  description,
  originPrice,
  currentPrice,
  badge,
  cardLength,
  cardMargin,
}) => {
  const labelList = badge.map((string, ind) => {
    return string === "런칭특가" ? (
      <Label key={ind} {...LABEL_ATTRIBUTES.LAUNCH} />
    ) : (
      <Label key={ind} {...LABEL_ATTRIBUTES.EVENT} />
    );
  });

  const handleCardClick = async (event, dishId) => {
    const menuDetail = await fetchData(`${URL}/detail/${dishId}`);
    setCardClickState(!cardClickState);
    setCardInfoState(menuDetail);
  };

  return (
    <Card onClick={(event) => handleCardClick(event, dishId)} cardMargin={cardMargin}>
      <MenuCardImg src={image} alt={title} cardLength={cardLength} />
      <MenuTitle>{title}</MenuTitle>
      <MenuDescription>{description}</MenuDescription>
      <Price>
        <SalePrice>{makePriceFormat(currentPrice)}</SalePrice>
        <MenuPrice>{makePriceFormat(originPrice)}</MenuPrice>
      </Price>
      {labelList}
    </Card>
  );
};

const Card = styled.div`
  margin: 0 ${(props) => props.cardMargin}px;
  cursor: pointer;
`;

const MenuCardImg = styled.img`
  width: ${(props) => props.cardLength}px;
  height: ${(props) => props.cardLength}px;
  margin-bottom: 16px;
`;

const MenuTitle = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  color: #3f3f3f;
  margin-bottom: 8px;
`;

const MenuDescription = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  color: #777777;
  margin-bottom: 8px;
`;

const Price = styled.div`
  display: flex;
  margin-bottom: 8px;
`;

const SalePrice = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  color: #1b1b1b;
  padding-right: 8px;
`;

const MenuPrice = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  align-items: center;
  text-decoration-line: line-through;
  color: #bcbcbc;
`;
export default ItemCard;
