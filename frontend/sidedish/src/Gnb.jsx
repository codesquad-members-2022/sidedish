import styled from "styled-components";
import MenuTypeList from "./MenuTypeList";

const GnbContainer = styled.div`
  display: flex;
  padding: 12px 16px;
`;

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
  const menuTypeList = data.map(({ menuTypeTitle, menuTypes }, index) => {
    return <MenuTypeList menuTypeTitle={menuTypeTitle} menuTypes={menuTypes} key={index} />;
  });

  return <GnbContainer>{menuTypeList}</GnbContainer>;
};

export default Gnb;
