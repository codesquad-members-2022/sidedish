import React, {useState} from 'react';
import {specialPromotionIcon} from '../constants/iconPath.js';
import {GoodsBlock} from './GoodsBlock.js';
import {goodsData} from '../data/goods.js';
import '../../css/SpecialPromotion.css';

function SpecialPromotion() {
  const [tabState, setTabState] = useState('풍부한 고기 반찬');

  const tabList = goodsData.map(element => (
    <li
      className={tabState === element.tab.title ? 'selected' : ''}
      key={element.id}
      onClick={() => {
        setTabState(element.tab.title);
      }}
    >
      {element.tab.title}
    </li>
  ));

  const bestSideDish = goodsData
    .filter(element => element.tab.title === tabState)[0]
    .tab.goods.map(element => (
      <li key={element.id}>
        <GoodsBlock
          goodsTumb={element.thumb}
          goodsName={element.name}
          goodsDescription={element.description}
          goodsPrice={element.price}
          goodsLabel={element.label}
        />
      </li>
    ));

  return (
    <div className="specialPromotion">
      <div className="innerSpecialPromotion">
        <h2 className="theme">
          <img className="specialPromotionIcon" src={specialPromotionIcon} alt="specialPromotionIcon"></img>
          <p>한 번 주문하면 두 번 반하는 반찬</p>
        </h2>
        <h4 className="tab">
          <ul className="tabList">{tabList}</ul>
        </h4>
        <div className="bestSideDishContainer">
          <ul className="bestSideDishList">{bestSideDish}</ul>
        </div>
      </div>
    </div>
  );
}

export {SpecialPromotion};
