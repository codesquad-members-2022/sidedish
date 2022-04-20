import styled from 'styled-components';

const RecommendTabList = styled.div`
  display: flex;
  border-top: 1px solid ${({ theme }) => theme.colors.gray4};
  border-bottom: 1px solid ${({ theme }) => theme.colors.gray4};
  padding: 34px 0 56px 80px;
`;

const TabItem = styled.div`
  margin-right: 24px;
`;

const ItemImg = styled.img`
  background: ${({ theme }) => theme.colors.gray3};
  ${({ theme }) => theme.cardSize.large};
`;

const ItemInfo = styled.div`
  margin: 16px 0;
  .item__title {
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.mediumBold};
  }

  .item__desc {
    margin-bottom: 8px;
    color: ${({ theme }) => theme.colors.gray2};
    ${({ theme }) => theme.fontStyles.smallRegular};
  }

  .item__sale-price {
    margin-right: 8px;
    color: ${({ theme }) => theme.colors.black};
    ${({ theme }) => theme.fontStyles.mediumBold};
  }

  .item__normal-price {
    text-decoration-line: line-through;
    color: ${({ theme }) => theme.colors.gray3};
    ${({ theme }) => theme.fontStyles.smallRegular};
  }
`;

const ItemTag = styled.p`
  display: inline-block;
  padding: 6px 16px;
  border-radius: 999px;
  color: ${({ theme }) => theme.colors.white};
  background: ${(props) => {
    switch (props.tag) {
      case '런칭특가':
        return '#FF8E14';
      case '이벤트특가':
        return '#6DD028';
      default:
        return;
    }
  }};
  ${({ theme }) => theme.fontStyles.smallBold};
`;

const ThemeTabList = ({ items }) => {
  const tabItems = items.data.map((item) => {
    return (
      <TabItem key={item.id}>
        <ItemImg src={item.img}></ItemImg>
        <ItemInfo>
          <p className="item__title">{item.title}</p>
          <p className="item__desc">{item.desc}</p>
          {item.salePrice ? (
            <span className="item__sale-price">{Number(item.salePrice).toLocaleString()}원</span>
          ) : (
            ''
          )}
          <span className="item__normal-price">{Number(item.normalPrice).toLocaleString()}원</span>
        </ItemInfo>
        {item.tag ? <ItemTag tag={item.tag}>{item.tag}</ItemTag> : ''}
      </TabItem>
    );
  });

  return <RecommendTabList>{tabItems}</RecommendTabList>;
};

export default ThemeTabList;
