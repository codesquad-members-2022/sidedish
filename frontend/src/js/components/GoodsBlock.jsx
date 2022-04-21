import React from 'react';
import {eventLabelIcon, launchingLabelIcon} from '../constants/iconPath.js';
import '../../css/GoodsBlock.css';

function GoodsBlock({thumb, name, description, price, label}) {
  const [discountedPrice, regularPrice] = price.map(element => element.price);
  const [eventLabel, launchingLabel] = label.map(element => element.exist);
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
      <img className="thumb" src={thumb} alt="thumb"></img>
      <section className="info">
        <h4 className="name"> {name}</h4>
        <p className="description">{description}</p>
        <div className="price">
          <p className="discountedPrice">{Number(discountedPrice).toLocaleString('en') + '원'}</p>
          <p className="regularPrice">{Number(regularPrice).toLocaleString('en') + '원'}</p>
        </div>
      </section>
      <div className="label">
        {eventLabelElement}
        {launchingLabelElement}
      </div>
    </div>
  );
}

export {GoodsBlock};
