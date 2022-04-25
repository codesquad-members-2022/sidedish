import { useEffect, useState } from "react";
import {
  StyledEventDesc,
  StyledEventLogo,
  StyledEventTitle,
  StyledEventPart,
} from "./EventPart.styled";
import eventCategoriesApi from "../../../Service/eventCategoriesApi";
import EventTab from "./EventTab/EventTab";
import EventContents from "./EventContents/EventContents";

const EventPart = () => {
  const [name, setName] = useState("");
  const [categories, setCategories] = useState([]);
  const [selectedId, setSelectedId] = useState(1);

  const fetchEventCategories = async () => {
    // const { eventName, eventCategories } =
    const data = await eventCategoriesApi.getEventCategories();

    setName(data.eventName);
    setCategories(data.eventCategories);
  };

  useEffect(() => {
    fetchEventCategories();
  }, []);

  return (
    <StyledEventPart>
      <StyledEventTitle>
        <StyledEventLogo>기획전</StyledEventLogo>
        <StyledEventDesc>{name}</StyledEventDesc>
      </StyledEventTitle>
      <EventTab state={{ categories, selectedId, setSelectedId }} />
      <EventContents selectedId={selectedId} />
    </StyledEventPart>
  );
};

export default EventPart;
