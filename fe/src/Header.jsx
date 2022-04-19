import { MenuList } from './Header/MenuList';
import { UserButtons } from './Header/UserButtons';
import styled from 'styled-components';

const Root = styled.header`
  width: 1440px;
  padding: 16px 80px;
  border-bottom: 1px solid #000;
  margin: 0 auto;
  display: flex;
  align-items: flex-start;
`;

const Logo = styled.h1`
  margin-right: 40px;
  cursor: pointer;
`;

const HeaderUI = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  width: 100%;
  padding-top: 12px;
`;

export const Header = () => {
  return (
    <Root>
      <Logo>Ordering</Logo>
      <HeaderUI>
        <MenuList />
        <UserButtons />
      </HeaderUI>
    </Root>
  );
};
