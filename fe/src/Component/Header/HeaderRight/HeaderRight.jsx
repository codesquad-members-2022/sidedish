import ButtonWrap from "Component/Header/HeaderRight/HeaderRight.styled";
import { icons } from "MockData/MockData";
import axios from "axios";

const Buttons = () => {
  const handleClick = async () => {
    const response = await axios.get(
      `https://github.com/login/oauth/authorize?client_id=52d17ef5577e55a18ca3&scope=user:email`
    );
    console.log(response.json());
    alert("HIHI");
  };
  return icons.map((icon) => (
    <button onClick={handleClick} type="button" key={icon.id}>
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
