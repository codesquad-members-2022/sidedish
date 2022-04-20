export function TapMenu(props) {
  if (!props.menus) {
    return ``;
  }
  return props.menus.map(menu => menu.title).map((menu, idx) => <li key={idx}>{menu}</li>);
}
