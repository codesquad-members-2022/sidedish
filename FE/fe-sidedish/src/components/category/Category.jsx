import { Container, Wrapper, Title, CardList } from './Category.style';
import Card from '../card/Card';
import Slider from '../slider/Slider';

const Category = ({ category, categoryList }) => {

  return (
    <Container>
      <Wrapper>
        <Title>{category}</Title>
        <Slider>
          <CardList>
            {categoryList.map(dish => <Card key={dish.menuId} dish={dish} />)}
          </CardList>
        </Slider>
      </Wrapper>
    </Container>
  );
};

export default Category;
