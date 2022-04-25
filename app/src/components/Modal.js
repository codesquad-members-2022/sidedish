import { useEffect, useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";
import { Badge } from "../styles/utils.js";
import CardList from "./CardList.js";

const ModalContainer = styled.div`
  position: absolute;
  top: 0;
  left: 0;
`;

const ModalBackground = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: ${({ theme }) => theme.color.black};
  opacity: 0.5;
`;

const ModalPopup = styled.div`
  box-sizing: border-box;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 96rem;
  height: 99.4rem;
  background-color: ${({ theme }) => theme.color.white};
  border: 0.2rem solid ${({ theme }) => theme.color.black};
`;

const ModalTobContainer = styled.div`
  padding: 3.2rem 4.8rem 4.8rem;
  border-bottom: 0.2rem solid ${({ theme }) => theme.color.black};
`;

const ModalHeader = styled.div`
  display: flex;
  justify-content: flex-end;
`;

const ModalCloseBtn = styled.button`
  color: ${({ theme }) => theme.color.grey2};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.medium};
  background-color: ${({ theme }) => theme.color.white};
  padding: 0;
  margin: 0;
  border: none;
  cursor: pointer;
  line-height: 2.6rem;
`;

const ModalContent = styled.div`
  margin-top: 1.8rem;
  display: flex;
  gap: 3.2rem;
`;

const ContentImgs = styled.div``;

const MainImg = styled.img`
  width: 39.2rem;
`;

const SubImgs = styled.div`
  display: flex;
  height: 7.2rem;
  margin-top: 0.8rem;
  gap: 0.8rem;
`;

const ContentDesc = styled.div`
  width: 100%;
`;

const ContentTitle = styled.h2`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
  color: ${({ theme }) => theme.color.black};
  line-height: 3rem;
`;

const ContentPrice = styled.div`
  margin-top: 1.6rem;
  padding-bottom: 2.4rem;
  border-bottom: 0.1rem solid ${({ theme }) => theme.color.grey4};
`;

const ContentNPrice = styled.div`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.small};
  color: ${({ theme }) => theme.color.grey3};
  line-height: 2.4rem;
  text-decoration: line-through;
`;

const ContentPriceEtc = styled.div`
  margin-top: 0.8rem;
  display: flex;
  align-items: center;
  gap: 0.8rem;
`;

const ContentSPrice = styled.strong`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
  color: ${({ theme }) => theme.color.black};
`;

const ContentEtcDesc = styled.dl`
  margin-top: 1.7rem;
  padding-bottom: 0.8rem;
  border-bottom: 0.1rem solid ${({ theme }) => theme.color.grey4};
`;

const ContentEtcDescList = styled.div`
  display: flex;
  gap: 1.6rem;
  line-height: 1.8rem;
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  color: ${({ theme }) => theme.color.black};
  margin-bottom: 0.8rem;
`;

const DescListTerm = styled.dt`
  width: 6rem;
  color: ${({ theme }) => theme.color.grey2};
`;

const ContentTotal = styled.div`
  margin-top: 2.4rem;
  display: flex;
  justify-content: space-between;
`;

const ContentCounter = styled.div`
  display: flex;
  align-items: center;
  height: 2.6rem;
  line-height: 2.6rem;
`;

const CountButton = styled.button`
  width: 2.4rem;
  height: 2.4rem;
  padding: 0;
  margin: 0;
  border: none;
  cursor: pointer;
  background-color: ${({ theme }) => theme.color.white};
`;

const ButtonImg = styled.img`
  width: 2.4rem;
`;

const CountMinusButton = styled(CountButton)``;

const CountPlusButton = styled(CountButton)``;

const ContentCount = styled.strong`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.medium};
  color: ${({ theme }) => theme.color.black};
  text-align: center;
  width: 4rem;
`;

const ContentTotalPrice = styled.div`
  display: flex;
  align-items: center;
  gap: 1.6rem;
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.medium};
  color: ${({ theme }) => theme.color.grey2};
`;

const TotalPrice = styled.strong`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
  color: ${({ theme }) => theme.color.black};
`;

const OrderButton = styled.button`
  box-sizing: border-box;
  width: 100%;
  padding: 1.6rem;
  margin-top: 12.3rem;
  border: none;
  cursor: pointer;
  background-color: ${({ theme }) => theme.color.black};
  color: ${({ theme }) => theme.color.white};
  font-weight: ${({ theme }) => theme.fontWeight.display};
  font-size: ${({ theme }) => theme.fontSize.xMedium};
