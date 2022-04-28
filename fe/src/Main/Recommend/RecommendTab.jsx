import { useState } from 'react';
import styled, { css } from 'styled-components';
import RecommendTabList from 'Main/Recommend/RecommendTabList';
import { RECOMMEND_ITEMS } from 'MockData/dummyData';

const RecommendTabBar = styled.ul`
  ${({ theme }) => theme.flexLayout.default};
  list-style: none;
`;

const RecommendTabBarItem = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  text-align: center;
  cursor: pointer;
  ${(props) =>
    props.focus === props.id &&
    css`
      border-bottom: 2px solid #1b1b1b;
    `}
  ${({ theme }) => theme.fontStyles.largeBold};
`;

const RecommendTab = () => {
  const [focus, setFocus] = useState(1);
  const onClick = (e) => {
    const id = e.currentTarget.id;
    setFocus(Number(id));
  };
  const tabBarList = RECOMMEND_ITEMS.map((item) => {
    return (
      <RecommendTabBarItem key={item.id} id={item.id} onClick={onClick} focus={focus}>
        <p>{item.title}</p>
      </RecommendTabBarItem>
    );
  });

  return (
    <>
      <RecommendTabBar>{tabBarList}</RecommendTabBar>
      <RecommendTabList items={RECOMMEND_ITEMS.find((obj) => obj.id === focus)}></RecommendTabList>
    </>
  );
};

export default RecommendTab;
