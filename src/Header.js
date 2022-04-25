import React from 'react';
import styled from 'styled-components';

import Gnb from './components/Gnb';
import Menu from './components/Menu';
import { flexBetween } from './css/mixins';
import { slideBtn } from './css/variables';

const Header = () => {
  const gnbInfo = [
    { title: '든든한 메인요리', contents: ['육류요리', '해산물 요리'] },
    { title: '뜨끈한 국물요리', contents: ['국/탕/찌개'] },
    {
      title: '정갈한 밑반찬',
      contents: ['나물/무침', '조림/볶음', '절임/장아찌'],
    },
  ];

  const menuInfo = [
    { url: 'assets/search.png', alt: 'search' },
    { url: 'assets/user.png', alt: 'user' },
    { url: 'assets/basket.png', alt: 'basket' },
  ];

  return (
    <StyledHeader>
      <FlexBetween>
        <Title>Ordering</Title>
        <Gnb gnbInfo={gnbInfo} />
      </FlexBetween>

      <Menu menuInfo={menuInfo} />
    </StyledHeader>
  );
};

const StyledHeader = styled.header`
  ${flexBetween}
  border-bottom: 1px solid black;
`;

const FlexBetween = styled.div`
  ${flexBetween}
`;

const Title = styled.h2`
  margin: 18px 40px 20px ${slideBtn.size + slideBtn.margin}px;
  font-size: 40px;
  font-weight: 900;
`;

export default Header;
