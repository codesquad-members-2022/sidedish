import { useEffect, useState } from "react";
import "./SmallSidedish.css";

function SmallSidedishCard() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    useEffect(() => {
        fetch(
            "https://273b4433-0674-40c4-9d88-6ab939cd01f8.mock.pstmn.io/api/dish?section=정갈한-밑반찬&flat=true&page=1"
        )
            .then((res) => res.json())
            .then(
                (result) => {
                    console.log(result);
                    setIsLoaded(true);
                    setItems(result);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            );
    }, []);

    const SmallCard = ({ img, text, des, pre, cur, lan }) => {
        return (
            <li className="small-sidedish__card">
                <div className="small-sidedish__card-img-container">
                    <img className="small-sidedish__card-img" src={img} />
                </div>
                <div className="small-sidedish__card-item">
                    <div className="small-sidedish__card-item--text">
                        <h3 className="small-sidedish__card-name">{text}</h3>
                        <p className="small-sidedish__card-description">
                            {des}
                        </p>
                    </div>
                </div>
                <div className="small-sidedish__card-prices">
                    <span className="small-sidedish__card-price--default">
                        {pre}
                    </span>
                    <span className="small-sidedish__card-price--option">
                        {cur}
                    </span>
                </div>
                <span className="small-sidedish__card-tag--launch">{lan}</span>
            </li>
        );
    };

    return (
        <>
            {items.data.map((dish) => {
                return (
                    <>
                        <SmallCard
                            img={dish.imagePath}
                            text={dish.title}
                            des={dish.description}
                            pre={dish.price}
                            cur={dish.price}
                            lan={dish.eventBadges.eventBadgeName}
                        />
                    </>
                );
            })}
        </>
    );
}

function SmallSidedish() {
    return (
        <div className="small-sidedish">
            <div className="small-sidedish__header">
                <h3 className="small-sidedish__title">
                    식탁을 풍성하게 하는 정갈한 밑반찬
                </h3>
            </div>
            <SmallSidedishCard />;
        </div>
    );
}

export default SmallSidedish;
