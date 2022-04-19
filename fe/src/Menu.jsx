import styled from 'styled-components';

const StyledMenu = styled.li`
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

export const Menu = ({ menuData: { mainMenu, subMenuList }, isMouseEnter }) => {
  return (
    <StyledMenu>
      <span>{mainMenu}</span>
      {isMouseEnter ? (
        <SubMenuList>
          {subMenuList.map((subMenu, idx) => (
            <li key={idx}>{subMenu}</li>
          ))}
        </SubMenuList>
      ) : null}
    </StyledMenu>
  );
};
