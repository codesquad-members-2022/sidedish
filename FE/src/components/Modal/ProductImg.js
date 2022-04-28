import { useContext, useEffect, useState } from 'react';
import styled from 'styled-components';

import ModalInfoContextStore from '../../stores/ModalInfoStore';

const REDUCTION_RATIO = 1.3;

const ProductImgWrap = styled.div`
  width: 48.5%;
  height: 90%;
  margin-top: 4.5%;
`;

const TopImg = styled.img`
  width: 100%;
  height: 83%;
`;

const ThumbImgWrap = styled.div`
  display: flex;
  width: 100%;
  height: 60px;

  top: calc(392px / ${REDUCTION_RATIO});
  margin-top: 7px;
  justify-content: flex-start;
  align-items: center;
`;

const ThumbImg = styled.img`
  width: 16.5%;
  height: 92%;
  cursor: pointer;
  margin-right: 4.5%;
`;

const ProductImg = () => {
  const ModalInfo = useContext(ModalInfoContextStore);
  const [thumbImgInfo, setThumbImgInfo] = useState([]);
  useEffect(() => {
    const newThumbImg = ModalInfo.thumbImg;
    newThumbImg.splice(thumbImgInfo.idx, 1, ModalInfo.topImg);
    ModalInfo.setThumbImg(newThumbImg);
    ModalInfo.setTopImg(thumbImgInfo.api);
  }, [thumbImgInfo]);

  return (
    <ProductImgWrap>
      <TopImg src={ModalInfo.topImg} />
      <ThumbImgWrap>
        {ModalInfo.thumbImg.map((api, idx) => (
          <ThumbImg
            onClick={() => {
              setThumbImgInfo({ api, idx });
            }}
            key={api + idx}
            src={api}
          />
        ))}
      </ThumbImgWrap>
    </ProductImgWrap>
  );
};

export default ProductImg;