`;

const ModalFooter = styled.div`
  padding: 4.8rem 4.8rem 6.4rem 4.8rem;
`;

const FooterHeader = styled.div`
  display: flex;
  justify-content: space-between;
`;

const FooterTitle = styled.h3`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.medium};
`;

const Modal = ({ hideModal, dishHash }) => {
  const [dish, setDish] = useState("");
  const [mainImg, setMainImg] = useState("");
  const [count, setCount] = useState(1);
  const [price, setPrice] = useState(0);

  useEffect(() => {
    (async () => {
      await fetch(`https://api.codesquad.kr/onban/detail/${dishHash}`)
        .then((res) => res.json())
        .then((data) => {
          setDish(data.data);
          setMainImg(data.data.top_image);
        });
    })();
  }, []);

  const handleMouseOver = ({ target }) => {
    setMainImg(target.src);
  };

  return (
    <ThemeProvider theme={theme}>
      {dish ? (
        <ModalContainer>
          <ModalBackground></ModalBackground>
          <ModalPopup>
            <ModalTobContainer>
              <ModalHeader>
                <ModalCloseBtn onClick={hideModal}>닫기</ModalCloseBtn>
              </ModalHeader>
              <ModalContent>
                <ContentImgs>
                  <MainImg src={mainImg} alt=""></MainImg>
                  <SubImgs>
                    {dish.thumb_images.map((e) => (
                      <img src={e} onMouseOver={handleMouseOver} />
                    ))}
                  </SubImgs>
                </ContentImgs>
                <ContentDesc>
                  <ContentTitle>{dish.product_description}</ContentTitle>
                  <ContentPrice>
                    {dish.prices.length === 1 ? (
                      <>
                        <ContentPriceEtc>
                          <ContentSPrice>{dish.prices[0]}</ContentSPrice>
                        </ContentPriceEtc>
                      </>
                    ) : (
                      <>
                        <ContentNPrice>{dish.prices[0]}</ContentNPrice>
                        <ContentPriceEtc>
                          <Badge bgColor={"orange"}>런칭특가</Badge>
                          <ContentSPrice>{dish.prices[1]}</ContentSPrice>
                        </ContentPriceEtc>
                      </>
                    )}
                  </ContentPrice>
                  <ContentEtcDesc>
                    <ContentEtcDescList>
                      <DescListTerm>적립금</DescListTerm>
                      <dd>{dish.point}</dd>
                    </ContentEtcDescList>
                    <ContentEtcDescList>
                      <DescListTerm>배송정보</DescListTerm>
                      <dd>{dish.delivery_info}</dd>
                    </ContentEtcDescList>
                    <ContentEtcDescList>
                      <DescListTerm>배송비</DescListTerm>
                      <dd>{dish.delivery_fee}</dd>
                    </ContentEtcDescList>
                  </ContentEtcDesc>
                  <ContentTotal>
                    <ContentCounter>
                      <CountMinusButton>
                        <ButtonImg
                          src={`${process.env.PUBLIC_URL}/images/Minus.svg`}
                          onClick={() => {
                            count > 1 ? setCount(count - 1) : setCount(1);
                          }}
                        ></ButtonImg>
                      </CountMinusButton>
                      <ContentCount>{count}</ContentCount>
                      <CountPlusButton>
                        <ButtonImg
                          src={`${process.env.PUBLIC_URL}/images/Plus.svg`}
                          onClick={() => {
                            count < 100 ? setCount(count + 1) : setCount(99);
                          }}
                        ></ButtonImg>
                      </CountPlusButton>
                    </ContentCounter>
                    <ContentTotalPrice>
                      총 주문금액 <TotalPrice>{dish.prices[0]}</TotalPrice>
                    </ContentTotalPrice>
                  </ContentTotal>
                  <OrderButton>주문하기</OrderButton>
                </ContentDesc>
              </ModalContent>
            </ModalTobContainer>
            <ModalFooter>
              <FooterHeader>
                <FooterTitle>함께하면 더욱 맛있는 상품</FooterTitle>
                {/* <CardList cards={}></CardList> */}
              </FooterHeader>
              {/* <FooterMain></FooterMain> */}
            </ModalFooter>
          </ModalPopup>
        </ModalContainer>
      ) : (
        console.log("!")
      )}
    </ThemeProvider>
  );
};

export default Modal;
