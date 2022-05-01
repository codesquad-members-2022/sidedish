import styled from 'styled-components';

const Navbar = styled.header`
  display: flex;
  justify-content: space-between;
  padding: 16px 80px;
  width: 100%;
  height: auto;
  border-bottom: 1px solid black;
`;

const Menu = styled.div`
  display: flex;
  width: 75%;
  justify-content: flex-start;
`;

const Icons = styled.div`
  cursor: pointer;
  display: flex;
  justify-content: space-between;
  width: 100px;
  padding-top: 15px;
`;

const MenuBox = styled.div`
  display: flex;
  flex-direction: column;
  padding: 16px 24px 0 0;
`;

const MainMenu = styled.div`
  cursor: pointer;
  margin-bottom: 16px;
  font-size: ${props => props.theme.fontSize.medium};
`;

const SubMenuList = styled.ul`
  font-size: ${props => props.theme.fontSize.small};
  display: ${({ isOpen }) => (isOpen ? 'block' : 'none')};
`;

const SubMenu = styled.li`
  margin-bottom: 8px;
  cursor: pointer;

  :hover {
    text-decoration: underline;
    color: ${props => props.theme.colors.grey2};
  }
`;

export { Navbar, Menu, Icons, MenuBox, MainMenu, SubMenuList, SubMenu };
