import React from "react";
import styled, { css } from "styled-components";

const CardImg = styled.img`
  width: 411px;
  height: 411px;
  ${(props) =>
    props.size === "small"
      ? css`
          width: 302px;
          height: 302px;
        `
      : css`
          wdith: 411px;
          height: 411px;
        `}
`;

const CardTitle = styled.h4`
  font-size: 18px;
  margin-top: 5px;
`;

const CardDesc = styled.p`
  font-size: 16px;
  margin: 5px 0;
  color: #777;
`;

const CardOriginalPrice = styled.span`
  text-decoration: line-through;
  color: #777;
  font-size: 14px;
  margin-left: 10px;
`;

const CardBadgeWapper = styled.div`
  display: flex;
`;

const CardBadge = styled.div`
  height: 30px;
  line-height: 30px;
  border-radius: 20px;
  color: #fff;
  text-align: center;
  margin-top: 10px;
  margin-right: 10px;
  padding: 0 10px;

  ${(props) =>
    props.children === "런칭특가"
      ? css`
          background: #ff8e14;
        `
      : css`
          background: #6dd028;
        `}
`;

const CardWrapper = styled.div`
  margin-right: 18px;
`;

const Card = (props) => {
  return (
    <CardWrapper>
      <CardImg src={props.image} alt={props.alt} size={props.size} />
      <CardTitle>{props.title}</CardTitle>
      <CardDesc>{props.description}</CardDesc>
      <span>{props.s_price}</span>
      <CardOriginalPrice>{props.n_price}</CardOriginalPrice>
      <CardBadgeWapper>
        {!props.badge
          ? ""
          : props.badge.map((v) => <CardBadge info={v}>{v}</CardBadge>)}
      </CardBadgeWapper>
    </CardWrapper>
  );
};

export default Card;
