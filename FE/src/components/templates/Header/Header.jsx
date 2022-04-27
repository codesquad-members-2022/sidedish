import { useState } from "react";
<<<<<<< HEAD
<<<<<<< HEAD
import { StyledLogo } from "@/components/atoms/Logo/Logo.styled.js";
import { HeaderNav } from "@/components/organisms/HeaderNav/HeaderNav.jsx";
import { StyledIconContainer } from "@/components/molecules/Icons/Icons.styled";
=======
import { Logo } from "@/components/atoms/Logo/Logo.jsx";
import { Icons } from "@/components/molecules/Icons/Icons.jsx";
import { HeaderNav } from "@/components/organisms/HeaderNav/HeaderNav.jsx";

>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
=======
import { StyledLogo } from "@/components/atoms/Logo/Logo.styled.js";
import { HeaderNav } from "@/components/organisms/HeaderNav/HeaderNav.jsx";
import { StyledIconContainer } from "@/components/molecules/Icons/Icons.styled";
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
import "./Header.scss";

export function Header() {
  const [isShown, setIsShown] = useState(false);
  return (
    <header
      onMouseLeave={() => {
        setIsShown(false);
      }}
    >
<<<<<<< HEAD
<<<<<<< HEAD
      <StyledLogo className="logo" />
      <HeaderNav isShown={isShown} setIsShown={setIsShown} />
      <StyledIconContainer className="icon-container" />
=======
      <Logo />
      <HeaderNav isShown={isShown} setIsShown={setIsShown} />
      <Icons />
>>>>>>> 0847aee ([#31] Feat: Header 컴포넌트에 Atomic Design Pattern 적용)
=======
      <StyledLogo className="logo" />
      <HeaderNav isShown={isShown} setIsShown={setIsShown} />
      <StyledIconContainer className="icon-container" />
>>>>>>> eb70272 ([#39] Feat: Header 컴포넌트에 styled-components 적용)
    </header>
  );
}
