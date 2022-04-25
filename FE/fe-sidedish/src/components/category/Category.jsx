import * as S from './Category.style';
import { CARD_SIZE } from '../../constants/card';
import Slide from '../slider/Slide';

const Category = ({ category, categoryList }) => {

  return (
    <S.Container>
      <S.Wrapper>
        <S.Title>{category}</S.Title>
        <Slide cardSize={CARD_SIZE.MEDIUM} cardList={categoryList} />
      </S.Wrapper>
    </S.Container>
  );
};

export default Category;
