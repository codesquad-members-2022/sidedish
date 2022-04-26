import {
    ImgWrapper,
    Img,
    TextContainer,
    Title,
    Description,
    PriceContainer,
    Price,
    EventBadge,
} from "./Card.style";

function EventBadges({ eventBadges }) {
    return eventBadges.map((eventBadge) => (
        <EventBadge
            key={eventBadge.eventBadgeId}
            eventBadgeColor={
                eventBadge.eventBadgeName === "런칭특가" ? "orange" : "green"
            }
        >
            {eventBadge.eventBadgeName}
        </EventBadge>
    ));
}

function Card({ title, image, description, price, eventBadges }) {
    const saledPrice = eventBadges
        ? price * ((100 - eventBadges[0].discount) / 100)
        : 0;
    const clientPrice = (
        <Price isClientPrice>
            {eventBadges ? saledPrice.toLocaleString() : price.toLocaleString()}
            원
        </Price>
    );
    const originalPrice = eventBadges ? (
        <Price isClientPrice={false}>{price.toLocaleString()}원</Price>
    ) : (
        ""
    );
    const eventTags = eventBadges ? (
        <EventBadges eventBadges={eventBadges} />
    ) : (
        ""
    );

    return (
        <li>
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
                            {originalPrice}
                        </>
                    </PriceContainer>
                </TextContainer>
                {eventTags}
            </div>
        </li>
    );
}

export default Card;
