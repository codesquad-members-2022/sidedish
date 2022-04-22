import { DishListWrapper, DishListContainer } from "./Exhibition.style";
import Card from "../card/Card";

const DishList = ({ dishesData }) => {
  return (
    <DishListWrapper>
      <DishListContainer>
        {dishesData.map((dish) => (
          <li key={dish.menuId}>
            <Card cardSize={"large"} dish={dish} />
          </li>
        ))}
      </DishListContainer>
    </DishListWrapper>
  );
};

export default DishList;
