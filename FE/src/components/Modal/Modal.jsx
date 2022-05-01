import React, { useState, useEffect } from 'react';
import Portal from './Portal';
import { fetchData } from 'utils/utils';
import { API_URL } from 'constants/api';
import * as S from './Modal.style';
import Thumbnail from 'components/Card/Thumbnail';
import Badge from 'components/Card/Badge';
import Slider from 'components/Slider/Slider';
import OrderAlertModal from './OrderAlertModal';
import { discountRate } from 'constants/productInfo';

function Modal({ className, onClose, visible, dataId }) {
  const [data, setData] = useState({});
  const [orderCount, setOrderCount] = useState(1);
  const [salePrice, setSalePrice] = useState(0);
  const [currentImg, setCurrentImg] = useState();
  const [openAlertModal, setOpenAlertModal] = useState(false);

  const close = e => {
    if (onClose) {
      onClose(e);
    }
  };

  useEffect(() => {
    document.body.style.cssText = `position: fixed; top: -${window.scrollY}px`;
    return () => {
      const scrollY = document.body.style.top;
      document.body.style.cssText = `position: ""; top: "";`;
      window.scrollTo(0, parseInt(scrollY || '0') * -1);
    };
  }, []);

  useEffect(() => {
    fetchDishData(dataId);
  }, [dataId]);

  const calcDisCountedPrice = (price, badge) => {
    return Math.floor(price * discountRate[badge]);
  };

  const fetchDishData = async dataId => {
    const data = await fetchData(`${API_URL}/dishes/${dataId}`);
    setData(data);
    const salePrice = calcDisCountedPrice(data.price, data.badge);
    setSalePrice(salePrice);
    console.log(data);
    setCurrentImg(data.images[0].imagePath);
  };

  const increaseOrderCount = () => {
    setOrderCount(orderCount + 1);
  };

  const decreaseOrderCount = () => {
    if (orderCount <= 1) return;
    setOrderCount(orderCount - 1);
  };

  const changeThumbnail = i => {
    setCurrentImg(data.images[i].imagePath);
  };

  const handleOrderBtnClick = () => {
    setOpenAlertModal(true);
  };

  const handleAlertClose = () => {
    setOpenAlertModal(false);
  };

  return (
    <Portal elementId="modal-root">
      <S.ModalOverlay visible={visible} />
      <S.ModalWrapper className={className} tabIndex={-1} visible={visible}>
        <S.ModalInner className="modal-inner" tabIndex={0}>
          <S.CloseBtn className="modal-close" onClick={close}>
            닫기
          </S.CloseBtn>
          <S.ContentsWrapper>
            {Object.keys(data).length && (
              <S.ThumbnailWrapper>
                <Thumbnail src={currentImg} size="large" mouseEvent={false} />
                <S.ThumbnailList>
                  {data.images.map((v, i) => {
                    return (
                      <Thumbnail
                        key={i}
                        size="xSmall"
                        src={v.imagePath}
                        mouseEvent={false}
                        onClick={() => changeThumbnail(i)}
                      />
                    );
                  })}
                </S.ThumbnailList>
              </S.ThumbnailWrapper>
            )}
            <S.DescriptionWrapper>
              <S.InnerDescription>
                <S.PrimaryDescription>
                  <S.PrimaryFont>{data.name}</S.PrimaryFont>
                  <S.OldPrice>{data.price}원</S.OldPrice>
                  <S.FlexWrapper>
                    {data.badge !== 'NONE' && <Badge type={data.badge} />}
                    <S.PrimaryFont margin="10">{salePrice}원</S.PrimaryFont>
                  </S.FlexWrapper>
                </S.PrimaryDescription>
                <S.SecondaryDescription>
                  <S.FlexWrapper>
                    <S.SmallFont type="title">적립금</S.SmallFont>
                    <S.SmallFont>{Math.floor(salePrice * 0.01)}원</S.SmallFont>
                  </S.FlexWrapper>
                  <S.FlexWrapper>
                    <S.SmallFont type="title">배송정보</S.SmallFont>
                    <S.SmallFont>서울 경기 새벽 배송, 전국 택배 배송</S.SmallFont>
                  </S.FlexWrapper>
                  <S.FlexWrapper>
                    <S.SmallFont type="title">배송비</S.SmallFont>
                    <S.SmallFont>2,500원 (40,000원 이상 구매 시 무료)</S.SmallFont>
                  </S.FlexWrapper>
                </S.SecondaryDescription>
                <S.OrderWrapper>
                  <S.CounterWrapper>
                    <S.MinusIcon onClick={decreaseOrderCount} />
                    {orderCount}
                    <S.PlusIcon onClick={increaseOrderCount} />
                  </S.CounterWrapper>
                  <S.TotalOrderWrapper>
                    <S.TotalOrder>총 주문금액</S.TotalOrder>
                    <S.PrimaryFont>{(salePrice * orderCount).toLocaleString('ko-KR')}원</S.PrimaryFont>
                  </S.TotalOrderWrapper>
                </S.OrderWrapper>
              </S.InnerDescription>
              <S.OrderBtn onClick={handleOrderBtnClick}>주문하기</S.OrderBtn>
            </S.DescriptionWrapper>
          </S.ContentsWrapper>
          <Slider type="small" title="함께하면 더욱 맛있는 상품" id="MAIN" thumbEvent={false} />
          {openAlertModal && <OrderAlertModal onClose={handleAlertClose} />}
        </S.ModalInner>
      </S.ModalWrapper>
    </Portal>
  );
}

export default Modal;
