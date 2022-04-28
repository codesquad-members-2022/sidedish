import styled, {css} from 'styled-components';

const StyledHeader = styled.header`
  width: 100%;
  border-bottom: 1px solid;
  ${({isOpen}) => {
    return (
      isOpen &&
      css`
        height: 191px;
      `
    );
  }}
`;

const InnerHeader = styled.div`
  width: 1280px;
  height: 83px;
  display: flex;
  align-items: baseline;
  margin: 0 auto;
  position: relative;
`;

const BrandHeader = styled.h1`
  margin: 16px 40px 17px 0px;
  font-family: 'Outfit';
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
`;

const NavBar = styled.nav`
  display: flex;
  justify-content: space-around;
  width: 128px;
  height: 32px;
  margin-left: auto;
`;

export {StyledHeader, InnerHeader, BrandHeader, NavBar};
