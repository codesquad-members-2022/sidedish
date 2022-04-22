import styled from "styled-components";

const MenuWrapper = styled.li`
  ${({ theme }) => theme.custom_flex("column", "flex-start")}
  margin: 12px;
`;

const Title = styled.span`
  ${({ theme }) =>
    theme.custom_font("Noto Sans KR", 16, 400, 26, -0.008) +
    `color:${theme.colors.Black}`}
`;

const Sub = styled.span`
  margin-top: 8px;
  ${({ theme }) =>
    theme.custom_font("Noto Sans KR", 14, 400, 24) +
    `color:${theme.colors.Black}`}
`;

export const GnbMenu = ({ id, name, subcategories, extended }) => {
  return (
    <MenuWrapper>
      <Title>{name}</Title>
      {extended &&
        subcategories.map((cat, index) => <Sub key={index}>{cat}</Sub>)}
    </MenuWrapper>
  );
};
