/* eslint-disable react/no-unstable-nested-components */
import React, { useState } from 'react';
import styled from 'styled-components';
import Tag from './Tag';
import Text from './Text';
import HoverInfo from '../images/HoverInfo.png';

export default function Card({ size, imageURL, title, desc, curPrice, prevPrice, tags }) {
  const [isHoverImg, setHoverImg] = useState(false);
  const isSmall = size === 'SMALL';
  return (
    <Wrap size={size}>
      <A>
        <ImgWrap onMouseEnter={() => setHoverImg(true)} onMouseLeave={() => setHoverImg(false)}>
          {HoverImg()}
          <img src={imageURL} alt="반찬" />
        </ImgWrap>
        {Space()}
        <Title />
        {Description()}
        <Prices>
          <Text size="MEDIUM" weight="MEDIUM" value={curPrice} />
          <Text size="BASE" weight="REGULAR" color="GREY3" value={prevPrice} line />
        </Prices>
      </A>
      <TagWrap>{Tags()}</TagWrap>
    </Wrap>
  );

  function Title() {
    if (isSmall) {
      return <Text value={title} />;
    }
    return <Text size="MEDIUM" weight="MEDIUM" value={title} />;
  }

  function HoverImg() {
    if (isSmall) return null;
    return <DeliveryInfo isHoverImg={isHoverImg} />;
  }

  function Space() {
    if (isSmall) return null;
    return <div />;
  }

  function Description() {
    if (isSmall) return null;
    return <Text size="BASE" weight="REGULAR" color="GREY2" value={desc} />;
  }

  function Tags() {
    if (isSmall) return null;
    return tags.map(tag => <Tag type={tag} />);
  }
}

Card.defaultProps = {
  size: 'MEDIUM'
};

const Wrap = styled.div({
  width: props => getWidthBySize(props.size),
  height: 'fit-content',
  display: 'flex',
  flexDirection: 'column',
  gap: '8px'
});

function getWidthBySize(size) {
  const CARD_SIZE = {
    LARGE: '411px',
    MEDIUM: '302px',
    SMALL: '160px'
  };
  try {
    return CARD_SIZE[size];
  } catch (error) {
    throw new Error('카드의 사이즈가 올바르지 않습니다.', error);
  }
}

const A = styled.a({
  cursor: 'pointer',
  display: 'flex',
  flexDirection: 'column',
  gap: '8px'
});

const ImgWrap = styled.div({
  position: 'relative'
});

const Prices = styled.div({
  display: 'flex',
  gap: '8px',
  alignItems: 'center'
});

const TagWrap = styled.div({
  display: 'flex',
  gap: '8px',
  marginTop: '8px'
});

const DeliveryInfo = styled.div({
  width: '142px',
  height: '149px',
  backgroundImage: `url(${HoverInfo})`,
  backgroundSize: 'cover',
  position: 'absolute',
  top: '20px',
  right: '20px',
  alignSelf: 'end',
  display: props => (props.isHoverImg ? 'block' : 'none')
});
