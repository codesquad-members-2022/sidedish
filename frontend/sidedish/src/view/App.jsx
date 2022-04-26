import GlobalStyle from "./GlobalStyle";
import Header from "./header/Header";
import BigSidedish from "./sidedish/BigSidedish";
import SmallSidedish from "./sidedish/SmallSidedish";
import Button from "./sidedish/Button";

function App() {
    return (
        <>
            <GlobalStyle />
            <Header />
            <BigSidedish />
            <SmallSidedish />
            <Button text="모든 카테고리 보기" />
        </>
    );
}

export default App;
