import styled from "styled-components";

import {DiscountTag} from "./DiscountTag";
import {useState} from "react";
import {thumbnailSize} from "../convention";


export const ProductInfo = styled.div`
  padding: 0px;
  ${props => props.theme.custom_flex('column', 'flex-start') + props.theme.custom_absolute(0, 0, 0, 0)}
`
const Description = styled.span``;
const Name = styled.span``;
const Price = styled.div``

const Body = styled.div`
  ${({theme}) => theme.flex_none(1, 16, 0) +
          theme.custom_flex("column", "flex-start") +
          theme.custom_static(427, null, null, 0) +
          theme.width_height_bypx(411, 92) +
          `
          ${Name} {
    ${({theme}) => theme.custom_font("Noto Sans KR", 16, 500, 26, -0.008) + theme.custom_static(0, null, null, 0) + `color:${theme.colors.Grey1}` + theme.flex_none(0, 8, 0)}
  }

  ${Description} {
    ${({theme}) => theme.width_height_bypx()}
  }
      `

  }

`;
const Image = styled.img`
  ${({theme, hover, size, img}) => theme.width_height_bypx(size, size) +
          `background:${hover ? "linear-gradient(0deg, rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1))" : ""} url(${img})` +
          theme.flex_none(0, 16, 0)
  }

`
export const ProductCard = ({size, name, description, price, final_price, primary_image, discount}) => {
    const [hover, setHover] = useState(false);
    return (
        <>
            <HoverInfo></HoverInfo>
            <ProductInfo>
                {size !== "small" && <DiscountTag discount={discount}></DiscountTag>}
                <Body>
                    <Price>
                        <span></span>
                        <span></span>
                    </Price>
                    {size !== "small" && <Description>{description}</Description>}
                    <Name>{name}</Name>
                </Body>
                <Image size={parseInt(thumbnailSize[size])} img={primary_image} hover={hover}></Image>
            </ProductInfo>
        </>
    )
}