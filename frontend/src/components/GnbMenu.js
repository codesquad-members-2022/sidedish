import styled from "styled-components";


const List = styled.li`

  left: ${({index}) => index * 130}px;
  ${({theme, index}) =>
          theme.custom_flex("column", "flex-start") + theme.custom_static(0, null, null, 0) + theme.flex_none(index, 0, 24)};
  height: auto;
`;
const Title = styled.span`
  ${({theme}) => theme.custom_static(34, null, null, 0) + theme.custom_font("Noto Sans KR", 16, 400, 26, -0.008) + theme.flex_none(0, 8, 0) + `color:${theme.colors.Black}`}
`;
const Sub = styled.span`
  ${({
       theme,
       index
     }) => theme.custom_static(34 + index * 32, null, null, 0) + theme.custom_font("Noto Sans KR", 14, 400, 24) + theme.flex_none(index + 1, 8, 0) + `color:${theme.colors.Black}`}
`

export const GnbMenu = ({id, index, name, subcategories, show}) => {
    return (
        <List index={index}>
            <Title>{name}</Title>
            {show && subcategories.map((cat, index) => <Sub key={index} index={index}>{cat}</Sub>)}
        </List>
    );
};
