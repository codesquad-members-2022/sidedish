import styled from "styled-components";
import { ReactComponent as LogoImg } from "assets/logo.svg";
import { ReactComponent as SearchImg } from "assets/search.svg";
import { ReactComponent as LoginImg } from "assets/man.svg";
import { ReactComponent as CartImg } from "assets/cart.svg";

export const Container = styled.header`
  width: 100%;
  height: ${({ isOpen }) => (isOpen ? `161px` : `83px`)};
  transition: height 0.3s;
  border-bottom: 1px solid black;
  margin-bottom: 30px;
  z-index: 2;
`;

export const Nav = styled.div`
  display: flex;
  justify-content: space-between;

  max-width: 1280px;
  padding: 24px 0;
  margin: 0 auto;
`;

export const NavContent = styled.div`
  display: flex;
  gap: 40px;
`;

export const CategoryTab = styled.div`
  display: flex;
  align-items: flex-start;
  gap: 24px;
`;
export const Tab = styled.div`
  display: flex;
  flex-direction: column;
  gap: 8px;

  h2 {
    cursor: pointer;
    line-height: 30px;
    :hover {
      font-weight: ${({ theme: { fontWeight } }) => fontWeight.display};
    }
  }
`;
export const SubTabList = styled.ul`
  display: ${({ isOpen }) => (isOpen ? `block` : "none")};
  li + li {
    margin-top: 12px;
  }
  cursor: pointer;
`;

export const SubTab = styled.li`
  font-size: ${({ theme: { fontSize } }) => fontSize.small};
  :hover {
    font-weight: ${({ theme: { fontWeight } }) => fontWeight.display};
  }
`;

export const NavIcons = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 26px;

  svg {
    cursor: pointer;
    :hover {
      width: 30px;
      height: 30px;
      transition: all 0.2s;
    }
  }
`;

//FIXME Logo 접근가능? hover or cursor:pointer 넣고싶음.
export const Logo = styled(LogoImg)``;

export const Search = styled(SearchImg)``;
export const Login = styled(LoginImg)``;
export const Cart = styled(CartImg)``;
