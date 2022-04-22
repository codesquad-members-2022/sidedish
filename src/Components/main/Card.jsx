import React from 'react';

function Img({ image, alt, delivery_type }) {
  return (
    <div>
      <img src={image} alt={alt} />
      <Delivery delivery_type={delivery_type} />
    </div>
  );
}

function Delivery({ delivery_type }) {
  if (!delivery_type) return;

  const DELIVERY_INFO = delivery_type.map((type) => <span>{type}</span>);

  return <div>{DELIVERY_INFO};</div>;
}

function Text(props) {
  return (
    <div>
      <h3>title</h3>
      <p>내용</p>
      <Price props={props} />
      <Badge props={props} />
    </div>
  );
}

function Price({ n_price, s_price }) {
  const SALE_PRICE = s_price ? <span>{s_price}</span> : null;

  return (
    <div>
      {SALE_PRICE};<span>{n_price}</span>;
    </div>
  );
}

function Badge(props) {
  const BADGES = props.badge.map((item) => <span>{item}</span>);

  return <div>{BADGES}</div>;
}

function Card(props) {
  return (
    <div>
      <Img props={props} />
      <Text props={props} />
    </div>
  );
}

export default Card;
