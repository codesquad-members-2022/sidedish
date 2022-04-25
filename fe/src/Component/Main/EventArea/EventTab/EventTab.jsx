import PropTypes from "prop-types";
import EventTabUl from "Component/Main/EventArea/EventTab/EventTab.styled";

const EventTab = ({ state: { categories, selectedId, setSelectedId } }) => {
  if (!categories) return null;

  const handleTabClick = ({ target: { id } }) => {
    const targetId = Number(id);
    if (targetId !== selectedId) setSelectedId(targetId);
  };

  const eventList = categories.map(({ id, name }) => (
    <li
      key={id}
      id={id}
      onClick={handleTabClick}
      onKeyUp={handleTabClick}
      role="tab"
    >
      {name}
    </li>
  ));

  return (
    <EventTabUl id={selectedId} role="tablist">
      {eventList}
    </EventTabUl>
  );
};

EventTab.propTypes = {
  state: PropTypes.objectOf(
    PropTypes.shape({
      categories: PropTypes.arrayOf(
        PropTypes.shape({
          id: PropTypes.number.isRequired,
          name: PropTypes.string.isRequired,
        })
      ),
      selectedId: PropTypes.number.isRequired,
      setSelectedId: PropTypes.func.isRequired,
    })
  ),
}.isRequired;

export default EventTab;
