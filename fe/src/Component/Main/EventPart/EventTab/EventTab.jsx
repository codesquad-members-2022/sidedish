import PropTypes from "prop-types";
import StyledEventTab from "Component/Main/EventPart/EventTab/EventTab.styled";

const tabClickHandler = ({ target: { id } }, selectedId, setSelectedId) => {
  const targetId = Number(id);
  if (targetId !== selectedId) setSelectedId(targetId);
};

const EventTab = ({ state: { categories, selectedId, setSelectedId } }) => {
  if (!categories) return null;

  const eventList = categories.map((category) => (
    <li key={category.id} id={category.id}>
      {category.name}
    </li>
  ));

  return (
    <StyledEventTab
      id={selectedId}
      onClick={(event) => tabClickHandler(event, selectedId, setSelectedId)}
    >
      {eventList}
    </StyledEventTab>
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
