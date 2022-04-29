import {
    CardContainer,
    ImgWrapper,
    Img,
    TextContainer,
    Title,
    Description,
    PriceContainer,
    ClientPrice,
    OriginPrice,
    EventBadge,
} from "./Card.style";

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
}) {
    const originPrice = (
        <OriginPrice>{fixedPrice.toLocaleString()}원</OriginPrice>
    );
    const clientPrice = (
        <ClientPrice>{discountPrice.toLocaleString()}원</ClientPrice>
    );
    const isDiscounted = fixedPrice !== discountPrice;

    return (
        <>
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
        </>
    );
}

export default Card;
