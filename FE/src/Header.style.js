import styled from 'styled-components';

const Navbar = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 16px 80px;
  width: 100%;
  height: 170px;
  border-bottom: 1px solid black;
`;

const Menu = styled.div`
  display: flex;
  width: 900px;
  justify-content: flex-start;
`;

const Icons = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100px;
  padding: 10px 0;
`;

const MenuBox = styled.div`
  display: flex;
  flex-direction: column;
  margin: 16px 24px 0 0;
`;

const MainMenu = styled.div`
  margin-bottom: 16px;
  font-size: ${props => props.theme.fontSize.medium};
`;

const SubMenuList = styled.ul`
  font-size: ${props => props.theme.fontSize.small};
`;

const SubMenu = styled.li`
  margin-bottom: 8px;
`;

export { Navbar, Menu, Icons, MenuBox, MainMenu, SubMenuList, SubMenu };
