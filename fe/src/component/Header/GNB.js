import React from "react";
import styled from "styled-components";
import CustomNav from "./CustomNav";
import Icons from "./Icons";

const HeaderTitle = styled.h1`
  font-size: 40px;
  font-weight: 900;
`;

const GNBWrapper = styled.div`
  display: flex;
  position: relative;
  border-bottom: 1px solid grey;
  padding: 0 40px;
  height: 70px;
  &:hover {
    height: 140px;
    .nav-List {
      display: block;
    }
  }
`;

const GNB = () => {
  //상수파일로 옮길 예정
  const GNBLists = [
    { navTitle: "든든한 메인 요리", navList: ["육류 요리", "해산물 요리"] },
    { navTitle: "뜨끈한 국물요리", navList: ["국/탕/찌개"] },
    {
      navTitle: "정갈한 밑반찬",
      navList: ["나물/무침", "조림/볶음", "절임/장아찌"],
    },
  ];

  return (
    <GNBWrapper>
      <HeaderTitle>Ordering</HeaderTitle>
      {GNBLists.map((navInfo, i) => (
        <CustomNav key={i} infor={navInfo} />
      ))}
      <Icons />
    </GNBWrapper>
  );
};

export default GNB;
