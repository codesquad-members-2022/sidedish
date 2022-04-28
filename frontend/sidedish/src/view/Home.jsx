import Header from "./header/Header";
import BigSidedish from "./sidedish/BigSidedish";
import SmallSidedish from "./sidedish/SmallSidedish";
import Button2ShowAllCategory from "./sidedish/Button2ShowAllCategory";
import { useState } from "react";

const category = [
    { title: "식탁을 풍성하게 하는 정갈한 밑반찬", section: "정갈한-밑반찬" },
    { title: "정성이 담긴 뜨끈뜨끈 국물 요리", section: "뜨끈한-국물요리" },
    { title: "모두가 좋아하는 든든한 메인 요리", section: "든든한-메인요리" },
];

function Home() {
    const [isBtnVisible, setBtnVisibility] = useState(true);
    const [isAllCategoryVisible, setAllCategoryVisibility] = useState(false);
    const btnClickEventHandler = () => {
        setBtnVisibility(false);
        setAllCategoryVisibility(true);
    };

    return (
        <>
            <Header />
            <BigSidedish />
            <SmallSidedish isVisible category={category[0]} />
            <Button2ShowAllCategory
                text="모든 카테고리 보기"
                isBtnVisible={isBtnVisible}
                onClick={btnClickEventHandler}
            />
            <SmallSidedish
                isVisible={isAllCategoryVisible}
                category={category[1]}
            />
            <SmallSidedish
                isVisible={isAllCategoryVisible}
                category={category[2]}
            />
        </>
    );
}

export default Home;
