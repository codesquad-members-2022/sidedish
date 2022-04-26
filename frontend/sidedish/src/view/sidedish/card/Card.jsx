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

function EventBadges(eventBadges) {
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
}) {
    const originPrice = (
        <Price isClientPrice={false}>{fixedPrice.toLocaleString()}원</Price>
    );
    const clientPrice = (
        <Price isClientPrice>
            {discountPrice.toLocaleString() && fixedPrice.toLocaleString()}원
        </Price>
    );
    const eventTags = eventBadges ? EventBadges(eventBadges) : null;

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
                            {fixedPrice !== discountPrice && originPrice}
                        </>
                    </PriceContainer>
                </TextContainer>
                {eventTags}
            </div>
        </li>
    );
}

export default Card;
