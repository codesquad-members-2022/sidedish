import { useEffect, useState } from "react";
import styled, { css } from "styled-components";
import PropTypes from "prop-types";
import eventCategoriesApi from "Service/eventCategoriesApi";
import Card from "Component/Card/Card";

const EventCardsWrapper = styled.div`
  ${({ theme: { colors } }) =>
    css`
      border-top: solid 1px ${colors.grey4};
      border-bottom: solid 1px ${colors.grey4};
    `}
`;

const EventCardsUl = styled.ul`
  ${({ theme: { center } }) => center}

  padding-top: 34px;
  padding-bottom: 56px;
  display: flex;

  > li:not(:last-child) {
    margin-right: 24px;
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

  const eventCards = sideDishes.map((sideDish) => {
    return <Card key={sideDish.id} props={sideDish} type="large" />;
  });

  useEffect(() => {
    fetchCurCategorySideDishes(selectedId);
  }, [selectedId]);

  return (
    <EventCardsWrapper>
      <EventCardsUl>{eventCards}</EventCardsUl>
    </EventCardsWrapper>
  );
};

EventContents.propTypes = {
  selectedId: PropTypes.number.isRequired,
}.isRequired;

export default EventContents;
