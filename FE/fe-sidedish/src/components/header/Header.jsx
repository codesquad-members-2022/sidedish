import { useState } from 'react';

import * as S from './Header.style';

import iconMenusData from '../../data/iconMenus';
import categoriesData from '../../data/categories';

import HeaderTitle from './HeaderTitle';
import HeaderCategories from './HeaderCategories';
import IconMenus from './IconMenus';

const Header = () => {
  const [isOpen, setIsOpen] = useState(false);

  const handleMouseEnter = () => setIsOpen(true);
  const handleMouseLeave = () => setIsOpen(false);

  return (
    <S.Container isOpen={isOpen}>
      <S.Wrapper>
        <HeaderTitle title={'Ordering'} href={'/'} />

        <S.CategoryList onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
          <HeaderCategories isOpen={isOpen} categoriesData={categoriesData} />
        </S.CategoryList>

        <IconMenus iconMenusData={iconMenusData} />
      </S.Wrapper>
    </S.Container>
  );
};

export default Header;
