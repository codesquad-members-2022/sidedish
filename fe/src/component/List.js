import React, { useState } from "react";

const List = (props) => {
  const onClickHandler = (event) => {
    props.onSaveClickedID(event.target.id);
  };
  //   console.log(props);
  return (
    <li
      id={props.id}
      key={props.id}
      className={props.className}
      onClick={onClickHandler}
    >
      {props.title}
    </li>
  );
};

export default List;
