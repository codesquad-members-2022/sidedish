import { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";

const cardSize = {
  large: "41.1rem",
  medium: "30.2rem",
  small: "16rem",
};

const Badge = styled.div`
  box-sizing: border-box;
  width: 7.6rem;
  height: 4.2rem;
  text-align: center;
  line-height: 3.6rem;
  font-size: ${({ theme }) => theme.fontSize.medium};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  border: 0.2rem solid ${({ theme }) => theme.color.black};
  border-radius: 99.9rem;
`;

const Card = () => {
  return (
    <ThemeProvider theme={theme}>
      <div>
        <img src="" alt="" />
        <div>
          <strong>title</strong>
          <p>desc</p>
          <div>
            <span>price</span>
            <span>price</span>
          </div>
          <div>
            <Badge>
              <strong>sale</strong>
            </Badge>
            <Badge>
              <strong>sale</strong>
            </Badge>
          </div>
        </div>
      </div>
      ;
    </ThemeProvider>
  );
};

export default Card;
