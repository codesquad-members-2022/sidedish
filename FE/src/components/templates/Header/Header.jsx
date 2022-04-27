import { useState } from "react";
import { StyledLogo } from "@/components/atoms/Logo/Logo.styled.js";
import { HeaderNav } from "@/components/organisms/HeaderNav/HeaderNav.jsx";
import { StyledIconContainer } from "@/components/molecules/Icons/Icons.styled";
import "./Header.scss";

export function Header() {
  const [isShown, setIsShown] = useState(false);
  return (
    <header
      onMouseLeave={() => {
        setIsShown(false);
      }}
    >
      <StyledLogo className="logo" />
      <HeaderNav isShown={isShown} setIsShown={setIsShown} />
      <StyledIconContainer className="icon-container" />
    </header>
  );
}
