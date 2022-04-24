import { Container } from "./Exhibition.style";
import ExhibitionTitle from "./ExhibitionTitle";
import TapBar from "./TapBar";
import DishList from "./DishList";
import { dish3 } from "../../data/dishes";

const Exhibition = () => {
  return (
    <Container>
      <ExhibitionTitle
        badge={"기획전"}
        title={"한 번 주문하면 두 번 반하는 반찬"}
      />
      <TapBar />
      <DishList dishesData={dish3} />
    </Container>
  );
};

export default Exhibition;
