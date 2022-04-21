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
                    setIsLoaded(true);
                    setItems(result);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            );
    }, []);

    const Image = ({ img }) => {
        return (
            <div className="small-sidedish__card-img-container">
                <img className="small-sidedish__card-img" src={img} />
            </div>
        );
    };
    const cardItemText = (text) => {
        return <h3 className="small-sidedish__card-name">{text}</h3>;
    };
    const cardItemDescription = (des) => {
        return <p className="small-sidedish__card-description">{des}</p>;
    };
    const cardItemPrices = (pre, cur) => {
        return (
            <div className="small-sidedish__card-prices">
                <span className="small-sidedish__card-price--default">
                    {pre}
                </span>
                <span className="small-sidedish__card-price--option">
                    {cur}
                </span>
            </div>
        );
    };
    const cardTagLaunch = (lan) => {
        return <span className="small-sidedish__card-tag--launch">{lan}</span>;
    };

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
            {items.data.dishes.map((dish) => {
                return (
                    <>
                        <SmallCard
                            img={dish.image_url}
                            text={dish.title}
                            des={dish.description}
                            pre={dish.price}
                            cur={dish.price}
                            lan={dish.event_badge.event_name}
                        />
                    </>
                );
            })}
        </>
    );
}

function SmallSidedish() {
    // const [dish, setDish] = useState({
    //     items: [],
    //     DataisLoaded: false,
    // });
    // const componentDidMount = () =>
    //     fetch(
    //         "https://273b4433-0674-40c4-9d88-6ab939cd01f8.mock.pstmn.io/api/dish?section=정갈한-밑반찬&flat=true&page=1"
    //     )
    //         .then((res) => res.json())
    //         .then((json) => {
    //             dish.setDish({
    //                 items: json,
    //                 DataisLoaded: true,
    //             });
    //         });
    // const render = () => {
    //     const { DataisLoaded, items } = dish;
    //     if (!DataisLoaded)
    //         return (
    //             <div>
    //                 <h3>please wait some time...</h3>
    //             </div>
    //         );

    // if (error) {
    //     return <div>Error: {error.message}</div>;
    // } else if (!isLoaded) {
    //     return <div>Loading...</div>;
    // } else {
    //     return (
    //         <ul>
    //             {items.map((item) => (
    //                 <li key={item.dishes}>
    //                     {item.title}
    //                     {item.description}
    //                 </li>
    //             ))}
    //         </ul>
    //     );
    // }

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
// }

export default SmallSidedish;
