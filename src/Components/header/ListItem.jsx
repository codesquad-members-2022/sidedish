import React from 'react';

function ListItem(props) {
  const items = props;
  const Lists = items.map((item) => <li key={item}>{item}</li>);
  return <ul>{Lists}</ul>;
}

export default ListItem;
