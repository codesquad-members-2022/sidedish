import ButtonWrap from "Component/Header/HeaderRight/HeaderRight.styled";
import { icons } from "MockData/MockData";

const Buttons = () => {
  return icons.map((icon) => (
    <button
      href="https://github.com/login/oauth/authorize?client_id=52d17ef5577e55a18ca3&scope=user:email"
      type="button"
      key={icon.id}
    >
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
