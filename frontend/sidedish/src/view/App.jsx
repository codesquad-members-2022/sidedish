import GlobalStyle from "./GlobalStyle";
import { Routes, Route } from "react-router-dom";
import Home from "./Home";
import Login from "./Login";

function App() {
    return (
        <>
            <GlobalStyle />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </>
    );
}

export default App;
