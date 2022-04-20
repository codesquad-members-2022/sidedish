import React from "react";
import "../App.css";
import styled from "styled-components";
import Text from "../components/Text";
import MoreButton from "../components/MoreButton";
import Tag from "../components/Tag";
import TabButton from "../components/TabButton";

const TemplateTitle = styled.h3({
  "font-size": "20px",
});

function Template() {
  return (
    <div className="Template">
      <Text size="LARGE" color="BLACK" value="깐풍기" />
      <TemplateTitle>LOGOTYPE</TemplateTitle>
      <span>Basic</span>
      <TemplateTitle>TYPOGRAPHY</TemplateTitle>
      <span>Display</span>
      <TemplateTitle>COLOR</TemplateTitle>
      <TemplateTitle>ICONS</TemplateTitle>
      <MoreButton value="모든 카테고리 보기" />
      <Tag type="이벤트특가" />
      <Tag type="런칭특가" />
      <TabButton value="풍성한 고기 반찬" />
    </div>
  );
}

export default Template;
