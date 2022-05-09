import { Header } from "@/components/templates/Header/Header";
import { Promotion } from "@/components/templates/Promotion/Promotion";
import { CategorySection } from "@/components/templates/Category/CategorySection.jsx";
import "./App.scss";
import { categoryTitles } from "@/constant/constant.js";

function App() {
  return (
    <div>
      <Header />
      <main>
        <Promotion dataID="1" />
        <CategorySection title={categoryTitles["1"]} dataName="category" dataID="1" />
      </main>
    </div>
  );
}

export default App;
