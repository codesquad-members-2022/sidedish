import React, {useState, useEffect} from "react";
import {fetchData} from "utils/utils";
import {serverURL} from "constants/urlPath";
import {
  StyledSpecialPromotion,
  SpecialPromotionIcon,
  SpecialPromotionTitle,
  Tab,
  BestSideDishContainer,
  BestSideDishList,
} from "./SpecialPromotion.styled";
import {eventCategory} from "data";
import {specialPromotionIcon} from "constants";
import {TabList, GoodsBlock} from "components";

function SpecialPromotion() {
  const [tabState, setTabState] = useState({category: eventCategory[0].subTitle});
  const [goodsData, setGoodsData] = useState([]);

  const fetchAPI = async title => {
    const data = await fetchData(`${serverURL}/${title}`);
    setGoodsData(data);
  };

  useEffect(() => {
    const title = eventCategory.filter(category => category.subTitle === tabState.category)[0].title;
    fetchAPI(title);
  }, [tabState]);

  return (
    <StyledSpecialPromotion>
      <SpecialPromotionTitle>
        <SpecialPromotionIcon src={specialPromotionIcon} alt="specialPromotionIcon"></SpecialPromotionIcon>
        <p>한 번 주문하면 두 번 반하는 반찬</p>
      </SpecialPromotionTitle>
      <Tab>
        <ul className="tabList">
          {eventCategory.map(({subTitle}, index) => (
            <TabList key={index} title={subTitle} tabState={tabState} setTabState={setTabState} />
          ))}
        </ul>
      </Tab>
      <BestSideDishContainer>
        <BestSideDishList>
          {goodsData.map(
            ({id, image, productName, description, price, eventBadge, early_delivery, discountedRate}) => (
              <li key={id}>
                <GoodsBlock
                  thumb={image}
                  name={productName}
                  description={description}
                  price={price}
                  eventBadge={eventBadge}
                  discountedRate={discountedRate}
                  delivery={early_delivery}
                />
              </li>
            ),
          )}
        </BestSideDishList>
      </BestSideDishContainer>
    </StyledSpecialPromotion>
  );
}

export {SpecialPromotion};
