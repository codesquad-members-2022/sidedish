import { useEffect, useState } from "react";
import {
    Popup,
    PopupBox, 
    PopupProduct, 
    PopupProductImgContainer, 
    PopupProductImg,
    PopupProductImgMini,
    PopupProductDetail,
    PopupProductInfo,
    PopupProductInfoCloseBtn,    
    PopupProductDetailSection1,
    PopupProductDetailSection2,
    PopupProductDetailSection3,
    PopupProductInfoName,
    PopupProductInfoPrimeCost,
    PopupProductInfoBadge,
    PopupProductInfoBadgePrice,
    PopupProductInfoBadgeTag,    
    PopupproductInfoPoint,
    PopupproductInfoPointText,
    PopupproductInfoPointLabel,
    PopupproductInfoDeliveryInfo,
    PopupproductInfoDeliveryInfoText,
    PopupproductInfoDeliveryInfoLabel,
    PopupproductInfoCharge,
    PopupproductInfoChargeText,
    PopupproductInfoChargeLabel,
    PopupProductOrderTotalAmount,
    PopupProductOrderTotalNumber,
    PopupProductOrderNumberPlusBtn,
    PopupProductOrderNumberMinusBtn,
    PopupProductOrderTotalCost,
    PopupProductOrderTotalCostText,
    PopupProductOrderTotalCostLabel,
    PopupProductOrderChoiceBtn,
    PopupProductOrderChoiceBtnText,
    RelatedProduct,
    RelatedProductHeader,
    RelatedProductTitle,
    RelatedProductNav,
    RelatedProductNavWholePage,
    RelatedProductNavCurrentPage,
    RelatedProductNavRightBtn,
    RelatedProductNavLeftBtn,
    RelatedProductWrapScroll,
    RelatedProductCard
} from "./Popup.style";
// import {RecommendCarousel, CarouselItem} from '../recommendCarousel/recommendCarousel'

function PopupProductPart({title, image, fixedPrice, discountPrice, eventBadges}){
    return (
        <>
        <PopupProduct >
            <PopupProductImgContainer>
                <PopupProductImg src={image} />
                <PopupProductImgMini src={image} />
            </PopupProductImgContainer>
            <PopupProductInfo>
                <PopupProductDetailSection1>
                    <PopupProductInfoName>{title}</PopupProductInfoName>
                    <PopupProductInfoPrimeCost>{fixedPrice}</PopupProductInfoPrimeCost>
                    <PopupProductInfoBadge>
                        <PopupProductInfoBadgeTag>{eventBadges}</PopupProductInfoBadgeTag>
                        <PopupProductInfoBadgePrice>{discountPrice}</PopupProductInfoBadgePrice>
                    </PopupProductInfoBadge>
                </PopupProductDetailSection1>
                <PopupProductDetailSection2>
                    <PopupproductInfoPoint>
                        <PopupproductInfoPointLabel>적립금</PopupproductInfoPointLabel>
                        <PopupproductInfoPointText>126원</PopupproductInfoPointText>
                    </PopupproductInfoPoint>
                    <PopupproductInfoDeliveryInfo>
                        <PopupproductInfoDeliveryInfoLabel>배송정보</PopupproductInfoDeliveryInfoLabel>
                        <PopupproductInfoDeliveryInfoText>서울,경기 새벽배송, 전국 택배 배송</PopupproductInfoDeliveryInfoText>
                    </PopupproductInfoDeliveryInfo>
                    <PopupproductInfoCharge>
                        <PopupproductInfoChargeLabel>배송비</PopupproductInfoChargeLabel>
                        <PopupproductInfoChargeText>2500원(40000원이상 구매 시 기프트)</PopupproductInfoChargeText>
                    </PopupproductInfoCharge>
                </PopupProductDetailSection2>
                <PopupProductDetailSection3>
                    <PopupProductOrderTotalAmount>
                        <PopupProductOrderNumberMinusBtn>minus</PopupProductOrderNumberMinusBtn>
                        <PopupProductOrderTotalNumber>1</PopupProductOrderTotalNumber>
                        <PopupProductOrderNumberPlusBtn>plus</PopupProductOrderNumberPlusBtn>
                    </PopupProductOrderTotalAmount>
                    <PopupProductOrderTotalCost>
                        <PopupProductOrderTotalCostLabel>총 주문금액</PopupProductOrderTotalCostLabel>
                        <PopupProductOrderTotalCostText>12640원</PopupProductOrderTotalCostText>
                    </PopupProductOrderTotalCost>
                </PopupProductDetailSection3>
                <PopupProductOrderChoiceBtn>
                    <PopupProductOrderChoiceBtnText>주문하기</PopupProductOrderChoiceBtnText>
                </PopupProductOrderChoiceBtn>
            </PopupProductInfo>
        </PopupProduct>
        </>
    );
}

function RelatedProductPart({related}){
    return (
        <>
        <RelatedProduct>
            <RelatedProductHeader>
            <RelatedProductTitle>함께하면 더욱 맛있는 상품</RelatedProductTitle>
            <RelatedProductNav>
                <RelatedProductNavLeftBtn>left</RelatedProductNavLeftBtn>
                <RelatedProductNavWholePage>4</RelatedProductNavWholePage>
                <RelatedProductNavCurrentPage>1</RelatedProductNavCurrentPage>
                <RelatedProductNavRightBtn>right</RelatedProductNavRightBtn>
            </RelatedProductNav>
            </RelatedProductHeader>
            <RelatedProductWrapScroll>
                {related}
            </RelatedProductWrapScroll>
        </RelatedProduct>
        </>
    );
}


function ProductDetailPopup(props) {
    const {
        show,
        handleClose,
        title, 
        image, 
        fixedPrice, 
        discountPrice, 
        eventBadges,
        relatedproduct
    } = {...props};
    const closeProductDetailPopup = () => handleClose(false);

    return (
        <>
        <Popup show={show}>
            <PopupBox>
                <PopupProductInfoCloseBtn onClick={closeProductDetailPopup}>닫기</PopupProductInfoCloseBtn>
                <PopupProductPart 
                    title={title}
                    image={image}
                    fixedPrice={fixedPrice}
                    discountPrice={discountPrice}
                    eventBadges={eventBadges}
                />
                <RelatedProductPart 
                    // related={relatedproduct} // 아직 기능 구현중이라 주석처리 해두었습니다.
                />
            </PopupBox>
        </Popup>
        </>
    );
}

export default ProductDetailPopup;
