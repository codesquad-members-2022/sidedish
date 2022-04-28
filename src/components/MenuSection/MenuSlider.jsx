import React, { useState } from 'react';
import styled from 'styled-components';
import IconButton from 'components/common/IconButton';
import Card from 'components/common/Card/Card';
import THEME from 'variable/theme';
import slideData from 'components/MenuSection/slideMockData';

// TODO: Ref로 받아와서 저장할 것.
const sliderInfo = {
  size_px: {
    cardWidth: 302,
    gap: 24
  },
  visibleLength: 4
};

export default function MenuSlider({ setClickedCard }) {
  const [curSlideIdx, setCurSlideIdx] = useState(0);
  const [isMoving, setMoving] = useState(false);
  const isFirstSlide = curSlideIdx <= 0;
  const isLastSlide = curSlideIdx >= slideData.length - sliderInfo.visibleLength;

  return (
    <Wrap>
      <Slider>
        <ButtonWrap>
          <IconButton
            onClick={handleMovementToPrev}
            as="button"
            icon="prev"
            width="11px"
            height="20px"
            stroke={isFirstSlide ? THEME.COLOR.GREY[300] : THEME.COLOR.BLACK[100]}
            disabled={isMoving}
          />
          <IconButton
            onClick={handleMovementToNext}
            as="button"
            icon="next"
            width="11px"
            height="20px"
            stroke={isLastSlide ? THEME.COLOR.GREY[300] : THEME.COLOR.BLACK[100]}
            disabled={isMoving}
          />
        </ButtonWrap>
        <Slides
          // onTransitionstart={() => setMoving(true)} // 왜 안되지?
          onTransitionEnd={() => setMoving(false)}
          curSlideIdx={curSlideIdx}
        >
          {slideData.map(({ size, imageURL, title, desc, curPrice, prevPrice, tags }) => (
            <li key={title}>
              <Card
                setClickedCard={setClickedCard}
                size={size}
                imageURL={imageURL}
                title={title}
                desc={desc}
                curPrice={curPrice}
                prevPrice={prevPrice}
                tags={tags}
              />
            </li>
          ))}
        </Slides>
      </Slider>
    </Wrap>
  );

  function handleMovementToPrev() {
    const newCurSlideIdx = decreaseCurSlideIndex();
    setCurSlideIdx(newCurSlideIdx);
    disableButton();
  }

  function handleMovementToNext() {
    const newCurSlideIdx = increaseCurSlideIndex();
    setCurSlideIdx(newCurSlideIdx);
    disableButton();
  }

  function decreaseCurSlideIndex() {
    if (isFirstSlide) {
      return 0;
    }
    return curSlideIdx - sliderInfo.visibleLength;
  }

  function increaseCurSlideIndex() {
    if (isLastSlide) {
      return curSlideIdx;
    }
    setMoving(true);
    return curSlideIdx + sliderInfo.visibleLength;
  }

  function disableButton() {
    if (isFirstSlide || isLastSlide) return;
    setMoving(true);
  }
}

const Wrap = styled.div({
  position: 'relative'
});

const Slider = styled.div({
  overflow: 'hidden'
});

const Slides = styled.ul({
  display: 'flex',
  gap: '24px',
  transform: ({ curSlideIdx }) => {
    const SLIDE_WIDTH = sliderInfo.size_px.cardWidth + sliderInfo.size_px.gap;
    return `translateX(${-SLIDE_WIDTH * curSlideIdx}px)`;
  },
  transition: 'transform 0.5s ease-out'
});

const ButtonWrap = styled.div({
  display: 'flex',
  justifyContent: 'space-between',
  width: 'calc(100% + 100px)',
  position: 'absolute',
  top: '50%',
  left: 0,
  margin: '0 -50px',
  transform: 'translateY(-50%)'
});
