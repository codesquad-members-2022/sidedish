import * as S from './Category.style';
import Card from '../card/Card';
import Slider from '../slider/Slider';

const Category = ({ category, categoryList }) => {

  return (
    <S.Container>
      <S.Wrapper>
        <S.Title>{category}</S.Title>
        <Slider>
          <S.CardList>
            {categoryList.map(dish => <Card key={dish.menuId} dish={dish} />)}
          </S.CardList>
        </Slider>
      </S.Wrapper>
    </S.Container>
  );
};

export default Category;
