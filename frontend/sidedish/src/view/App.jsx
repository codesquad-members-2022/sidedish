import GlobalStyle from "./GlobalStyle";
import Header from "./header/Header";
import BigSidedish from "./sidedish/BigSidedish";
import SmallSidedish from "./sidedish/SmallSidedish";
import Button from "./sidedish/Button";
import { useState } from "react";

function App() {
    const [isBtnVisible, setBtnVisibility] = useState(true);
    const btnClickEventHandler = () => {
        setBtnVisibility(false);
    };

    return (
        <>
            <GlobalStyle />
            <Header />
            <BigSidedish />
            <SmallSidedish />
            <Button
                text="모든 카테고리 보기"
                isBtnVisible={isBtnVisible}
                onClick={btnClickEventHandler}
            />
        </>
    );
}

export default App;
