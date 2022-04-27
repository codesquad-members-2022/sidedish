import React, { useState } from 'react';
import styled from 'styled-components';
import IconButton from 'components/common/IconButton';
import Card from 'components/common/Card/Card';
import THEME from 'variable/theme';
import slideData from 'components/MenuSection/slideMockData'; // 수정

// TODO
const sliderInfo = {
  size_px: {
    cardWidth: 302,
    gap: 24
  },
  visibleLength: 4
};

export default function MenuSlider() {
  const [curSlideIdx, setCurSlideIdx] = useState(0);
  const [canMovePrev, setMovePrev] = useState(false);
  const [canMoveNext, setMoveNext] = useState(true); // TODO: 슬라이드 개수가 4개 이하 일떄는?

  return (
    <Wrap>
      <Slider>
        <Slides curSlideIdx={curSlideIdx}>
          {slideData.map(({ size, imageURL, title, desc, curPrice, prevPrice, tags }, index) => (
            <li key={`${title}_${index}`}>
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
            stroke={canMovePrev ? THEME.COLOR.BLACK[100] : THEME.COLOR.GREY[300]}
          />
          <IconButton
            onClick={handleMovementToNext}
            as="button"
            icon="next"
            width="11px"
            height="20px"
            stroke={canMoveNext ? THEME.COLOR.BLACK[100] : THEME.COLOR.GREY[300]}
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
    const isFirstSlide = curSlideIdx === 0;
    if (isFirstSlide) {
      setMovePrev(false);
      return 0;
    }
    setMovePrev(true);
    return curSlideIdx - sliderInfo.visibleLength;
  }
  function moveSlideToRight() {
    const isLastSlide = curSlideIdx === slideData.length - sliderInfo.visibleLength;
    if (isLastSlide) {
      setMoveNext(false);
      return curSlideIdx;
    }
    // 디바운스 추가
    setMoveNext(true);
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
