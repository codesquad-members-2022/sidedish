/* eslint-disable jsx-a11y/mouse-events-have-key-events */
/* eslint-disable no-console */
/* eslint-disable jsx-a11y/no-noninteractive-element-interactions */
import React, { useState } from 'react';
import styled from 'styled-components';
import Tag from './Tag';
import Text from './Text';
import HoverInfo from '../images/HoverInfo.png';

export default function Card(props) {
  const { size, imageURL, title, desc, curPrice, prevPrice, tags } = props;
  const [isHoverImg, setHoverImg] = useState(false);
  return (
    <Wrap size={size}>
      <ImgWrap onMouseEnter={() => setHoverImg(true)} onMouseLeave={() => setHoverImg(false)}>
        {getHoverImgBySize()}
        <img src={imageURL} alt="반찬" />
      </ImgWrap>
      {getSpaceBySize()}
      {getTitle()}
      {getDescription()}
      <Prices>
        <Text size="MEDIUM" weight="MEDIUM" value={curPrice} />
        <Text size="BASE" weight="REGULAR" color="GREY3" value={prevPrice} line />
      </Prices>
      <Tags>{getTags()}</Tags>
    </Wrap>
  );

  function getTitle() {
    if (size === 'SMALL') {
      return <Text value={title} />;
    }
    return <Text size="MEDIUM" weight="MEDIUM" value={title} />;
  }

  function getHoverImgBySize() {
    if (size === 'SMALL') return '';
    return <HoverImg isHoverImg={isHoverImg} />;
  }

  function getSpaceBySize() {
    if (size === 'SMALL') {
      return '';
    }
    return <Space />;
  }

  function getDescription() {
    if (size === 'SMALL') {
      return '';
    }
    return <Text size="BASE" weight="REGULAR" color="GREY2" value={desc} />;
  }

  function getTags() {
    if (size === 'SMALL') {
      return '';
    }
    return tags.map(tag => <Tag type={tag} />);
  }
}

Card.defaultProps = {
  size: 'MEDIUM'
};

const Wrap = styled.a({
  width: props => getWidthBySize(props.size),
  height: 'fit-content',
  display: 'flex',
  flexDirection: 'column',
  gap: '8px',
  cursor: 'pointer'
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

function getWidthBySize(size) {
  if (size === 'LARGE') {
    return '411px';
  }
  if (size === 'MEDIUM') {
    return '302px';
  }
  if (size === 'SMALL') {
    return '160px';
  }
  throw new Error('카드의 사이즈가 올바르지 않습니다.');
}
