import { useEffect, useState, useRef } from "react";
import { Animated, FlatList, View } from "react-native-web";
import "./SmallSidedish.css";

function SmallCard({ id, img, text, des, pre, cur, lan }) {
    return (
        <li className="small-sidedish__card" id={id}>
            <div className="small-sidedish__card-img-container">
                <img className="small-sidedish__card-img" src={img} />
            </div>
            <div className="small-sidedish__card-item">
                <div className="small-sidedish__card-item--text">
                    <h3 className="small-sidedish__card-name">{text}</h3>
                    <p className="small-sidedish__card-description">{des}</p>
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
}

function SmallSidedishCard() {
    const [error, setError] = useState("null");
    const [isLoaded, setIsLoaded] = useState("false");
    const [items, setItems] = useState([]);

    useEffect(() => {
        fetch(
            "https://273b4433-0674-40c4-9d88-6ab939cd01f8.mock.pstmn.io/api/dish?section=정갈한-밑반찬"
        )
            .then((res) => res.json())
            .then(
                (result) => {
                    console.log(result);
                    setItems(result);
                    setIsLoaded(true);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            );
    }, []);

    if (isLoaded === true) {
        return (
            <>
                {items.data.map((dish) => {
                    return (
                        <>
                            <SmallCard
                                id={dish.dishId}
                                img={dish.imagePath}
                                text={dish.title}
                                des={dish.description}
                                pre={dish.price}
                                cur={dish.price}
                                lan={dish.stock}
                            />
                        </>
                    );
                })}
            </>
        );
    }
}

function SmallSidedish() {
    const [error, setError] = useState("null");
    const [isLoaded, setIsLoaded] = useState("false");
    const [items, setItems] = useState([]);

    useEffect(() => {
        fetch(
            "https://273b4433-0674-40c4-9d88-6ab939cd01f8.mock.pstmn.io/api/dish?section=정갈한-밑반찬"
        )
            .then((res) => res.json())
            .then(
                (result) => {
                    console.log(result);
                    setItems(result);
                    setIsLoaded(true);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            );
    }, []);

    const dataLoaded = () => {
        if (isLoaded) {
            return items;
        }
    };

    const slider = useRef(new Animated.ValueXY()).current;

    const dishSlider = () => {
        console.log("dish slides!");
    };

    const renderItems = ({ dish }) => {
        <SmallCard
            id={dish.dishId}
            img={dish.imagePath}
            text={dish.title}
            des={dish.description}
            pre={dish.price}
            cur={dish.price}
            lan={dish.stock}
        />;
    };

    return (
        <div className="small-sidedish">
            <div className="small-sidedish__header">
                <h3 className="small-sidedish__title">
                    식탁을 풍성하게 하는 정갈한 밑반찬
                </h3>
            </div>
            <div className="flatlist">
                <FlatList
                    className="small-sidedish__cards"
                    data={dataLoaded}
                    renderItem={renderItems}
                    onScroll={Animated.event(
                        [{ nativeEvent: { contentOffset: { x: slider.x } } }],
                        { useNativeDriver: false }
                    )}
                    keyExtractor={(item) => item.id}
                />
            </div>

            <button onClick={dishSlider}>pre</button>
            <button onClick={dishSlider}>next</button>
        </div>
    );
}

export default SmallSidedish;
