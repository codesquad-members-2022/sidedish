import { useState } from "react";
import { Logo } from "@/components/atoms/Logo/Logo.jsx";
import { Icons } from "@/components/molecules/Icons/Icons.jsx";
import { Nav } from "@/components/organisms/Nav/Nav.jsx";

import "./Header.scss";

export function Header() {
  const [isShown, setIsShown] = useState(false);
  return (
    <header
      onMouseLeave={() => {
        setIsShown(false);
      }}
    >
      <Logo />
      <Nav isShown={isShown} setIsShown={setIsShown} />
      <Icons />
    </header>
  );
}
