import { GlobalStyle } from "./styles/global";
import { Header } from "./components/Header";
import { BestProduct } from "./components/BestProduct";
import { Category } from "./components/Category";
import { useEffect, useState } from "react";
import { SIZES } from "./convention";

function App() {
  const [cats, setCats] = useState([]);
  const [themes, setThemes] = useState([]);
  const [extended, setExtended] = useState(false);
  const [test, setTest] = useState(false);
  useEffect(() => {
    const fetchCat = async () => {
      try {
        const res = await (await fetch("categories.json")).json();
        const result = await (await fetch("themes.json")).json();
        setCats(res.categories);
        setThemes(result.themes);
      } catch (e) {
        console.log(e);
      }
    };
    fetchCat().then(() => console.log(cats, themes));
  }, []);

  return (
    <>
      <Header {...cats}></Header>
      {/*<BestProduct themes={themes}></BestProduct>*/}
      {cats.length ? (
        <Category {...cats[0]} size={SIZES.medium}></Category>
      ) : (
        <></>
      )}
    </>
  );
}

export default App;
