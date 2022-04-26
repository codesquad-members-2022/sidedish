import styled, { css } from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;
`;

export const CardImage = styled.img`
  width: 411px;
  height: 411px;
`;

export const CardContent = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;

  > h3 {
    font-weight: ${({ theme }) => theme.fontWeight.bold};
  }
  > span {
    font-size: ${({ theme }) => theme.fontSize.small};
    color: ${({ theme }) => theme.color.grey2};
  }
`;

export const PriceContainer = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;

  > span:first-child {
    font-weight: ${({ theme }) => theme.fontWeight.bold};
  }
  > span:last-child {
    font-size: ${({ theme }) => theme.fontSize.small};
    color: ${({ theme }) => theme.color.grey3};
  }
`;

export const EventBadge = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  margin-top: 8px;
  padding: 6px 16px;
  width: 76px;
  height: 30px;
  border-radius: 20px;
  color: ${({ theme }) => theme.color.white};
  background: ${({ theme, event }) => getEventColorType({ theme, event })};
`;

const getEventColorType = ({ theme, event }) => {
  switch (event) {
    case "런칭특가":
      return theme.color.orange;
    case "이벤트특가":
      return theme.color.green;
    default:
  }
};
