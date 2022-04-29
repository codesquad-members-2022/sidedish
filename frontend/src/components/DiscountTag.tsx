import styled from "styled-components";
import { tagConvetion } from "../convention";
import { custom_flex, custom_font } from "../styles/global";
import { IDName } from "../types";

export const TagItem = styled.li<{ Id: number }>`
  margin-right: 8px;
  padding: 6px 16px;
  border-radius: 999px;
  ${custom_flex("row", "flex-start")}
  background-color: ${({ Id, theme }) => theme.colors[tagConvetion[Id].color]};

  span {
    text-align: center;
    ${custom_font("Noto Sans KR", 12, 500, 18, -0.008)}
    color: ${({ theme }) => theme.colors.White}
  }
`;

export const TagWrapper = styled.ul`
  ${custom_flex("row", "flex-start")}
`;

export const DiscountTag = ({ discounts }: { discounts: IDName[] }) => {
  return (
    <TagWrapper>
      {discounts?.map(({ id, name }, key) => (
        <TagItem key={key} Id={id}>
          <span>{name}</span>
        </TagItem>
      ))}
    </TagWrapper>
  );
};
