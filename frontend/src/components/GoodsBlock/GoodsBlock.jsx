import React, {useState} from "react";
import {eventLabelIcon, launchingLabelIcon, deliveryIcon} from "constants";
import "./GoodsBlock.css";

function GoodsBlock({thumb, name, description, price, discountedRate, delivery, eventBadge}) {
  const [isHover, setIsHover] = useState(false);
  const percentage = 0.01;
  const discountedPrice = discountedRate ? price - discountedRate * percentage * price : price;

  return (
    <div className="goodsBlock">
      <div
        className="thumbContainer"
        onMouseOver={() => setIsHover(true)}
        onMouseOut={() => setIsHover(false)}
      >
        <img className="thumb" src={thumb} alt="thumb"></img>
        {isHover && delivery && <img className="deliveryIcon" src={deliveryIcon} alt="deliveryIcon"></img>}
      </div>
      <section className="info">
        <h4 className="name"> {name}</h4>
        <p className="description">{description}</p>
        <div className="price">
          <p className="discountedPrice">{Number(discountedPrice).toLocaleString("en") + "원"}</p>
          {discountedRate !== 0 && (
            <p className="regularPrice">{Number(price).toLocaleString("en") + "원"}</p>
          )}
        </div>
      </section>
      <div className="eventBadge">
        {eventBadge !== "none" && (
          <img
            className="eventBadge"
            src={eventBadge === "event" ? eventLabelIcon : launchingLabelIcon}
            alt="eventBadgeIcon"
          ></img>
        )}
      </div>
    </div>
  );
}

export {GoodsBlock};
