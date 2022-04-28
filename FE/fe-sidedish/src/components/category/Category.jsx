import * as S from './Category.style';
import Slide from '../slider/Slide';

const Category = ({ cardSize, category, categoryList }) => {
  return (
    <S.Container cardSize={cardSize}>
      <S.Wrapper>
        <S.Title>{category}</S.Title>
        <Slide cardSize={cardSize} cardList={categoryList} />
      </S.Wrapper>
    </S.Container>
  );
};

export default Category;
