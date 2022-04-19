import { icons } from "./constants.js"

function Header() {
  const gnbMenus = ["든든한 메인요리", "뜨끈한 국물요리", "정갈한 밑반찬"]

  const gnbLists = gnbMenus.map((v, i) => <li key={i}>{v}</li>)

  return (
    <div className="Header">
      <header className="App-header">
        <div>
          <h1>Ordering</h1>
          <ul>
            {gnbLists}
          </ul>
        </div>
        <div>
          { icons.mypage }
        </div>
      </header>
    </div>
  );
}

export default Header;
