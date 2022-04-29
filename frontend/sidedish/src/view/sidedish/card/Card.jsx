import { useState } from "react";
import {
    DishCard,
    ImgWrapper,
    Img,
    TextContainer,
    Title,
    Description,
    PriceContainer,
    ClientPrice,
    OriginPrice,
    EventBadge,
    DeliveryBadge,
} from "./Card.style";
import { getRandomKey } from "../../../utils";

function Deliveries({ deliveries, isDeliveryBadgeVisible }) {
    if (!deliveries || !deliveries.length) {
        return;
    }

    const deliveryItems = deliveries.map((delivery) => (
        <li key={getRandomKey()}>{delivery}</li>
    ));

    return (
        <DeliveryBadge isVisible={isDeliveryBadgeVisible}>
            {deliveryItems}
        </DeliveryBadge>
    );
}

function EventBadges({ eventBadges }) {
    if (!eventBadges.length) {
        return;
    }
    return eventBadges.map((eventBadge, idx) => (
        <EventBadge
            key={idx}
            eventBadgeColor={eventBadge === "런칭특가" ? "orange" : "green"}
        >
            {eventBadge}
        </EventBadge>
    ));
}

function Card({
    title,
    image,
    description,
    fixedPrice,
    discountPrice,
    eventBadges,
    deliveries,
}) {
    const [isDeliveryBadgeVisible, setDeliveryBadgeVisibility] =
        useState(false);
    const originPrice = (
        <OriginPrice>{fixedPrice.toLocaleString()}원</OriginPrice>
    );
    const clientPrice = (
        <ClientPrice>{discountPrice.toLocaleString()}원</ClientPrice>
    );
    const isDiscounted = fixedPrice !== discountPrice;

    const showDeliveryBadge = () => setDeliveryBadgeVisibility(true);
    const hideDeliveryBadge = () => setDeliveryBadgeVisibility(false);

    return (
        <DishCard
            onMouseOver={showDeliveryBadge}
            onMouseOut={hideDeliveryBadge}
        >
            <Deliveries
                deliveries={deliveries}
                isDeliveryBadgeVisible={isDeliveryBadgeVisible}
            />
            <ImgWrapper>
                <Img alt={title} src={image} />
            </ImgWrapper>
            <div>
                <TextContainer>
                    <Title>{title}</Title>
                    <Description>{description}</Description>
                    <PriceContainer>
                        <>
                            {clientPrice}
                            {isDiscounted && originPrice}
                        </>
                    </PriceContainer>
                </TextContainer>
                <EventBadges eventBadges={eventBadges} />
            </div>
        </DishCard>
    );
}

export default Card;
