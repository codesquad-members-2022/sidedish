import { useEffect, useState } from "react";
import styled from "styled-components";
import {
  custom_absolute,
  custom_flex,
  custom_font,
  custom_static,
  flex_none,
  Minus,
  width_height_bypx,
} from "../styles/global";
import { EventBadge, LaunchBadge } from "../icons/EventBadge";
import { Plus } from "../icons/PlusMinus";

export const Modal = ({ id }) => {
  const [info, setInfo] = useState();
  const [count, setCount] = useState(1);
  useEffect(() => {
    (async () => {
      const res = await (await fetch("/mocks/product.json")).json();
      setInfo(res);
    })();
  }, []);
  return (
    <>
      {info && (
        <ModalWrapper>
          <ProductDetail>
            <BackgroundBox>
              <ProductImages>
                <PrimaryImage bgImg={info.primary_image}></PrimaryImage>
                {info.variang_image.map((img) => (
                  <VariantImage bgImg={img}></VariantImage>
                ))}
              </ProductImages>
              <ProductInfo>
                <Name>{info.name}</Name>
                <PrimeCost>{info.price}</PrimeCost>
                <BadgePrice>
                  {info.discount.map((dc) =>
                    dc.id === 1 ? <EventBadge /> : <LaunchBadge />
                  )}
                </BadgePrice>
                <Line></Line>
                <Info>
                  <div>적립금</div>
                  <div>{info.mileage}</div>
                  <div>배송정보</div>
                  <div>
                    {info.eary_morning_delivery && "서울 경기 새벽배송"}{" "}
                    {info.nationwide_delivery && "전국 택배배송"}
                  </div>
                  <div>배송비</div>
                  <div>
                    {info.delivery_rate}{" "}
                    {`(${info.free_delivery_threshold}원 이상 주문시 무료`}
                  </div>
                </Info>
                <Line></Line>
              </ProductInfo>
              <div
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  alignItems: "center",
                }}
              >
                <TotalAmount>
                  <Plus onClick={() => setCount((prev) => prev + 1)} />
                  <span>{count}</span>
                  <Minus
                    onClick={() =>
                      setCount((prev) => (prev === 0 ? 0 : prev - 1))
                    }
                  />
                </TotalAmount>
                <TotalCost>
                  <span className="total">총 주문금액</span>
                  <span>{info.final_price}원</span>
                </TotalCost>
              </div>
              <Button></Button>
            </BackgroundBox>
          </ProductDetail>
          <Line />
          <RelatedProduct></RelatedProduct>
        </ModalWrapper>
      )}
    </>
  );
};
const BackgroundBox = styled.div`
  ${custom_absolute(0, null, null, 0)}
  ${width_height_bypx(960, 596)}
`;
const ModalWrapper = styled.div`
  ${custom_flex("column", "flex-start") +
  custom_absolute(0, null, null, 0) +
  width_height_bypx(960, 994)}
  padding: 0px;
  border: 2px solid #000000;
`;
const ProductDetail = styled.div`
  ${width_height_bypx(960, 596) +
  custom_static(0, null, null, 0) +
  flex_none(0, 0, 0)}
`;
const RelatedProduct = styled.div`
  ${width_height_bypx(960, 396) +
  custom_static(598, null, null, 0) +
  flex_none(2, 0, 0)}
`;
const Button = styled.div`
  ${custom_flex("row", "flex-start") +
  custom_absolute(490, 472) +
  width_height_bypx(440, 58)}
  background: ${({ theme }) => theme.colors.Black}
`;
const TotalCost = styled.div`
  ${custom_flex("row", "center", "flex-end")}
  ${width_height_bypx(174, 30)}
  padding: 0px;

  span {
    ${custom_font("Noto Sans KR", 20, 500, 30)}
    color: ${({ theme }) => theme.colors.Black}
  }

  &.total {
    ${custom_font("Noto Sans KR", 16, 400, 26)}
    color: ${({ theme }) => theme.colors.Grey2}
  }
`;
const TotalAmount = styled.div`
  ${custom_flex("row", "center", "center")}
  ${width_height_bypx(88, 26)}
`;
const ProductInfo = styled.div`
  ${custom_absolute(76, 472)}
  ${width_height_bypx(440, 237)}
  ${custom_flex("column")}
`;
const ProductImages = styled.div`
  ${custom_absolute(76, null, null, 48)}
  ${width_height_bypx(392, 472)}
`;
const Line = styled.div`
  ${width_height_bypx(440, 1)}
  background: ${({ theme }) => theme.colors.Grey4}
`;

const BadgePrice = styled.div`
  ${custom_flex("row", "center", "flex-start")}
  height: 30px;
`;
const Price = styled(Name)`
  ${flex_none(1, 0, 8)}
`;
const PrimeCost = styled.span`
  ${custom_font("Noto Sans KR", 14, 500, 24, -0.008)}
  color: ${({ theme }) => theme.colors.Grey3};
`;
const Name = styled(PrimeCost)`
  font-size: 20px;
  line-height: 30px;
  color: ${({ theme }) => theme.color.Black};
`;
const Info = styled.div`
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  grid-template-rows: 60px 1fr;
`;
const PrimaryImage = styled.img`
  ${width_height_bypx(392, 392) + custom_absolute(0, null, null, 0)}
  background: url(${({ bgImg }) => bgImg})
`;
const VariantImage = styled(PrimaryImage)`
  ${width_height_bypx(72, 72) + custom_absolute(null, null, 0, null)}
  margin-right: 8px;
`;
