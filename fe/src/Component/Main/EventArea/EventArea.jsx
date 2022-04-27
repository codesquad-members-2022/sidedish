import { useEffect, useState } from "react";
import {
  EventWrapper,
  EventTitle,
} from "Component/Main/EventArea/EventArea.styled";
import eventCategoriesApi from "Service/eventCategoriesApi";

import EventTab from "Component/Main/EventArea/EventTab/EventTab";
import EventContents from "Component/Main/EventArea/EventContents/EventContents";

const EventArea = () => {
  const [name, setName] = useState("");
  const [categories, setCategories] = useState([]);
  const [selectedId, setSelectedId] = useState(1);

  const fetchEventCategories = async () => {
    const { eventName, eventCategories } =
      await eventCategoriesApi.getEventCategories();

    setName(eventName);
    setCategories(eventCategories);
  };

  useEffect(() => {
    fetchEventCategories();
  }, []);

  return (
    <EventWrapper>
      <EventTitle>
        <span className="logo">기획전</span>
        <h2>{name}</h2>
      </EventTitle>
      <EventTab state={{ categories, selectedId, setSelectedId }} />
      <EventContents selectedId={selectedId} />
    </EventWrapper>
  );
};

export default EventArea;
