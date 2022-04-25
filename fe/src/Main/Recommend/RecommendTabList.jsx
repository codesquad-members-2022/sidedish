import styled from 'styled-components';
import Card from 'Main/Card';

const RecommendTabList = styled.div`
  ${({ theme }) => theme.flexLayout.default};
  border-top: 1px solid ${({ theme }) => theme.colors.gray4};
  border-bottom: 1px solid ${({ theme }) => theme.colors.gray4};
  padding: 34px 0 56px 0;
`;

const ThemeTabList = ({ items }) => {
  const tabItems = items.dishes.map((item) => {
    return <Card key={item.id} item={item} imageSize={'large'}></Card>;
  });

  return <RecommendTabList>{tabItems}</RecommendTabList>;
};

export default ThemeTabList;
