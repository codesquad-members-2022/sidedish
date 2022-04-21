import { Category } from './Category';
import Colors from '../Constants/Colors';
import styled from 'styled-components';
import { useState, useEffect } from 'react';

const CategoryListWrapper = styled.ul`
  margin-top: 56px;
`;

const MoreButtonWrapper = styled.div`
  width: 100%;
  display: flex;
  margin: 56px 0;
  justify-content: center;
`;

const Button = styled.button`
  padding: 16px 24px;
  margin: 0 auto;
  border: 1px solid ${Colors.PALE_GREY};
  color: ${Colors.DARK_GREY};
  transition: all 200ms;

  &:hover {
    background-color: ${Colors.DARK_GREY};
    color: ${Colors.WHITE};
  }

  &:active {
    opacity: 0.5;
  }
`;

const MoreButton = ({ handleClick }) => {
  return (
    <MoreButtonWrapper className={'fonts-lg'}>
      <Button onClick={handleClick}>모든 카테고리 보기</Button>
    </MoreButtonWrapper>
  );
};

export const CategoryList = props => {
  const [moreButtonClicked, setMoreButtonClicked] = useState(false);

  const handleClickMoreButton = () => {
    setMoreButtonClicked(true);
  };

  useEffect(() => {
    console.log(props.loadedCategories);
  }, []);

  // useEffect(() => {
  //   if (!moreButtonClicked) return;
  //   // Promise.all 로 남은 카테고리 모두 가져온 뒤 update
  //   fetch('/')
  //     .then(() => {})
  //     .then(() => {});
  // }, [moreButtonClicked]);

  return (
    <CategoryListWrapper>
      {props.loadedCategories.map(category => {
        return (
          <Category
            key={category.id}
            title={category.title}
            cardData={category.content}
          />
        );
      })}
      {!moreButtonClicked && <MoreButton handleClick={handleClickMoreButton} />}
    </CategoryListWrapper>
  );
};
