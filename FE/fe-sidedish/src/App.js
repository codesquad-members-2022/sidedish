import "./styles/base/app.scss";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Main from "./components/pages/Main";
import NotFound from "./components/pages/NotFound";
import Header from "./components/header/Header";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
