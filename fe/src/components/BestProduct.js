import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { applyFlex } from '../helper/utils';
import { TapList } from './BestProduct/TapList.js';
import { TapMenu } from './BestProduct/TapMenu.js';

const CategoryBadge = styled.div`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  padding: 8px 8px;
  width: 76px;
  height: 42px;
  background: #f8f7f7;
  text-align: center;
  border: 2px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;
`;

const TitleWrapper = styled.div`
  ${props => applyFlex(props)}
`;

const StyledBestProduct = styled.div`
  margin-top: 56px;
`;

const BestProductHeader = styled.div`
  padding: 0 80px;
  border-bottom: 1px solid #ebebeb;
`;

const Title = styled.h1`
  margin-left: 16px;
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 58px;
`;

const TapBar = styled.ul`
  ${props => applyFlex(props)};
  margin-top: 24px;
  li {
    margin-right: 32px;
    padding-bottom: 17px;
    font-family: 'Noto Sans KR';
    font-style: normal;
    font-weight: 500;
    font-size: 20px;
    line-height: 30px;

    &:hover {
      border-bottom: 1px solid black;
    }
  }
`;

export function BestProduct() {
  const [bestProductTap, setBestProductTap] = useState(null);
  const [tapList, setTapList] = useState(null);
  useEffect(() => {
    const tapMenus = [
      { title: '풍성한 고기반찬', id: 0 },
      { title: '편리한 반찬 세트', id: 1 },
      { title: '맛있는 제철 요리', id: 2 },
      { title: '우리 아이 영양 반찬', id: 3 },
    ];
    setBestProductTap(tapMenus);
  }, []);

  useEffect(() => {
    if (!bestProductTap) return;
    const targetId = bestProductTap[0].id;
    // http://rumka.com/bestproduct/id
    const duck = {
      src: '/img' + '/' + targetId + '/오리주물럭.png',
      title: '오리주물럭',
      content: '감칠맛 나는 매콤한 양념',
      price: '15,800원',
      cutPrice: '12,640원',
      discount: ['런칭특가'],
    };
    const cow = {
      src: '/img' + '/' + targetId + '/소갈비찜.png',
      title: '소갈비찜',
      content: '촉촉하게 벤 양념이 일품',
      price: '28,900원',
      cutPrice: '26,010원',
      discount: ['이벤트특가'],
    };
    const pig = {
      src: '/img' + '/' + targetId + '/쭈꾸 한돈 제육볶음.png',
      title: '쭈꾸미 한돈 제육볶음_반조리',
      content: '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품',
      price: '16,900원',
      cutPrice: '16,900원',
      discount: null,
    };
    const srcArr = [duck, cow, pig];
    setTapList(srcArr);
  }, [bestProductTap]);

  return (
    <StyledBestProduct>
      <BestProductHeader>
        <TitleWrapper flex align="center">
          <CategoryBadge>기획전</CategoryBadge>
          <Title>한 번 주문하면 두 번 반하는 반찬</Title>
        </TitleWrapper>

        <TapBar flex>
          <TapMenu menus={bestProductTap}></TapMenu>
        </TapBar>
      </BestProductHeader>
      <TapList tapList={tapList}></TapList>
    </StyledBestProduct>
  );
}
