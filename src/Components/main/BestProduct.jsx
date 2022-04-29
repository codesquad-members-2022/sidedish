import styled from 'styled-components';
import { F_basicCenter, Inner } from '../../Assets/CommonStyle';
import Title from '../Title';
import List from '../List';
import { useEffect, useRef, useState } from 'react';

const BestProductContainer = styled.section`
  padding-top: 56px;
`;

const TitleBox = styled(Inner)`
  ${F_basicCenter}
`;

const TitleTag = styled.span`
  flex-shrink: 0;
  margin-right: 16px;
  padding: 0 16px;
  line-height: 42px;
  border: 2px solid ${({ theme }) => theme.Color.black};
  border-radius: 21px;
`;

const ProductBox = styled.div``;

const TabMenu = styled(Inner)`
  margin-top: 24px;

  > ul {
    ${F_basicCenter}

    li {
      margin-right: 32px;
      font-size: ${({ theme }) => theme.FontSize.Large};
      font-weight: ${({ theme }) => theme.FontWeight.Bold};
    }

    a {
      display: block;
      padding-bottom: 16px;
      border-bottom: 1px solid transparent;

      &.active {
        border-bottom: 1px solid ${({ theme }) => theme.Color.black};
      }
    }
  }
`;

export default function BestProduct({ info }) {
  const [activeMenu, setActiveMenu] = useState(info.menu[0].title);
  const TabMenus = useRef([]);

  const menuClickHandler = ({ target }) => {
    setActiveMenu(target.innerText);
  };

  useEffect(() => {
    TabMenus.current.forEach((menu) => {
      menu.innerText === activeMenu
        ? menu.classList.add('active')
        : menu.classList.remove('active');
    });
  }, [activeMenu]);

  return (
    <BestProductContainer>
      <TitleBox>
        <TitleTag>{info.titleTag}</TitleTag>
        <Title title={info.title} fontSize="Display" fontWeight="Display" />
      </TitleBox>
      <ProductBox>
        <TabMenu onClick={menuClickHandler}>
          <List menu={info.menu} menuItem={TabMenus} />
        </TabMenu>
      </ProductBox>
    </BestProductContainer>
  );
}
