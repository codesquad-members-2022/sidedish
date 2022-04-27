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

export default function MenuSlider() {
  const [curSlideIdx, setCurSlideIdx] = useState(0);
  const isFirstSlide = curSlideIdx === 0;
  const isLastSlide = curSlideIdx === slideData.length - sliderInfo.visibleLength;

  return (
    <Wrap>
      <Slider>
        <Slides curSlideIdx={curSlideIdx}>
          {slideData.map(({ size, imageURL, title, desc, curPrice, prevPrice, tags }) => (
            <li key={title}>
              <Card
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
        <ButtonWrap>
          <IconButton
            onClick={handleMovementToPrev}
            as="button"
            icon="prev"
            width="11px"
            height="20px"
            stroke={isFirstSlide ? THEME.COLOR.BLACK[100] : THEME.COLOR.GREY[300]}
          />
          <IconButton
            onClick={handleMovementToNext}
            as="button"
            icon="next"
            width="11px"
            height="20px"
            stroke={isLastSlide ? THEME.COLOR.BLACK[100] : THEME.COLOR.GREY[300]}
          />
        </ButtonWrap>
      </Slider>
    </Wrap>
  );
  function handleMovementToPrev() {
    const newCurSlideIdx = moveSlideToLeft();
    setCurSlideIdx(newCurSlideIdx);
  }

  function handleMovementToNext() {
    const newCurSlideIdx = moveSlideToRight();
    setCurSlideIdx(newCurSlideIdx);
  }
  function moveSlideToLeft() {
    if (isFirstSlide) {
      return 0;
    }
    return curSlideIdx - sliderInfo.visibleLength;
  }
  function moveSlideToRight() {
    if (isLastSlide) {
      return curSlideIdx;
    }
    return curSlideIdx + sliderInfo.visibleLength;
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
