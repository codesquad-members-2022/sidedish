function NavIcon({name, src}) {
  return (
    <a href="#!" className={name}>
      <img className={name} src={src} alt={name}></img>
    </a>
  );
}

export {NavIcon};
