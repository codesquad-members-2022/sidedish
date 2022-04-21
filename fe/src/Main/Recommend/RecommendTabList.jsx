import styled from 'styled-components';
import Card from '../Card';

const RecommendTabList = styled.div`
  display: flex;
  border-top: 1px solid ${({ theme }) => theme.colors.gray4};
  border-bottom: 1px solid ${({ theme }) => theme.colors.gray4};
  padding: 34px 0 56px 0;
`;

const ThemeTabList = ({ items }) => {
  const tabItems = items.data.map((item) => {
    return <Card key={item.id} item={item} imageSize={'large'}></Card>;
  });

  return <RecommendTabList>{tabItems}</RecommendTabList>;
};

export default ThemeTabList;
