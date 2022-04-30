import styled from "styled-components";
import React from "react";
import ReactLoading from "react-loading";
const Loader = () => {
  return (
    <>
      <LoadingBox>
        <LoadingTitle>Loading ...</LoadingTitle>
        <ReactLoading color={"black"} height={"5%"} width={"5%"} />{" "}
      </LoadingBox>
      :
    </>
  );
};

const LoadingBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
  padding-top: 300px;
`;

const LoadingTitle = styled.div`
  width: 100%;
  height: 100%;
  font-size: 2rem;
  text-align: center;
`;

export default Loader;
