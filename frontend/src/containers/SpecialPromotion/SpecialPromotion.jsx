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

function SpecialPromotion({openModal}) {
  const [tabState, setTabState] = useState({category: eventCategory[0].subTitle});
  const [goodsData, setGoodsData] = useState([]);

  const fetchAPI = async title => {
    const data = await fetchData(`${serverURL}/product/event?category=${title}`);
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
            ({
              id,
              imageThumbnail,
              productName,
              description,
              price,
              eventBadge,
              earlyDelivery,
              discountRate,
            }) => (
              <li
                key={id}
                onClick={() => {
                  openModal(id);
                }}
              >
                <GoodsBlock
                  thumb={imageThumbnail}
                  name={productName}
                  description={description}
                  price={price}
                  eventBadge={eventBadge}
                  discountRate={discountRate}
                  delivery={earlyDelivery}
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
