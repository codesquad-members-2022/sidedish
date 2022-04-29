import {useState} from 'react';
import { BigCardsContainer, SmallCardsContainer } from "./Sidedish.style";
import Card from "./card/Card";
import ProductDetailPopup from "./popup/Popup";
import { CardContainer } from "./card/Card.style";
import { getRandomKey } from "../../utils";

function SidedishCards({ dishes, isBigCards }) {
    const [open, setOpen] = useState(false);
    const openPopup = () => {setOpen(true)};
    const closePopup = () => {setOpen(false)};
    const [modaldata, setModaldata] = useState([]);
    const putModaldata = (data) => {
        setModaldata(data);
    }

    if (!dishes) {
        return <p>데이터가 아직 완성되지 않았어요</p>;
    }

    const sidedishCards = dishes.map((dish) => {
        if (!dish) {
            return <div key={getRandomKey()}></div>;
        }
        return (
            <CardContainer onClick={() => {
                openPopup();
                putModaldata(dish);
                console.log(dish);
                }}>
                <Card
                    key={dish.dishId}
                    title={dish.title}
                    image={dish.imagePath}
                    description={dish.description}
                    fixedPrice={dish.fixedPrice}
                    discountPrice={dish.discountPrice}
                    eventBadges={dish.discounts}
                />
            </CardContainer>
            
        );
    });

    const relatedCards = dishes.map((dish) => {
        if(!dish){
            return <div key={getRandomKey()}></div>;
        }
        console.log('related!');
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
        return <BigCardsContainer>
            {sidedishCards}
            <ProductDetailPopup
            show={open}
            handleClose={closePopup}
            title={modaldata.title}
            image={modaldata.imagePath}
            fixedPrice={modaldata.fixedPrice}
            discountPrice={modaldata.discountPrice}
            eventBadges={modaldata.discounts}
            related={relatedCards}
            />
            </BigCardsContainer>;
    }
    return <SmallCardsContainer>
        {sidedishCards}
        <ProductDetailPopup
            show={open}
            handleClose={closePopup}
            title={modaldata.title}
            image={modaldata.imagePath}
            fixedPrice={modaldata.fixedPrice}
            discountPrice={modaldata.discountPrice}
            eventBadges={modaldata.discounts} 
            relatedproduct={relatedCards}
        />
        </SmallCardsContainer>;
}

export default SidedishCards;
