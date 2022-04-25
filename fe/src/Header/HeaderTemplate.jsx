import { useState } from 'react';
import styled from 'styled-components';
import HeaderCategory from 'Header/HeaderCategory';
import { ReactComponent as CartImage } from 'image/cart.svg';
import { ReactComponent as PersonImage } from 'image/person.svg';
import { ReactComponent as SearchImage } from 'image/search.svg';
import { CATEGORY_TEXTS } from 'MockData/dummyData';

const HeaderLogo = styled.div`
  ${({ theme }) => theme.fontStyles.logo};
  margin-right: 40px;
  cursor: pointer;
`;

const HeaderWrapper = styled.div`
  ${({ theme }) => theme.flexLayout.default};
  margin: 0 auto;
  max-width: 1440px;
  padding: 0 80px;
`;

const HeaderTemplate = styled.header`
  padding: 16px 0;
  border-bottom: 1px solid ${({ theme }) => theme.colors.black};
  transition: height 0.25s ease-out;
  height: ${(props) => (props.open ? '190px' : '80px')};
`;

const HeaderInnerTemplate = styled.div`
  width: 100%;
  height: 50px;
  ${({ theme }) => theme.flexLayout.default};
  justify-content: space-between;
  align-items: center;
`;

const CategoryTemplate = styled.div`
  ${({ theme }) => theme.flexLayout.default};
`;

const IconTemplate = styled.div`
  ${({ theme }) => theme.flexLayout.default};
  align-items: center;

  .icon {
    cursor: pointer;
    margin: 0 12px;
  }
`;

export default function Template() {
  const [subCategoryOpen, setSubCategoryOpen] = useState(false);

  const onMouseOver = () => {
    setSubCategoryOpen(true);
  };

  const onMouseOut = () => {
    setSubCategoryOpen(false);
  };

  const categoryList = CATEGORY_TEXTS.map((category, index) => {
    return <HeaderCategory open={subCategoryOpen} key={index} category={category}></HeaderCategory>;
  });

  const iconList = () => {
    return (
      <>
        <CartImage className="icon" />
        <PersonImage className="icon" />
        <SearchImage className="icon" />
      </>
    );
  };

  return (
    <HeaderTemplate open={subCategoryOpen}>
      <HeaderWrapper>
        <HeaderLogo>Ordering</HeaderLogo>
        <HeaderInnerTemplate>
          <CategoryTemplate onMouseOver={onMouseOver} onMouseOut={onMouseOut}>
            {categoryList}
          </CategoryTemplate>
          <IconTemplate>{iconList()}</IconTemplate>
        </HeaderInnerTemplate>
      </HeaderWrapper>
    </HeaderTemplate>
  );
}
