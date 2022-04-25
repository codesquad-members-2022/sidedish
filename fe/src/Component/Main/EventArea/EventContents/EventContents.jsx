import PropTypes from "prop-types";
import styled from "styled-components";
import { useEffect, useState } from "react";
import EventCardPrice from "Component/Main/EventArea/EventContents/EventCardPrice";
import eventCategoriesApi from "Service/eventCategoriesApi";

const StyledEventCards = styled.ul`
  border-top: solid #ebebeb 1px;
  border-bottom: solid #ebebeb 1px;
  padding-top: 34px;
  padding-bottom: 56px;
  font-family: "Noto Sans KR";
  font-size: 16px;
  font-weight: 500;
  line-height: 26px;
  display: flex;

  img {
    width: 400px;
  }

  .name,
  .discountType {
    margin-top: 16px;
  }

  .desc,
  .price {
    margin-top: 8px;
  }

  .desc {
    font-size: 14px;
    font-weight: 400;
    line-height: 24px;
    color: #777777;
  }

  .originPrice {
    color: #bcbcbc;
    text-decoration: line-through;
    font-size: 14px;
    line-height: 24px;
    margin-left: 8px;
  }

  .discountType {
    color: #ffffff;
    padding: 6px 16px;
    border-radius: 100px;
    font-size: 12px;
    line-height: 18px;
    display: inline-block;
    background-color: #ff8e14;
  }
`;

const EventContents = ({ selectedId }) => {
  const [sideDishes, setSideDishes] = useState([]);

  const fetchCurCategorySideDishes = async (eventCategoryId) => {
    const responseData = await eventCategoriesApi.getSideDishes(
      eventCategoryId
    );
    setSideDishes(responseData.sideDishes);
  };

  useEffect(() => {
    fetchCurCategorySideDishes(selectedId);
  }, [selectedId]);

  // if (!sideDishes.length) return null;

  const eventCards = sideDishes.map((sideDish) => {
    const {
      id,
      name,
      description,
      // dawnDeliveryFlag,
      // wholeNationDeliveryFlag,
      price,
      discountType,
      discountRate,
      saveFileName,
    } = sideDish;

    return (
      <li key={id}>
        <img src={saveFileName} alt={name} />
        <div className="name">{name}</div>
        <div className="desc">{description}</div>
        <EventCardPrice
          price={price}
          discountType={discountType}
          discountRate={discountRate}
        />
      </li>
    );
  });

  return <StyledEventCards>{eventCards}</StyledEventCards>;
};

EventContents.propTypes = {
  selectedId: PropTypes.number.isRequired,
}.isRequired;

export default EventContents;
