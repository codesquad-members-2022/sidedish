import React, {useState} from 'react';
import {specialPromotionIcon} from '../constants/iconPath.js';
import {BestSideDish} from './BestSideDish.jsx';
import {TabList} from './TabList.jsx';
import '../../css/SpecialPromotion.css';

function SpecialPromotion() {
  const [tabState, setTabState] = useState({category: '풍부한 고기 반찬'});

  return (
    <div className="specialPromotion">
      <div className="innerSpecialPromotion">
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
            <BestSideDish tabState={tabState.category} />
          </ul>
        </div>
      </div>
    </div>
  );
}

export {SpecialPromotion};
