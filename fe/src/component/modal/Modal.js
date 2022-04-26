import styled, { css } from "styled-components";

const ModalWrapper = styled.div`
  width: 900px;
  height: 894px;
  border: 1px solid #000;
  position: absolute;
  background: #fff;
  top: 20%;
  left: 20%;
  padding: 50px 30px;
`;

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

const ProductInfo = styled.div`
  width: 470px;
  height: 472px;
`;

const TextWrapper = styled.div`
  height: 90%;
  //background: blue;
`;

//
const CardTitle = styled.span`
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  margin-top: 5px;
`;

const CardDesc = styled.p`
  font-size: ${({ theme }) => theme.fontSize.medium};
  margin: 5px 0;
  color: #777;
`;

const CardOriginalPrice = styled.p`
  color: ${({ theme }) => theme.colors.grey2};
  font-size: ${({ theme }) => theme.fontSize.small};
  margin: 10px 0px;
`;

const CardBadge = styled.span`
  width: 76px;
  height: 40px;
  line-height: 30px;
  border-radius: 20px;
  color: ${({ theme }) => theme.colors.white};
  text-align: center;
  margin-top: 25px;
  margin-right: 10px;
  padding: 8px 15px;

  ${({ children }) =>
    children === "런칭특가"
      ? css`
          background: ${({ theme }) => theme.colors.orange};
        `
      : css`
          background: ${({ theme }) => theme.colors.green};
        `}
`;

const Info = styled.span`
  color: ${({ theme }) => theme.colors.grey2};
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  margin-right: 20px;
`;

const ProductDetail = styled.div`
  display: flex;
  justify-content: space-between;
  height: 596px;
`;
// const ProductRecomend = styled.div`
//   height: 396px;
//   background: blue;
// `;
const Modal = () => {
  return (
    <ModalWrapper>
      <ProductDetail>
        <ImageWrapper>
          <TopImg src="http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg" />
          <SmallImgWrapper>
            <SmallImg src="https://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_S.jpg" />
            <SmallImg src="http://public.codesquad.kr/jk/storeapp/data/main/510_ZIP_P_0047_T.jpg" />
          </SmallImgWrapper>
        </ImageWrapper>
        <ProductInfo>
          <TextWrapper>
            <div
              style={{
                width: "95%",
                borderBottom: "1px solid #000",
                paddingBottom: "15px",
              }}
            >
              <CardTitle>오리주물럭_반조리</CardTitle>
              <CardOriginalPrice>15,800원</CardOriginalPrice>
              <CardBadge>런칭특가</CardBadge>
              <CardTitle>12,640원</CardTitle>
            </div>
            <div style={{ width: "95%", borderBottom: "1px solid #000" }}>
              <Info>적립금</Info>
              <span>125원</span>
              <br></br>
              <Info>배송정보</Info>
              <span>서울 경기 새벽 배송 / 전국 택배 배송</span>
              <br></br>
              <Info>배송비</Info>
              <span>2,500원 (40,000원 이상 구매 시 무료)</span>
            </div>
            <div>
              <div>
                <span>-</span>
                <span>1</span>
                <span>+</span>
              </div>
              <div>
                <span>총 주문금액</span>
                <span>12,640원</span>
              </div>
            </div>
            <div>주문하기</div>
          </TextWrapper>
        </ProductInfo>
      </ProductDetail>
    </ModalWrapper>
  );
};

export default Modal;
