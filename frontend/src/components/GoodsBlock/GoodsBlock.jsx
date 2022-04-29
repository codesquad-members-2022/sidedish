import React, {useState} from "react";
import {eventLabelIcon, launchingLabelIcon, deliveryIcon} from "constants";
import {numberToBoolean} from "utils";
import "./GoodsBlock.css";

function GoodsBlock({thumb, name, description, price, discountRate, delivery, eventBadge}) {
  const [isHover, setIsHover] = useState(false);
  const percentage = 0.01;
  const discountPrice = price * (1 - discountRate * percentage);

  return (
    <div className="goodsBlock">
      <div
        className="thumbContainer"
        onMouseOver={() => setIsHover(true)}
        onMouseOut={() => setIsHover(false)}
      >
        <img className="thumb" src={thumb} alt="thumb"></img>
        {isHover && numberToBoolean(Number(delivery)) && (
          <img className="deliveryIcon" src={deliveryIcon} alt="deliveryIcon"></img>
        )}
      </div>
      <section className="info">
        <h4 className="name"> {name}</h4>
        <p className="description">{description}</p>
        <div className="price">
          <p className="discountedPrice">{Number(discountPrice).toLocaleString("en") + "원"}</p>
          {discountRate !== 0 && <p className="regularPrice">{Number(price).toLocaleString("en") + "원"}</p>}
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
