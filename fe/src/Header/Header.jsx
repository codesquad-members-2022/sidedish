import { MenuList } from './MenuList';
import { UserButtons } from './UserButtons';
import styled from 'styled-components';
import Colors from '../Constants/Colors';

const HeaderWrapper = styled.header`
  width: 1440px;
  padding: 16px 80px;
  border-bottom: 1px solid ${Colors.BLACK};
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
    <HeaderWrapper>
      <Logo>
        <img src={'logo.svg'} alt={'로고'} />
      </Logo>
      <HeaderUI>
        <MenuList />
        <UserButtons />
      </HeaderUI>
    </HeaderWrapper>
  );
};
