import { useState } from 'react';
import styled from 'styled-components';
import HeaderCategory from './HeaderCategory';
import HeaderLogo from './HeaderLogo';
import HeaderIcon from './HeaderIcon';
import CartImage from '../image/cart.svg';
import PersonImage from '../image/person.svg';
import SearchImage from '../image/search.svg';

const HeaderTemplate = styled.header`
  display: flex;
  padding: 16px 80px;
  border-bottom: #1b1b1b 1px solid;
  transition: height 0.15s ease-out;
  height: ${(props) => (props.open ? '190px' : '83px')};
`;

const HeaderInnerTemplate = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
`;

const CategoryTemplate = styled.div`
  display: flex;
  height: 83px;
  transition: height 0.15s ease-out;
  &:hover {
    height: 190px;
    transition: height 0.25s ease-in;
  }
`;

const IconTemplate = styled.div`
  display: flex;
  align-items: center;
`;

export default function Template() {
  const [open, setOpen] = useState(false);
  const categoryTexts = [
    {
      main: '든든한메인요리',
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
    return <HeaderIcon key={index} path={path}></HeaderIcon>;
  });

  return (
    <HeaderTemplate open={open}>
      <HeaderLogo text={'Ordering'}></HeaderLogo>
      <HeaderInnerTemplate>
        <CategoryTemplate onMouseOver={onMouseOver} onMouseOut={onMouseOut}>
          {categoryList}
        </CategoryTemplate>
        <IconTemplate>{iconList}</IconTemplate>
      </HeaderInnerTemplate>
    </HeaderTemplate>
  );
}
