import { Button } from "./Exhibition.style";

const TapButton = ({ title, isActive }) => {
  return <Button className={isActive ? "active" : ""}>{title}</Button>;
};

export default TapButton;
