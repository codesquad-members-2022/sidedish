import styled from 'styled-components';

const TabList = styled.div`
  display: flex;
  border-top: 1px solid #ebebeb;
  border-bottom: 1px solid #ebebeb;
  padding: 34px 0 56px 80px;
`;

const TabItem = styled.div`
  margin-right: 24px;
`;

const ItemImg = styled.img`
  width: 412px;
  height: 412px;
  background: lightgray;
`;

const ItemInfo = styled.div`
  .item__title {
    margin-bottom: 8px;
    font-size: 16px;
    line-height: 26px;
    color: #3f3f3f;
  }

  .item__desc {
    margin-bottom: 8px;
    font-weight: 400;
    font-size: 14px;
    line-height: 24px;
    color: #777777;
  }

  .item__sale-price {
    margin-right: 8px;
    margin-bottom: 8px;
    font-size: 16px;
    line-height: 26px;
    color: #1b1b1b;
  }

  .item__normal-price {
    font-weight: 400;
    font-size: 14px;
    line-height: 24px;
    text-decoration-line: line-through;
    color: #bcbcbc;
  }
`;

const ItemTag = styled.p`
  display: inline-block;
  padding: 6px 16px;
  font-size: 12px;
  line-height: 18px;
  color: #ffffff;
  border-radius: 24px;
  background: ${(props) => {
    switch (props.tag) {
      case '런칭특가':
        return '#ff8e14';
      case '이벤트특가':
        return '#6DD028';
      default:
        return;
    }
  }};
`;

const ThemeTabList = ({ items }) => {
  const tabItems = items.data.map((item) => {
    return (
      <TabItem key={item.id}>
        <ItemImg src={item.img}></ItemImg>
        <ItemInfo>
          <p className="item__title">{item.title}</p>
          <p className="item__desc">{item.desc}</p>
          {item.salePrice ? <span className="item__sale-price">{item.salePrice}원</span> : ''}
          <span className="item__normal-price">{item.normalPrice}원</span>
        </ItemInfo>
        {item.tag ? <ItemTag tag={item.tag}>{item.tag}</ItemTag> : ''}
      </TabItem>
    );
  });

  return <TabList>{tabItems}</TabList>;
};

export default ThemeTabList;
