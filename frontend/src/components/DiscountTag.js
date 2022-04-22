import styled from "styled-components";
import { tagConvetion } from "../convention";

export const TagItem = styled.li`
  margin-right: 8px;
  padding: 6px 16px;
  border-radius: 999px;
  ${({ theme, id }) => theme.custom_flex("row", "flex-start")}
  background-color: ${({ id, theme }) => theme.colors[tagConvetion[id].color]};
  span {
    text-align: center;
    ${({ theme }) =>
      theme.custom_font("Noto Sans KR", 12, 500, 18, -0.008) +
      `color:${theme.colors.White}`}
  }
`;
export const TagWrapper = styled.ul`
  margin-top: 16px;
  ${({ theme }) => theme.custom_flex("row", "flex-start")}
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
