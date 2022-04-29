import styled from 'styled-components';

import { Colors, Fonts } from '@/Constants';

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
      <span>{category.title}</span>
      {subMenuOpen ? (
        <SubMenuList className={Fonts.SM}>
          {category.subCategories.map((subCategory) => (
            <li key={subCategory.id}>{subCategory.title}</li>
          ))}
        </SubMenuList>
      ) : null}
    </MenuWrapper>
  );
};
