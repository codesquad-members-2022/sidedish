import { useEffect, useState } from "react";
import styled from "styled-components";
import {
  custom_absolute,
  custom_flex,
  custom_font,
  custom_static,
  flex_none,
  width_height_bypx,
} from "../styles/global";
import { EventBadge, LaunchBadge } from "../icons/EventBadge";
import { Plus, Minus } from "../icons/PlusMinus";
import { DiscountTag } from "./DiscountTag";
import { Carousel } from "./Carousel";
import { SIZES } from "../convention";

export const Modal = ({ openId }) => {
  const [info, setInfo] = useState();
  const [count, setCount] = useState(1);
  useEffect(() => {
    (async () => {
      const res = await (await fetch("/mocks/product.json")).json();
      setInfo(res);
    })();
  }, []);
  console.log(info, openId);
  return (
    <>
      {info && (
        <ModalWrapper onClick={(e) => e.stopPropagation()}>
          <ProductDetail>
            <BackgroundBox>
              <ProductImages>
                <PrimaryImage bgImg={info.primary_image}></PrimaryImage>
                <VariantWrapper>
                  {info.variant_image.map((img, key) => (
                    <VariantImage key={key} bgImg={img}></VariantImage>
                  ))}
                </VariantWrapper>
              </ProductImages>
              <ProductInfo>
                <Name>{info.name}</Name>
                <PrimeCost>{info.price}</PrimeCost>
                <BadgePrice>
                  <DiscountTag discount={info.discount} />
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
              <TotalWrapper>
                <TotalAmount>
                  <Minus
                    onClick={() =>
                      setCount((prev) => (prev === 0 ? 0 : prev - 1))
                    }
                  />
                  <span>{count}</span>
                  <Plus onClick={() => setCount((prev) => prev + 1)} />
                </TotalAmount>
                <TotalCost>
                  <span className="total">총 주문금액</span>
                  <span>{info.final_price}원</span>
                </TotalCost>
              </TotalWrapper>
              <Button>
                <span>주문하기</span>
              </Button>
            </BackgroundBox>
          </ProductDetail>
          <Line />
          <RelatedProduct>
            <Carousel
              categoryID={1}
              categoryName="함께하면 더욱 맛있는 상품"
              size={SIZES.small}
            ></Carousel>
          </RelatedProduct>
        </ModalWrapper>
      )}
    </>
  );
};

const BackgroundBox = styled.div`
  ${custom_absolute(0, null, null, 0)}
  ${width_height_bypx(960, 596)}
  background: #FFFFFF;
  border-radius: 0px;
`;
const ModalWrapper = styled.div`
  ${custom_flex("column", "flex-start")}
  ${custom_absolute(0, null, null, 0)}
  ${width_height_bypx(960, 994)}
  padding: 0px;
  border: 2px solid #000000;
  z-index: 100;
  opacity: 1;
`;
const ProductDetail = styled.div`
  ${width_height_bypx(960, 596)}
  ${custom_static(0, null, null, 0)}
  ${flex_none(0, 0, 0)}
}
`;
const RelatedProduct = styled.div`
  ${width_height_bypx(960, 396)}
  ${custom_static(598, null, null, 0)}
  ${flex_none(2, 0, 0)}
}
`;
const Button = styled.div`
  ${custom_flex("row", "center", "center")}
  ${custom_absolute(490, null, null, 472)}
  ${width_height_bypx(440, 58)}
  ${custom_font("Noto Sans KR", 18, 700, 26)}
  color: white;
  background: ${({ theme }) => theme.colors.Black};
`;
const TotalWrapper = styled.div`
  ${custom_absolute(339, null, null, 480)}
  ${width_height_bypx(440, 30)}
  ${custom_flex("row", "center", "space-between")}
}
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
  ${custom_absolute(76, null, null, 476)}
  ${width_height_bypx(440, 237)}
  ${custom_flex("column")}
`;
const ProductImages = styled.div`
  ${custom_absolute(76, null, null, 48)};
  width: 392px;
`;
const Line = styled.div`
  margin: 10px 0;
  ${width_height_bypx(440, 1)}
  background: ${({ theme }) => theme.colors.Grey4}
`;

const BadgePrice = styled.div`
  ${custom_flex("row", "center", "flex-start")}
  height: 30px;
`;
const PrimeCost = styled.span`
  ${custom_font("Noto Sans KR", 14, 500, 24, -0.008)}
  color: ${({ theme }) => theme.colors.Grey3};
`;

const Name = styled(PrimeCost)`
  font-size: 20px;
  line-height: 30px;
  color: ${({ theme }) => theme.colors.Black};
`;
const Price = styled(Name)`
  ${flex_none(1, 0, 8)}
`;

const Info = styled.div`
  margin: 10px 0;
  display: grid;
  row-gap: 10px;
  grid-template-rows: repeat(3, 1fr);
  grid-template-columns: 60px 1fr;
`;
const PrimaryImage = styled.img`
  ${width_height_bypx(392, 392)}
  background: url(${({ bgImg }) => bgImg});
  background-size: cover;
`;
const VariantImage = styled(PrimaryImage)`
  ${width_height_bypx(72, 72)}
  margin-right: 8px;
`;
const VariantWrapper = styled.div`
  margin-top: 8px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;
