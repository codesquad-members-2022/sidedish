const List = ({ menu, menuItem }) => {
  const menuli = menu.map((item, idx) => {
    const subMenu = item.menu ? List(item) : null;
    const keyValue = item.id ? item.id : idx;

    return (
      <li key={keyValue}>
        <a
          href="#!"
          ref={menuItem ? (item) => (menuItem.current[idx] = item) : null}>
          {item.title}
        </a>
        {subMenu}
      </li>
    );
  });

  return <ul>{menuli}</ul>;
};

export default List;
