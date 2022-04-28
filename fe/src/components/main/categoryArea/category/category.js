import { useState } from 'react';
import { ProductCard } from '../../../../common/productCard/ProductCard';
import { buttonIcons } from '../../../../helper/constants';
import {
  CategoryWrapper,
  CategoryTitle,
  CategoryCardWrapper,
  LeftButton,
  RightButton,
  CardArea,
  MoveArea,
} from './category.styled';

export function Category({ title, sideDishCardResponses }) {
  const [positionState, setPositionState] = useState({
    left: 0,
    right: Math.min(sideDishCardResponses.length, 3),
    diff: 0,
  });
  const [transitionState, setTransitionState] = useState(true);

  function handleRightClick() {
    const diff = Math.min(sideDishCardResponses.length - 1 - positionState.right, 4);
    if (!transitionState || diff === 0) {
      return;
    }
    setTransitionState(false);
    setPositionState({ left: positionState.left + diff, right: positionState.right + diff, diff: diff });
  }

  function handleLeftClick() {
    const diff = Math.min(positionState.left, 4);
    if (!transitionState || diff === 0) {
      return;
    }
    setTransitionState(false);
    setPositionState({ left: positionState.left - diff, right: positionState.right - diff, diff: diff });
  }

  function handleTransitionEnd() {
    setTransitionState(true);
  }

  return (
    <CategoryWrapper>
      <CategoryTitle>{title}</CategoryTitle>
      <CategoryCardWrapper flex>
        <LeftButton leftPosition={positionState.left} targetPosition={0} onClick={handleLeftClick}>
          {buttonIcons.left}
        </LeftButton>
        <CardArea>
          <MoveArea flex position={positionState} onTransitionEnd={handleTransitionEnd}>
            {sideDishCardResponses.map((product, idx) => {
              return <ProductCard product={product} size="medium" key={idx}></ProductCard>;
            })}
          </MoveArea>
        </CardArea>
        <RightButton
          rightPosition={positionState.right}
          targetPosition={sideDishCardResponses.length - 1}
          onClick={handleRightClick}
        >
          {buttonIcons.right}
        </RightButton>
      </CategoryCardWrapper>
    </CategoryWrapper>
  );
}
