/* eslint-disable react/no-unstable-nested-components */
import React, { useState } from 'react';
import styled from 'styled-components';
import Tag from 'components/common/Card/Tag';
import Text from 'components/utils/Text';
import HoverInfo from 'images/HoverInfo.png';

export default function Card({
  id,
  size,
  imageURL,
  title,
  desc,
  sellingPrice,
  normalPrice,
  tags,
  alt,
  setClickedCard,
  setCardHash
}) {
  const [isHoverImg, setHoverImg] = useState(false);
  const isSizeSmall = size === 'SMALL';
  return (
    <Wrap
      id={id}
      onClick={() => {
        setClickedCard(true);
        setCardHash(id);
      }}
      size={size}
    >
      <A>
        <ImgWrap onMouseEnter={() => setHoverImg(true)} onMouseLeave={() => setHoverImg(false)}>
          {isSizeSmall ? null : <HoverImg />}
          <img width={getWidthBySize(size)} height={getWidthBySize(size)} src={imageURL} alt={alt} />
        </ImgWrap>
        {isSizeSmall ? null : <Space />}
        {isSizeSmall ? <SmallTitle /> : <Title />}
        {isSizeSmall ? null : <Description />}
        <Prices>
          <Text size="MEDIUM" weight="MEDIUM" value={sellingPrice} />
          <Text size="BASE" weight="REGULAR" color="GREY_300" value={normalPrice} line />
        </Prices>
      </A>
      <TagWrap>{isSizeSmall ? null : <Tags />}</TagWrap>
    </Wrap>
  );

  function SmallTitle() {
    return <Text value={title} />;
  }

  function Title() {
    return <Text size="MEDIUM" weight="MEDIUM" value={title} />;
  }

  function HoverImg() {
    return <DeliveryInfo isHoverImg={isHoverImg} />;
  }

  function Space() {
    return <div />;
  }

  function Description() {
    return <Text size="BASE" weight="REGULAR" color="GREY_200" value={desc} />;
  }

  function Tags() {
    return tags && tags.map(tag => <Tag key={tag} type={tag} />);
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
