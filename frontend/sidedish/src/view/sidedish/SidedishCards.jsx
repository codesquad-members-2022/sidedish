import { CardsContainer } from "./Sidedish.style";
import Card from "./card/Card";

function SidedishCards({ dishes }) {
    if (!dishes) {
        return <p>데이터가 아직 완성되지 않았어요</p>;
    }

    const sidedishCards = dishes.map((dish) => (
        <Card
            key={dish.dishId}
            title={dish.title}
            image={dish.imagePath}
            description={dish.description}
            fixedPrice={dish.fixedPrice}
            discountPrice={dish.discountPrice}
            eventBadges={dish.discounts}
        />
    ));

    return <CardsContainer>{sidedishCards}</CardsContainer>;
}

export default SidedishCards;
