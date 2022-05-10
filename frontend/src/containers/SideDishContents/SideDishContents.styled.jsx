import styled, {css} from "styled-components";

const StyledSideDishContents = styled.div`
  margin: 0 auto;
  width: 1280px;
`;

const ShowAllCategoryButton = styled.button`
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  padding: 16px 24px;

  position: absolute;

  width: 203px;
  height: 62px;
  left: 670px;
  ${({showAllCategory}) => {
    if (showAllCategory)
      return css`
        top: 2700px;
      `;
    else
      return css`
        top: 1552px;
      `;
  }}

  border: 1px solid #ebebeb;
  background-color: #fff;
  box-sizing: border-box;
  margin-bottom: 50px;

  p {
    position: static;
    width: 155px;
    height: 30px;
    left: 24px;
    top: 16px;
    font-family: "Noto Sans KR";
    font-style: normal;
    font-weight: 400;
    font-size: 20px;
    color: #3f3f3f;
  }
`;

export {StyledSideDishContents, ShowAllCategoryButton};
