import { useState } from "react";
import styled from "styled-components";
import MenuTypeList from "./MenuTypeList";

const Gnb = () => {
  const data = [
    {
      menuTypeTitle: "든든한 메인요리",
      menuTypes: ["육류 요리", "해산물 요리"],
    },
    {
      menuTypeTitle: "뜨끈한 국물요리",
      menuTypes: ["국/탕/찌개"],
    },
    {
      menuTypeTitle: "정갈한 밑반찬",
      menuTypes: ["나물/무침", "조림/볶음", "절임/장아찌"],
    },
  ];
  const [menuHideState, setMenuHideState] = useState(true);
  const handleMenuHidden = () => {
    setMenuHideState(() => !menuHideState);
  };

  const menuTypeList = data.map(({ menuTypeTitle, menuTypes }, ind) => {
    return <MenuTypeList {...{ menuTypeTitle, menuTypes, menuHideState }} key={ind} />;
  });

  return (
    <GnbContainer onMouseLeave={handleMenuHidden} onMouseEnter={handleMenuHidden}>
      {menuTypeList}
    </GnbContainer>
  );
};

const GnbContainer = styled.div`
  display: flex;
  padding: 12px 16px;
`;

export default Gnb;
