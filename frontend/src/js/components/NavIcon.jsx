import {searchIcon, userIcon, myCartIcon} from '../constants/iconPath.js';

function NavIcon() {
  const navIcons = [{searchIcon}, {userIcon}, {myCartIcon}];

  return navIcons
    .map(icon => Object.entries(icon))
    .map(([[name, src]]) => (
      <a href="#!" className={name} key={name}>
        <img className={name} src={src} alt={name}></img>
      </a>
    ));
}

export {NavIcon};
