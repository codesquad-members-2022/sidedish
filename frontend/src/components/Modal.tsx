import { useContext, useEffect, useState } from "react";
import styled from "styled-components";
import {
  custom_absolute,
  custom_flex,
  custom_font,
  width_height_bypx,
} from "../styles/global";
import { Plus, Minus } from "../icons/PlusMinus";
import { DiscountTag } from "./DiscountTag";
import { Carousel } from "./Carousel";
import { Queries } from "../convention";
import { ModalContext } from "../ModalReducer";
import { Line } from "./HorizontalLine";
import { useFetch } from "../fetcher";
import { Product, SIZES } from "../types";

export const Modal = ({ openId }: { openId: number }) => {
  const [count, setCount] = useState(1);
  const [primaryImage, setPrimaryImage] = useState<string>("");
  const [variantImages, setVariantImages] = useState<string[]>([]);

  const info = useFetch(Queries.product, openId, openId);
  useEffect(() => {
    setPrimaryImage(info.primaryImage);
    setVariantImages(info.variantImages);
  }, [info]);
  const { setOpenedId } = useContext(ModalContext);

  const changePrimary = (key: number, img: string) => {
    const newVariants = [...variantImages, primaryImage];
    const newPrimary = img;
    newVariants.splice(key, 1);
    setVariantImages(newVariants);
    setPrimaryImage(newPrimary);
  };
  return (
    <>
      {info && (
        <ModalBackground onClick={(e) => setOpenedId(-1)}>
          <ModalWrapper onClick={(e) => e.stopPropagation()}>
            <MainProduct>
              <ProductImageWrapper>
                <PrimaryImage bgImg={primaryImage}></PrimaryImage>
                <VariantWrapper>
                  {variantImages?.map((img, key) => (
                    <VariantImage
                      key={key}
                      bgImg={img}
                      onClick={() => changePrimary(key, img)}
                    ></VariantImage>
                  ))}
                </VariantWrapper>
              </ProductImageWrapper>
              <ProductOrderWrapper>
                <ProductMainInfo>
                  <Name>{info.name}</Name>
                  <PrimeCost>{info.basePrice?.toLocaleString()}원</PrimeCost>
                  <BadgePrice>
                    <DiscountTag discounts={info.discounts} />
                    {info.finalPrice?.toLocaleString()}원
                  </BadgePrice>
                </ProductMainInfo>
                <Line />
                <ProductSubInfo>
                  <div>적립금</div>
                  <div>{info.mileage?.toLocaleString()}원</div>
                  <div>배송정보</div>
                  <div>
                    {info.earlyMorningDelivery && "서울 경기 새벽배송"}{" "}
                    {info.nationwideDelivery && "전국 택배배송"}
                  </div>
                  <div>배송비</div>
                  <div>
                    {`${info.deliveryRate?.toLocaleString()}원
                        (${info.freeDeliveryThreshold?.toLocaleString()}원 이상 주문시 무료)`}
                  </div>
                </ProductSubInfo>
                <Line />
                <TotalWrapper>
                  <TotalAmount>
                    <IconWrapper
                      onClick={() => setCount((prev) => Math.max(prev - 1, 0))}
                    >
                      <Minus />
                    </IconWrapper>
                    <span>{count}</span>
                    <IconWrapper onClick={() => setCount((prev) => prev + 1)}>
                      <Plus />
                    </IconWrapper>
                  </TotalAmount>
                  <TotalCost>
                    <span className="total">총 주문금액</span>
                    <span>{(info.finalPrice * count).toLocaleString()}원</span>
                  </TotalCost>
                </TotalWrapper>
                <Button>
                  <span>주문하기</span>
                </Button>
              </ProductOrderWrapper>
            </MainProduct>
            <Line color={"Black"} />
            <RelatedProduct>
              <Carousel
                id={1}
                title={"함께하면 좋은 요리"}
                size={SIZES.small}
              ></Carousel>
            </RelatedProduct>
          </ModalWrapper>
        </ModalBackground>
      )}
    </>
  );
};

const ModalBackground = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.3);
`;

const ModalWrapper = styled.div`
  border: 2px solid #000000;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: ${({ theme }) => theme.colors.White};
  ${width_height_bypx(960, 994)}
`;

const MainProduct = styled.div`
  ${custom_flex("row", "flex-start", "space-between")}
  margin: 76px 48px 48px 48px;
`;

const ProductImageWrapper = styled.div``;

const PrimaryImage = styled.img<{ bgImg: string }>`
  ${width_height_bypx(392, 392)}
  background: url(${({ bgImg }) => bgImg});
  background-size: cover;
`;

const VariantWrapper = styled.div`
  margin-top: 8px;
  display: flex;
  align-items: center;
`;

const VariantImage = styled(PrimaryImage)`
  ${width_height_bypx(72, 72)}
  margin-right: 8px;
`;

const ProductOrderWrapper = styled.div`
  ${width_height_bypx(440, 237)}
`;

const ProductMainInfo = styled.div`
  ${custom_flex("column")}
`;

const Name = styled.span`
  ${custom_font("Noto Sans KR", 20, 500, 30, -0.008)}
  margin-bottom: 16px;
`;

const PrimeCost = styled.span`
  ${custom_font("Noto Sans KR", 14, 500, 24, -0.008)}
  color: ${({ theme }) => theme.colors.Grey3};
  margin-bottom: 8px;
`;

const BadgePrice = styled.div`
  ${custom_flex("row", "center", "flex-start")}
  ${custom_font("Noto Sans KR", 20, 500, 30, -0.008)}
  margin-bottom: 24px;
`;

const ProductSubInfo = styled.div`
  margin: 17px 0;
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  grid-template-columns: 60px 1fr;
  row-gap: 8px;
  column-gap: 16px;

  ${custom_font("Noto Sans KR", 12, 400, 18, -0.008)}
  div:nth-child(2n + 1) {
    color: ${({ theme }) => theme.colors.Grey2};
  }
`;

const TotalWrapper = styled.div`
  margin-top: 24px;
  ${width_height_bypx(440, 30)}
  ${custom_flex("row", "center", "space-between")}
`;

const TotalCost = styled.div`
  ${custom_flex("row", "center", "flex-end")}
  span {
    ${custom_font("Noto Sans KR", 20, 500, 30)}
    color: ${({ theme }) => theme.colors.Black}
  }

  .total {
    ${custom_font("Noto Sans KR", 16, 400, 26)}
    margin-right: 16px;
    color: ${({ theme }) => theme.colors.Grey2};
  }
`;

const TotalAmount = styled.div`
  ${custom_flex("row", "center", "center")}
  ${width_height_bypx(88, 26)}
  span {
    width: 40px;
    text-align: center;
    ${custom_font("Noto Sans KR", 16, 500, 26)}
  }
`;

const IconWrapper = styled.div`
  ${width_height_bypx(24, 24)};
  ${custom_flex("row", "center", "center")}
`;

const Button = styled.div`
  ${custom_flex("row", "center", "center")}
  ${custom_absolute(490, null, null, 472)}
  ${width_height_bypx(440, 58)}
  ${custom_font("Noto Sans KR", 18, 700, 26)}
  color: white;
  background: ${({ theme }) => theme.colors.Black};
`;

const RelatedProduct = styled.div`
  position: relative;
  padding: 48px 48px 64px 48px;
`;
