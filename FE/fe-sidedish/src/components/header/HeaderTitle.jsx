import { Link } from 'react-router-dom';

import * as S from './Header.style';

const HeaderTitle = ({ title, href }) => {
  const refreshPage = () => window.location.reload();

  return (
    <S.Title>
      <Link to={href} onClick={refreshPage}>
        {title}
      </Link>
    </S.Title>
  );
};

export default HeaderTitle;
