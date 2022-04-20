import React, { useState } from 'react';
import styled from 'styled-components';
import logo from '../images/logo.png';

const StyledHeader = styled.header`
  position: fixed;
  display: flex;
  border-bottom: 1px solid black;
  justify-content: space-between;
  width: 100vw;
`;
const Logo = styled.div`
  font-family: 'Outfit';
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
`;
const GNB = styled.div`
  margin-top: 28px;
`;
const MainCategories = styled.div`
  display: flex;
`;
const SubCategories = styled.div`
  display: flex;
`;
const Icons = styled.div`
  margin-top: 28px;
`;
const SubCategory = styled.div``;
function Header({ categories }) {
  const [isSubCategoriesShown, setIsSubCategoriesShown] = useState(false);

  function showSubCategory() {
    setIsSubCategoriesShown(true);
  }
  function hideSubCategory() {
    setIsSubCategoriesShown(false);
  }
  return (
    <StyledHeader>
      <Logo className="logo">Ordering</Logo>
      <GNB className="GNB" onMouseEnter={showSubCategory} onMouseLeave={hideSubCategory}>
        <MainCategories>
          {categories.map(({ name }) => (
            <div className="category">{name}</div>
          ))}
        </MainCategories>
        {isSubCategoriesShown ? (
          <SubCategories>
            {categories.map(({ children }) => (
              <ul>
                {children.map(({ id, name }) => (
                  <li key={id}>{name}</li>
                ))}
              </ul>
            ))}
          </SubCategories>
        ) : (
          ''
        )}
      </GNB>
      <Icons>
        <div className="search-icon">🔎</div>
        <div className="my-page-icon">🧑‍💻</div>
        <div className="shopping-cart">🛒</div>
      </Icons>
    </StyledHeader>
  );
}

export default Header;
