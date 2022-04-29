import React, { useState, useContext, useEffect } from "react";
import { ModalContext } from "../../store/store";
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

const DetailImage = ({ image }) => {
  const ctx = useContext(ModalContext);
  useEffect(() => {
    ctx.isDisplayed && setCurrentImg(image[0]);
  }, [ctx.isDisplayed, image]);

  const [currentImg, setCurrentImg] = useState(
    Array.isArray(image) ? image[0] : image
  );

  const onChangeImg = (event) => {
    setCurrentImg(event.target.src);
  };

  // 모달 absolute vw , vh 로 재설정
  return (
    <ImageWrapper>
      <TopImg src={currentImg} />
      <SmallImgWrapper>
        {image &&
          image.map((v) => (
            <SmallImg src={v} key={v} imgUrl={v} onClick={onChangeImg} />
          ))}
      </SmallImgWrapper>
    </ImageWrapper>
  );
};

export default DetailImage;
