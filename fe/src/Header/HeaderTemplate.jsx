import { useState } from 'react';
import styled from 'styled-components';
import HeaderCategory from './HeaderCategory';
import CartImage from '../image/cart.svg';
import PersonImage from '../image/person.svg';
import SearchImage from '../image/search.svg';

const HeaderLogo = styled.div`
  ${({ theme }) => theme.fontStyles.logo};
  margin-right: 40px;
  cursor: pointer;
`;

const HeaderIcon = styled.img`
  width: 100%;
  cursor: pointer;
  margin: 0 12px;
`;

const HeaderTemplate = styled.header`
  display: flex;
  padding: 16px 80px;
  border-bottom: 1px solid ${({ theme }) => theme.colors.black};
  transition: height 0.25s ease-out;
  height: ${(props) => (props.open ? '190px' : '50px')};
`;

const HeaderInnerTemplate = styled.div`
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const CategoryTemplate = styled.div`
  display: flex;
`;

const IconTemplate = styled.div`
  display: flex;
`;

export default function Template() {
  const [open, setOpen] = useState(false);
  const categoryTexts = [
    {
      main: '든든한 메인요리',
      sub: ['육류 요리', '해산물 요리'],
    },
    { main: '뜨끈한 국물요리', sub: ['국/탕/찌개'] },
    { main: '정갈한 밑반찬', sub: ['나물/무침', '조림/볶음', '절임/장아찌'] },
  ];
  const iconsPaths = [CartImage, PersonImage, SearchImage];

  const onMouseOver = () => {
    setOpen(true);
  };

  const onMouseOut = () => {
    setOpen(false);
  };

  const categoryList = categoryTexts.map((category, index) => {
    return <HeaderCategory open={open} key={index} category={category}></HeaderCategory>;
  });

  const iconList = iconsPaths.map((path, index) => {
    return <HeaderIcon key={index} src={path} />;
  });

  return (
    <HeaderTemplate open={open}>
      <HeaderLogo>Ordering</HeaderLogo>
      <HeaderInnerTemplate>
        <CategoryTemplate onMouseOver={onMouseOver} onMouseOut={onMouseOut}>
          {categoryList}
        </CategoryTemplate>
        <IconTemplate>{iconList}</IconTemplate>
      </HeaderInnerTemplate>
    </HeaderTemplate>
  );
}
