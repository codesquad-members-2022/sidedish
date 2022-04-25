import styled from "styled-components";

export const StyledEventPart = styled.div`
  > * {
    padding: 0 80px;
  }
  padding-top: 56px;
`;

export const StyledEventTitle = styled.div`
  font-family: "Noto Sans KR";
  display: flex;
  align-items: center;
  vertical-align: middle;
`;

export const StyledEventLogo = styled.span`
  font-size: 16px;
  font-weight: 500;
  line-height: 26px;
  background-color: #f8f7f7;
  padding: 6px 14px;
  border: black solid 2px;
  border-radius: 100px;
`;

export const StyledEventDesc = styled.span`
  font-size: 40px;
  font-weight: 700;
  line-height: 58px;
  margin-left: 16px;
  margin-bottom: 2px;
`;
