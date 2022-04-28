import { useState } from 'react';
import { ImgWrapper } from './imgArea.styled';
import { MainImg } from './mainImg/mainImg';
import { SubImgArea } from './subImgArea/subImgArea';

export function ImgArea({ urls }) {
  const [mainImgIdx, setMainImgIdx] = useState(0);

  return (
    <ImgWrapper flex direction="column">
      <MainImg urls={urls} mainImgIdx={mainImgIdx}></MainImg>
      <SubImgArea urls={urls} onClick={setMainImgIdx}></SubImgArea>
    </ImgWrapper>
  );
}
