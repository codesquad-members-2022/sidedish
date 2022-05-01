import ButtonWrap from "Component/Header/HeaderRight/HeaderRight.styled";
import loginApi from "Service/loginApi";
import { icons, githubIcon } from "MockData/MockData";
import { useEffect, useState } from "react";

const loginLink =
  "https://github.com/login/oauth/authorize?client_id=52d17ef5577e55a18ca3&scope=user:email";

const Buttons = () => {
  const [isLogin, setIsLogin] = useState(false);

  const handleDblClickLogout = () => {
    setIsLogin(!isLogin);
  };

  const fetchLoginInfo = async () => {
    const {
      data: { status },
    } = await loginApi.getLoginInfo();

    setIsLogin(status === "OK");
  };

  useEffect(() => {
    fetchLoginInfo();
  }, []);

  const getIcon = ({ login, svg }) => {
    const loginAnchorEl = <a href={loginLink}>{svg}</a>;
    const logoutDivEl = (
      <div onDoubleClick={handleDblClickLogout}>{githubIcon.svg}</div>
    );

    if (!login) return svg;
    return !isLogin ? loginAnchorEl : logoutDivEl;
  };

  const buttons = icons.map((icon) => (
    <button type="button" key={icon.id}>
      {getIcon(icon)}
    </button>
  ));

  return buttons;
};

const HeaderRight = () => {
  return (
    <ButtonWrap>
      <Buttons />
    </ButtonWrap>
  );
};

export default HeaderRight;
