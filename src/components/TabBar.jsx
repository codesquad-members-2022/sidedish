import React from "react";
import styled from "styled-components";
import TabButton from "./TabButton";

export default function TabBar() {
  return (
    <Wrap>
      <TabButton value="풍성한 고기 반찬" isSelected />
      <TabButton value="편리한 반찬 세트" />
      <TabButton value="맛있는 제철 요리" />
      <TabButton value="우리 아이 영양 반찬" />
    </Wrap>
  );
}

const Wrap = styled.div({
  display: "flex",
  gap: "32px",
});
