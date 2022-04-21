import React from 'react';
import {eventLabelIcon, launchingLabelIcon} from '../constants/iconPath.js';
import '../../css/GoodsBlock.css';

function GoodsBlock(props) {
  const [discountedPrice, regularPrice] = props.goodsPrice.map(element => element.price);
  const [eventLabel, launchingLabel] = props.goodsLabel.map(element => element.exist);
  const eventLabelElement = eventLabel ? (
    <img className="eventLabel" src={eventLabelIcon} alt="eventLabelIcon"></img>
  ) : (
    <></>
  );
  const launchingLabelElement = launchingLabel ? (
    <img className="launchingLabel" src={launchingLabelIcon} alt="launchingLabelIcon"></img>
  ) : (
    <></>
  );

  return (
    <div className="goodsBlock">
      <img className="goodsThumb" src={props.goodsTumb} alt="goodsThumb"></img>
      <section className="goodsInfo">
        <h4 className="goodsName"> {props.goodsName}</h4>
        <p className="goodsDescription">{props.goodsDescription}</p>
        <div className="goodsPrice">
          <p className="discountedPrice">{Number(discountedPrice).toLocaleString('en') + '원'}</p>
          <p className="regularPrice">{Number(regularPrice).toLocaleString('en') + '원'}</p>
        </div>
      </section>
      <div className="goodsLabel">
        {eventLabelElement}
        {launchingLabelElement}
      </div>
    </div>
  );
}

export {GoodsBlock};
