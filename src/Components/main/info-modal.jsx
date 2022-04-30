import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { fetchData } from '../../util/fetchApi';

export default function InfoModal({ hash, isClick }) {
  const [modalInfos, setModalInfo] = useState(null);

  const ModalHandler = () => {
    isClick(false);
  };

  useEffect(() => {
    async function getModalInfo() {
      const modalInfo = await fetchData(`detail/${hash}`);
      setModalInfo(modalInfo.data);
    }
    getModalInfo();
  }, []);

  return (
    <ModalBody>
      {modalInfos ? <ModalContent info={modalInfos} /> : null}
      <CloseBtn onClick={ModalHandler}>닫기</CloseBtn>
    </ModalBody>
  );
}

function ModalImage({ img }) {
  const [mainImage, setMainImage] = useState(img[0]);

  return (
    <div>
      <ModalMainImage src={mainImage} />
      <ModalThumbImgs img={img} />
    </div>
  );
}

function ModalContent({ info }) {
  return (
    <>
      <ModalImage img={info.thumb_images} />
      <ModalText text={info} />
    </>
  );
}

function ModalText({ text }) {
  return (
    <>
      <ModalTitle>{text.product_description}</ModalTitle>
      <ModalPrice prices={text.prices} />
    </>
  );
}

function ModalThumbImgs({ img }) {
  return (
    <div>
      {img.map((img, idx) => {
        return <ModalThumbImage key={idx} src={img} />;
      })}
    </div>
  );
}

function ModalPrice({ prices }) {}

const salePrice = styled.span``;

const ModalTitle = styled.h3`
  font-size: 20px;
  font-weight: 500;
`;

const CloseBtn = styled.button`
  position: absolute;
  color: gray;
  font-weight: bold;
  top: 5%;
  right: 5%;
`;

const ModalBody = styled.section`
  position: fixed;
  display: flex;
  width: 960px;
  height: 600px;
  padding: 48px;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  z-index: 100;
  border: 1px solid black;

  > div {
    margin-right: 20px;
  }
`;

const ModalThumbImage = styled.img`
  margin-top: 2px;
  margin-right: 5px;
  width: 72px;
  height: 72px;
`;

const ModalMainImage = styled.img`
  width: 392px;
  height: 392px;
`;
