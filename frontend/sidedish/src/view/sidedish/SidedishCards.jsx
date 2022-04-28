import { BigCardsContainer, SmallCardsContainer } from "./Sidedish.style";
import Card from "./card/Card";
import { getRandomKey } from "../../utils";

function SidedishCards({ dishes, isBigCards }) {
    if (!dishes) {
        return <p>데이터가 아직 완성되지 않았어요</p>;
    }

    const sidedishCards = dishes.map((dish) => {
        if (!dish) {
            return <div key={getRandomKey()}></div>;
        }
        return (
            <Card
                key={dish.dishId}
                title={dish.title}
                image={dish.imagePath}
                description={dish.description}
                fixedPrice={dish.fixedPrice}
                discountPrice={dish.discountPrice}
                eventBadges={dish.discounts}
            />
        );
    });

    if (isBigCards) {
        return <BigCardsContainer>{sidedishCards}</BigCardsContainer>;
    }
    return <SmallCardsContainer>{sidedishCards}</SmallCardsContainer>;
}

export default SidedishCards;
