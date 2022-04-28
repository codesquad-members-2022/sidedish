import styled, { css } from "styled-components";

const BUTTON_HEIGHT_PX = "44px";
const ELEMENT_SIZE = {
  AlertDiv: {
    width: 270,
    height: 129,
  },
};

const Wrapper = styled.div`
  position: absolute;
  display: block;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  z-index: 999;
`;

const AlertDiv = styled.div`
  ${({ theme: { colors } }) => css`
    background-color: ${colors.white};
    border: 1px solid ${colors.black};
  `}
  width: ${ELEMENT_SIZE.AlertDiv.width}px;
  height: ${ELEMENT_SIZE.AlertDiv.height}px;
  position: absolute;
  top: ${({ scrollYPosition, screenSize }) =>
    scrollYPosition +
    screenSize.height / 2 -
    ELEMENT_SIZE.AlertDiv.height / 2}px;
  left: calc(50% - ${ELEMENT_SIZE.AlertDiv.width / 2}px);
`;

const MessageArea = styled.div`
  ${({ theme: { boldFonts } }) => css`
    ${boldFonts.medium};
  `}
  height: calc(100% - ${BUTTON_HEIGHT_PX});
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Button = styled.button`
  ${({ theme: { colors } }) => css`
    background-color: ${colors.black};
    color: ${colors.white};
  `}
  width: 100%;
  height: ${BUTTON_HEIGHT_PX};
`;

export { Wrapper, AlertDiv, MessageArea, Button };
