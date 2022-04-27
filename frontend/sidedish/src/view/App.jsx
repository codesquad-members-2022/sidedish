import GlobalStyle from "./GlobalStyle";
import Header from "./header/Header";
import BigSidedish from "./sidedish/BigSidedish";
import SmallSidedish from "./sidedish/SmallSidedish";
import Button from "./sidedish/Button";
import { useState } from "react";

function App() {
    const [isBtnVisible, setBtnVisibility] = useState(true);
    const [isAllCateVisible, setAllCateVisibility] = useState(false);
    const btnClickEventHandler = () => {
        setBtnVisibility(false);
        setAllCateVisibility(true);
    };

    return (
        <>
            <GlobalStyle />
            <Header />
            <BigSidedish />
            <SmallSidedish
                isVisible
                section="정갈한-밑반찬"
                title="식탁을 풍성하게 하는 정갈한 밑반찬"
            />
            <Button
                text="모든 카테고리 보기"
                isBtnVisible={isBtnVisible}
                onClick={btnClickEventHandler}
            />
            <SmallSidedish
                isVisible={isAllCateVisible}
                section="뜨끈한-국물요리"
                title="정성이 담긴 뜨끈뜨끈 국물 요리"
            />
            <SmallSidedish
                isVisible={isAllCateVisible}
                section="든든한-메인요리"
                title="모두가 좋아하는 든든한 메인 요리"
            />
        </>
    );
}

export default App;
