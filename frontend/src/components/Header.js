import { MyPage, Search, ShoppingCart } from "../styles/global";
import styled, { css } from "styled-components";
import { useEffect, useState } from "react";
import { GnbMenu } from "./GnbMenu";

const HeaderWrapper = styled.header`
  width: 1440px;
  padding-top: 16px;
  background: ${({ theme }) => theme.colors.White};
  border-bottom: 1px solid ${({ theme }) => theme.colors.Black};
  display: flex;
`;

const HeaderLogo = styled.span`
  font-family: "Outfit";
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
  margin-left: 80px;
  color: ${({ theme }) => theme.colors.Black};
`;

const GNB = styled.div`
  margin: 0px 28px;
  ${({ theme }) => theme.custom_flex(`row`, `flex-start`, `center`)}
  ${(props) => props.extended && `margin-bottom: 40px;`}
}

`;

const IconWrapper = styled.div`
  ${({ theme }) =>
    theme.custom_flex("row", "center", "space-between") +
    theme.custom_absolute(25, 80, null, null) +
    theme.width_height_bypx(128)}
`;

const Icon = styled.div`
  ${({ theme }) =>
    theme.custom_relative(0, 0) + theme.width_height_bypx(32, 32)}
`;

export const Header = ({ cats }) => {
  const [extended, setExtended] = useState(false);

  return (
    <HeaderWrapper>
      <HeaderLogo>Ordering</HeaderLogo>
      <GNB
        onMouseEnter={() => setExtended(true)}
        onMouseLeave={() => setExtended(false)}
        extended={extended}
      >
        {cats.map((cat, index) => (
          <GnbMenu key={index} {...cat} extended={extended}></GnbMenu>
        ))}
      </GNB>
      <IconWrapper>
        <Icon>
          <Search
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M16.6667 14.6667H15.6133L15.24 14.3067C16.5918 12.7387 17.3348 10.7369 17.3333 8.66667C17.3333 6.95257 16.825 5.27695 15.8727 3.85173C14.9204 2.4265 13.5669 1.31567 11.9833 0.659715C10.3996 0.00375513 8.65706 -0.167874 6.97589 0.166531C5.29472 0.500937 3.75047 1.32636 2.53841 2.53841C1.32636 3.75047 0.500937 5.29472 0.166531 6.97589C-0.167874 8.65706 0.00375513 10.3996 0.659715 11.9833C1.31567 13.5669 2.4265 14.9204 3.85173 15.8727C5.27695 16.825 6.95257 17.3333 8.66667 17.3333C10.8133 17.3333 12.7867 16.5467 14.3067 15.24L14.6667 15.6133V16.6667L21.3333 23.32L23.32 21.3333L16.6667 14.6667ZM8.66667 14.6667C5.34667 14.6667 2.66667 11.9867 2.66667 8.66667C2.66667 5.34667 5.34667 2.66667 8.66667 2.66667C11.9867 2.66667 14.6667 5.34667 14.6667 8.66667C14.6667 11.9867 11.9867 14.6667 8.66667 14.6667Z"
              fill="#1B1B1B"
            />
          </Search>
        </Icon>
        <Icon>
          <MyPage
            width="22"
            height="22"
            viewBox="0 0 22 22"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M10.9999 11C13.9466 11 16.3333 8.61337 16.3333 5.66671C16.3333 2.72004 13.9466 0.333374 10.9999 0.333374C8.05325 0.333374 5.66658 2.72004 5.66658 5.66671C5.66658 8.61337 8.05325 11 10.9999 11ZM10.9999 13.6667C7.43992 13.6667 0.333252 15.4534 0.333252 19V21.6667H21.6666V19C21.6666 15.4534 14.5599 13.6667 10.9999 13.6667Z"
              fill="#1B1B1B"
            />
          </MyPage>
        </Icon>
        <Icon>
          <ShoppingCart
            width="27"
            height="28"
            viewBox="0 0 27 28"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M8.33325 22C6.86658 22 5.67992 23.2 5.67992 24.6666C5.67992 26.1333 6.86658 27.3333 8.33325 27.3333C9.79992 27.3333 10.9999 26.1333 10.9999 24.6666C10.9999 23.2 9.79992 22 8.33325 22ZM0.333252 0.666626V3.33329H2.99992L7.79992 13.4533L5.99992 16.72C5.78658 17.0933 5.66658 17.5333 5.66658 18C5.66658 19.4666 6.86658 20.6666 8.33325 20.6666H24.3333V18H8.89325C8.70658 18 8.55992 17.8533 8.55992 17.6666L8.59992 17.5066L9.79992 15.3333H19.7333C20.7333 15.3333 21.6132 14.7866 22.0666 13.96L26.8399 5.30663C26.9499 5.10314 27.0053 4.8746 27.0006 4.64333C26.9958 4.41206 26.9312 4.18597 26.813 3.98714C26.6948 3.78832 26.527 3.62356 26.3261 3.50895C26.1251 3.39435 25.8979 3.33383 25.6666 3.33329H5.94659L4.69325 0.666626H0.333252ZM21.6666 22C20.1999 22 19.0133 23.2 19.0133 24.6666C19.0133 26.1333 20.1999 27.3333 21.6666 27.3333C23.1333 27.3333 24.3333 26.1333 24.3333 24.6666C24.3333 23.2 23.1333 22 21.6666 22Z"
              fill="#1B1B1B"
            />
          </ShoppingCart>
        </Icon>
      </IconWrapper>
    </HeaderWrapper>
  );
};
