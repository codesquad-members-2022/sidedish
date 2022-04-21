const List = ({ menu }) => {
  const menuli = menu.map((item) => {
    const subMenu = item.menu ? List(item) : null;

    return (
      <li key={item.id}>
        <a href="#!">{item.title}</a>
        {subMenu}
      </li>
    );
  });

  return <ul>{menuli}</ul>;
};

export default List;
