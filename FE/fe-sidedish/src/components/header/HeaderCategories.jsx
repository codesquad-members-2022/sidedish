import { Link } from 'react-router-dom';

import * as S from './Header.style';

const HeaderCategories = ({ isOpen, categoriesData }) => {
  return categoriesData.map(_getCategory(isOpen));
};

const _getCategory =
  isOpen =>
  ({ id, categoryTitle, categoryMenus }) =>
    (
      <li key={id}>
        <S.CategoryTitle>{categoryTitle}</S.CategoryTitle>
        <S.CategoryMenuList isOpen={isOpen}>
          {categoryMenus.map(_getCategoryMenuItem)}
        </S.CategoryMenuList>
      </li>
    );

const _getCategoryMenuItem = ({ id, menu }) => (
  <S.CategoryMenu key={id}>
    <Link to='#'>{menu}</Link>
  </S.CategoryMenu>
);

export default HeaderCategories;
