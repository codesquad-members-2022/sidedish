import React from "react";
import styled from "styled-components";

const ImageWrapper = styled.div`
  width: 392px;
  height: 472px;
`;

const TopImg = styled.img`
  width: 392px;
  height: 392px;
`;

const SmallImgWrapper = styled.div`
  width: 100%;
  height: 80px;
`;

const SmallImg = styled.img`
  width: 72px;
  height: 72px;
  margin-right: 3px;
`;

const DetailImage = () => {
  return (
    <ImageWrapper>
      <TopImg src="http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg" />
      <SmallImgWrapper>
        <SmallImg src="https://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_S.jpg" />
        <SmallImg src="http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg" />
      </SmallImgWrapper>
    </ImageWrapper>
  );
};

export default DetailImage;
