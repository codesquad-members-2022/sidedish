import React, { useState } from 'react';
import styled from 'styled-components';
import IconButton from 'components/common/IconButton';
import Card from 'components/common/Card/Card';
import THEME from 'variable/theme';

// 수정
const cardsInfo = [
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리1',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리2',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리3',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리4',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리5',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리6',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리7',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  },
  {
    size: 'MEDIUM',
    imageURL: 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg',
    title: '오리 주물럭_반조리8',
    desc: '감질맛 나는 매콤한 양념',
    curPrice: '12,640원',
    prevPrice: '15,800원',
    tags: ['이벤트특가', '런칭특가']
  }
];

export default function MenuSlider() {
  const [curSlideIdx, setCurSlideIdx] = useState(0);

  return (
    <Wrap>
      <Slider>
        <Slides curSlideIdx={curSlideIdx}>
          {cardsInfo.map(({ size, imageURL, title, desc, curPrice, prevPrice, tags }, index) => (
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
            stroke={THEME.COLOR.BLACK[100]}
          />
          <IconButton
            onClick={handleMovementToNext}
            as="button"
            icon="next"
            width="11px"
            height="20px"
            stroke={THEME.COLOR.BLACK[100]}
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
      // 버튼 회색으로 추가
      return 0;
    }
    return curSlideIdx - 1;
  }
  function moveSlideToRight() {
    const isLastSlide = curSlideIdx === cardsInfo.length - 1;
    if (isLastSlide) {
      // 버튼 회색으로 추가
      // 디바운스 추가
      return cardsInfo.length - 1;
    }
    return curSlideIdx + 1;
  }
}

const Wrap = styled.div({
  position: 'relative'
});

const Slider = styled.div({
  margin: '0 50px',
  overflow: 'hidden'
});

const Slides = styled.ul`
  display: flex;
  gap: 24px;
  transform: translateX(${({ curSlideIdx }) => (-100 / 4) * curSlideIdx}%); // 수정
  transition: transform 0.3s ease-in-out;
`;

const ButtonWrap = styled.div({
  display: 'flex',
  justifyContent: 'space-between',
  width: '100%',
  position: 'absolute',
  top: '50%',
  left: 0,
  transform: 'translateY(-50%)'
});
