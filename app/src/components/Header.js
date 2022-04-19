const Header = () => {
  return (
    <div>
      <div className="logo"></div>
      <ul>
        <li className="main-dish">
          <ul>
            <li className="meat"></li>
            <li className="sea-food"></li>
          </ul>
        </li>
        <li className="soup">
          <ul>
            <li className="soups"></li>
          </ul>
        </li>
        <li className="side-dish">
          <ul>
            <li className="season-vegetable"></li>
            <li className="fried-dish"></li>
            <li className="pickled"></li>
          </ul>
        </li>
      </ul>
      <ul>
        <li className="search"></li>
        <li className="my-page"></li>
        <li className="cart"></li>
      </ul>
    </div>
  );
};

export default Header;
