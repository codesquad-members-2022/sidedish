import styled from 'styled-components';
import FoodList from './food/List';
import { FOOD_DATA } from '../../Store/foodData';
import { Inner } from '../../Assets/CommonStyle';
import Title from '../Title';
import SlideButton from '../SlideButton';
import { useEffect, useState, useRef } from 'react';

const CategoryContainer = styled.section`
  padding-top: 56px;
`;

const CategoryArticle = styled.article`
  margin-bottom: 79px;
`;

const SlideWrapper = styled.div`
  position: relative;
  margin-top: 40px;
`;

const ListContainer = styled.section`
  overflow: hidden;
`;

const CategoryButton = styled.button`
  display: block;
  width: 203px;
  height: 62px;
  margin: 56px auto;
  border: 1px solid ${({ theme }) => theme.Color.gray4};
  font-size: ${({ theme }) => theme.FontSize.Large};
  font-weight: ${({ theme }) => theme.FontWeight.Regular};
  color: ${({ theme }) => theme.Color.gray1};
`;

export function Category({ info }) {
  const [isViewAll, setView] = useState(false);
  const [viewCategory, setViewCategory] = useState([info[0]]);

  const categoryViewHandler = () => {
    setView(true);
    setViewCategory(info);
  };

  const Categories = viewCategory.map((category) => {
    return <CategoryItem category={category} key={category.path} />;
  });

  return (
    <CategoryContainer>
      {Categories}
      {!isViewAll ? (
        <CategoryButton onClick={categoryViewHandler}>
          모든 카테고리 보기
        </CategoryButton>
      ) : null}
    </CategoryContainer>
  );
}

function CategoryItem({ category }) {
  const Food = FOOD_DATA[category.path].body;

  const TOTAL_CARD_COUNT = Food.length;
  const INIT_VIEW_START = 0;
  const INIT_VIEW_END = category.viewItemCount - 1;

  const [slideStartNum, setStartNum] = useState(INIT_VIEW_START);
  const [slideEndNum, setEndNum] = useState(INIT_VIEW_END);
  const [isPrevDisabled, setPrevDisabled] = useState(true);
  const [isNextDisabled, setNextDisabled] = useState(
    TOTAL_CARD_COUNT <= category.viewItemCount
  );

  const MOVE_SIZE = 100 / category.viewItemCount;
  const [slideMoveSize, setMoveSize] = useState(INIT_VIEW_START);
  const SLIDER = useRef(null);

  useEffect(() => {
    setMoveSize(slideStartNum * MOVE_SIZE);
    SLIDER.current.style.transform = `translateX(${-slideMoveSize}%)`;
  }, [slideStartNum, slideMoveSize]);

  return (
    <CategoryArticle>
      <Inner>
        <Title title={category.title} fontSize="XLarge" fontWeight="Bold" />
        <SlideWrapper>
          <SlideButton
            direction="prev"
            disabled={isPrevDisabled}
            setBtnDisabled={{ prev: setPrevDisabled }}
            Start={{ num: slideStartNum, set: setStartNum }}
            End={{ num: slideEndNum, set: setEndNum }}
            TOTAL_CARD_COUNT={TOTAL_CARD_COUNT}
            viewItemCount={category.viewItemCount}
            INIT_SLIDER_NUM={{ start: INIT_VIEW_START, end: INIT_VIEW_END }}
          />
          <ListContainer>
            <FoodList
              food={Food}
              viewItemCount={category.viewItemCount}
              itemGap="24px"
              slider={SLIDER}
            />
          </ListContainer>
          <SlideButton
            direction="next"
            disabled={isNextDisabled}
            setBtnDisabled={{ next: setNextDisabled }}
            Start={{ num: slideStartNum, set: setStartNum }}
            End={{ num: slideEndNum, set: setEndNum }}
            TOTAL_CARD_COUNT={TOTAL_CARD_COUNT}
            viewItemCount={category.viewItemCount}
            INIT_SLIDER_NUM={{ start: INIT_VIEW_START, end: INIT_VIEW_END }}
          />
        </SlideWrapper>
      </Inner>
    </CategoryArticle>
  );
}
