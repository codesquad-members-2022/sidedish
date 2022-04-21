import styled from "styled-components";
import { tagConvetion } from "../convention";

export const TagItem = styled.li`
  padding: 6px 16px;
  ${({ theme, id }) =>
    theme.custom_flex("row", "flex-start") +
    theme.custom_static(0, null, null, 0) +
    theme.flex_none(tagConvetion[id].order, 0, 8)}
  height: 30px;
  border-radius: 999px;
  background: ${({ id, theme }) => theme.colors[tagConvetion[id].color]} span {
    text-align: center;
    ${({ theme }) =>
      theme.custom_font("Noto Sans KR", 12, 500, 18, -0.008) +
      `color:${theme.colors.White}` +
      theme.flex_none(0, 0, 10)}
  }
`;
export const TagWrapper = styled.ul`
  padding: 0px;
  ${({ theme }) =>
    theme.custom_flex("row", "flex-start") +
    theme.custom_static(535) +
    theme.flex_none(2, 16, 0)}
  height: 30px;
`;

export const DiscountTag = ({ discount }) => {
  return (
    <TagWrapper>
      {discount.map(({ id, name }, key) => (
        <TagItem key={key} id={id}>
          <span>{name}</span>
        </TagItem>
      ))}
    </TagWrapper>
  );
};
