import React, {useState} from 'react';
import {bestGoodsData} from 'data';
import {specialPromotionIcon} from 'constants';
import {TabList, SideDish} from 'components';
import './SpecialPromotion.css';

function SpecialPromotion() {
  const [tabState, setTabState] = useState({category: '풍부한 고기 반찬'});

  return (
    <div className="specialPromotion">
      <h2 className="theme">
        <img className="specialPromotionIcon" src={specialPromotionIcon} alt="specialPromotionIcon"></img>
        <p>한 번 주문하면 두 번 반하는 반찬</p>
      </h2>
      <h4 className="tab">
        <ul className="tabList">
          <TabList tabState={tabState.category} setTabState={setTabState} />
        </ul>
      </h4>
      <div className="bestSideDishContainer">
        <ul className="bestSideDishList">
          <SideDish type="best" data={bestGoodsData} tabState={tabState.category} />
        </ul>
      </div>
    </div>
  );
}

export {SpecialPromotion};
