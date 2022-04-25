import React from 'react';
function Img({ data }) {
  return (
    <div>
      <img src={data[0]} alt={data[1]} />
      <Delivery delivery_type={data[2]} />
    </div>
  );
}

function Delivery({ delivery_type }) {
  if (!delivery_type) return;

  const DELIVERY_INFO = delivery_type.map((type, idx) => (
    <span key={idx}>{type}</span>
  ));

  return <div>{DELIVERY_INFO}</div>;
}

function Text({ data }) {
  return (
    <div>
      <h3>{data.title}</h3>
      <p>{data.description}</p>
      <Price price={data} />
      <Badge info={data.badge} />
    </div>
  );
}

function Price({ price }) {
  const SALE_PRICE = price.s_price ? <span>{price.s_price}</span> : null;

  return (
    <div>
      {SALE_PRICE}
      <span>{price.n_price}</span>
    </div>
  );
}

function Badge({ info }) {
  if (info) {
    const BADGES = info.map((item, idx) => <span key={idx}>{item}</span>);
    return <div>{BADGES}</div>;
  }
}

function Card({ cardData }) {
  const CARD_IMG_DATA = [cardData.image, cardData.alt, cardData.delivery_type];
  return (
    <div>
      <Img data={CARD_IMG_DATA} />
      <Text data={cardData} />
    </div>
  );
}

export default Card;
