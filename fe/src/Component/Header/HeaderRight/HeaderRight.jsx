import ButtonWrap from "./HeaderRight.styled";
import { icons } from "../../../MockData/MockData";

const Buttons = () => {
  return icons.map((icon) => (
    <button type="button" key={icon.id}>
      {icon.svg}
    </button>
  ));
};

const HeaderRight = () => {
  return (
    <ButtonWrap>
      <Buttons />
    </ButtonWrap>
  );
};

export default HeaderRight;
