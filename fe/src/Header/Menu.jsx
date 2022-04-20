import styled from 'styled-components';

const Root = styled.li`
  margin-right: 24px;
`;

const SubMenuList = styled.ul`
  margin-top: 16px;

  li {
    font-size: 14px;
  }

  li:not(:last-child) {
    margin-bottom: 8px;
  }

  li:hover {
    text-decoration: underline;
    color: ${'#777777'};
  }
`;

export const Menu = ({ menuData: { mainMenu, subMenuList }, subMenuOpen }) => {
  return (
    <Root>
      <span>{mainMenu}</span>
      {subMenuOpen ? (
        <SubMenuList>
          {subMenuList.map((subMenu, idx) => (
            <li key={idx}>{subMenu}</li>
          ))}
        </SubMenuList>
      ) : null}
    </Root>
  );
};
