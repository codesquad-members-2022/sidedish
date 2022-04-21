import styled from 'styled-components';
import Colors from '../Constants/Colors';

const MenuWrapper = styled.li`
  margin-right: 24px;
`;

const SubMenuList = styled.ul`
  margin: 16px 0;

  flex-direction: column;

  li:not(:last-child) {
    margin-bottom: 8px;
  }

  li:hover {
    text-decoration: underline;
    color: ${Colors.GREY};
  }
`;

export const Menu = ({ menuData: { mainMenu, subMenuList }, subMenuOpen }) => {
  return (
    <MenuWrapper>
      <span>{mainMenu}</span>
      {subMenuOpen ? (
        <SubMenuList className={'fonts-sm'}>
          {subMenuList.map((subMenu, idx) => (
            <li size={'xlNormal'} key={idx}>
              {subMenu}
            </li>
          ))}
        </SubMenuList>
      ) : null}
    </MenuWrapper>
  );
};
