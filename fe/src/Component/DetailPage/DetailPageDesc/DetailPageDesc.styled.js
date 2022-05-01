import styled from "styled-components";

const DetailPageDescSize = {
  width: 960,
  height: 596,
};

const DetailPageDescDiv = styled.div`
  position: fixed;
  top: calc(50% - (${DetailPageDescSize.height / 2}px));
  left: calc(50% - (${DetailPageDescSize.width / 2}px));
  width: ${DetailPageDescSize.width}px;
  height: ${DetailPageDescSize.height}px;
  background-color: white;
  box-shadow: 0px 0px 10px black;
`;

export default DetailPageDescDiv;
