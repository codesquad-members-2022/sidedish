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

export const Menu = ({ category, subMenuOpen }) => {
  return (
    <MenuWrapper>
      <span>{category.main}</span>
      {subMenuOpen ? (
        <SubMenuList className={'fonts-sm'}>
          {category.subs.map((sub, idx) => (
            <li key={idx}>{sub}</li>
          ))}
        </SubMenuList>
      ) : null}
    </MenuWrapper>
  );
};
