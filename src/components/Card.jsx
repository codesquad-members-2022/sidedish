import React, { useState } from 'react';
import styled from 'styled-components';
import Tag from './Tag';
import Text from './Text';
import HoverInfo from '../images/HoverInfo.png';

export default function Card(props) {
  const { size, imageURL, title, desc, curPrice, prevPrice, tags } = props;
  const [isHoverImg, setHoverImg] = useState(false);
  const isSmall = size === 'SMALL';
  return (
    <Wrap size={size}>
      <A>
        <ImgWrap onMouseEnter={() => setHoverImg(true)} onMouseLeave={() => setHoverImg(false)}>
          {getHoverImgBySize()}
          <img src={imageURL} alt="반찬" />
        </ImgWrap>
        {getSpaceBySize()}
        {getTitle()}
        {getDescriptionBySize()}
        <Prices>
          <Text size="MEDIUM" weight="MEDIUM" value={curPrice} />
          <Text size="BASE" weight="REGULAR" color="GREY3" value={prevPrice} line />
        </Prices>
      </A>
      <Tags>{getTags()}</Tags>
    </Wrap>
  );

  function getTitle() {
    if (isSmall) {
      return <Text value={title} />;
    }
    return <Text size="MEDIUM" weight="MEDIUM" value={title} />;
  }

  function getHoverImgBySize() {
    if (isSmall) return null;
    return <HoverImg isHoverImg={isHoverImg} />;
  }

  function getSpaceBySize() {
    if (isSmall) return null;
    return <Space />;
  }

  function getDescriptionBySize() {
    if (isSmall) return null;
    return <Text size="BASE" weight="REGULAR" color="GREY2" value={desc} />;
  }

  function getTags() {
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

const Tags = styled.div({
  display: 'flex',
  gap: '8px',
  marginTop: '8px'
});

const Space = styled.div({});

const HoverImg = styled.div({
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
