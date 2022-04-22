import { Link } from "react-router-dom";
import { Title } from "./Header.style";

const HeaderTitle = ({ title, href }) => {
  return (
    <Title>
      <Link to="/" onClick={() => (window.location.href = href)}>
        {title}
      </Link>
    </Title>
  );
};

export default HeaderTitle;
