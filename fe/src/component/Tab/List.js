import React from "react";

const List = ({ id, className, title, onSaveClickedID }) => {
  const onClickHandler = (event) => {
    onSaveClickedID(event.target.id);
  };
  return (
    <li id={id} key={id} className={className} onClick={onClickHandler}>
      {title}
    </li>
  );
};

export default List;
