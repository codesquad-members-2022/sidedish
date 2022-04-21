/* eslint-disable prettier/prettier */
import { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";

const cardSize = {
  large: "41.1rem",
  medium: "30.2rem",
  small: "16rem",
};

const Badges = styled.div`
  margin-top: 2.2rem;
`;

const Badge = styled.strong`
  box-sizing: border-box;
  display: inline-block;
  margin-right: 0.8rem;
  padding: 0.6rem 1.6rem;
  height: 3rem;
  text-align: center;
  line-height: 1.8rem;
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  border-radius: 99.9rem;
  background-color: ${({ theme, bgColor }) => theme.color[bgColor]};
  color: ${({ theme }) => theme.color.white};
`;

const Image = styled.img`
  display: block;
  width: ${({ cardSize }) => cardSize.large};
`;

const Info = styled.div`
  margin-top: 1.6rem;
`;

const Title = styled.strong`
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  color: ${({ theme }) => theme.color.grey1};
`;

const Desc = styled.p`
  margin: 0.8rem 0;
  font-size: ${({ theme }) => theme.fontSize.small};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  color: ${({ theme }) => theme.color.grey2};
`;

const SPrice = styled.span`
  margin-right: 0.8rem;
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const NPrice = styled.span`
  font-size: ${({ theme }) => theme.fontSize.small};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  color: ${({ theme }) => theme.color.grey3};
  text-decoration: line-through;
`;

const Card = ({ card }) => {
  return (
    <ThemeProvider theme={theme}>
      <div>
        <Image cardSize={cardSize} src={card.image} alt={card.alt} />
        <Info>
          <Title>{card.title}</Title>
          <Desc>{card.description}</Desc>
          <div>
            <SPrice>{card.s_price}</SPrice>
            <NPrice>{card.n_price}</NPrice>
          </div>
          <Badges>
            {card.badge
              ? card.badge
                .filter((badge) => badge !== "메인특가")
                .map((badge) =>
                  badge === "런칭특가" ? (
                    <Badge bgColor={"orange"}>{badge}</Badge>
                  ) : (
                    <Badge bgColor={"green"}>{badge}</Badge>
                  )
                )
              : null}
          </Badges>
        </Info>
      </div>
    </ThemeProvider>
  );
};

export default Card;
