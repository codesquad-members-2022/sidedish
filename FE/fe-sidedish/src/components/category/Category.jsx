import { Container, Wrapper, Title, Slide, SlideWrapper, SlideButton, CardList } from './Category.style';
import Card from '../card/Card';
import { ReactComponent as Prev } from "../../asset/icons/left.svg";
import { ReactComponent as Next } from "../../asset/icons/right.svg";

export const ButtonType = {
  PREV: 'prev',
  NEXT: 'next',
};

const Category = ({ category, categoryList }) => {

  return (
    <Container>
      <Wrapper>
        <Title>{category}</Title>
        <Slide>
          <SlideWrapper>
            <CardList>
              {categoryList.map(dish => <Card key={dish.menuId} dish={dish} />)}
            </CardList>
          </SlideWrapper>
          <SlideButton type={ButtonType.PREV}>
            이전
            <Prev />
          </SlideButton>
          <SlideButton type={ButtonType.NEXT}>
            다음
            <Next />
          </SlideButton>
        </Slide>
      </Wrapper>
    </Container>
  );
};

export default Category;
