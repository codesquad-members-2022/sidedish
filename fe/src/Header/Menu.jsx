import styled from 'styled-components';
<<<<<<< HEAD
import Colors from '../Constants/Colors';
=======
import COLOR from '../Constants/Constants';
import FONT from '../test/test';
>>>>>>> 4ebb429 (feat: 카드 컴포넌트 구현)

const MenuWrapper = styled.li`
  margin-right: 24px;
`;

const SubMenuList = styled.ul`
<<<<<<< HEAD
  margin: 16px 0;
=======
  display: flex

  margin-top: 16px;
>>>>>>> 4ebb429 (feat: 카드 컴포넌트 구현)

  flex-direction: column;

  span:not(:last-child) {
    margin-bottom: 8px;
  }

  span:hover {
    text-decoration: underline;
<<<<<<< HEAD
    color: ${Colors.GREY};
=======
    color: ${COLOR.GREY};
>>>>>>> 4ebb429 (feat: 카드 컴포넌트 구현)
  }
`;

export const Menu = ({ menuData: { mainMenu, subMenuList }, subMenuOpen }) => {
  return (
    <MenuWrapper>
      <span>{mainMenu}</span>
      {subMenuOpen ? (
        <SubMenuList className={'fonts-sm'}>
          {subMenuList.map((subMenu, idx) => (
            <FONT size={'xlNormal'} key={idx}>
              {subMenu}
            </FONT>
          ))}
        </SubMenuList>
      ) : null}
    </MenuWrapper>
  );
};
