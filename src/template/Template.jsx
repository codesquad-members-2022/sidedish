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
      <TemplateTitle>LOGOTYPE</TemplateTitle>
      <span>Basic</span>
      <TemplateTitle>TYPOGRAPHY</TemplateTitle>
      <Text size="SMALL" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text size="BASE" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text size="MEDIUM" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text
        size="LARGE"
        weight="MEDIUM"
        color="BLACK"
        value="맛있는 반찬을 배달해드립니다."
      />
      <br />
      <Text
        size="X_LARGE"
        weight="BOLD"
        color="BLACK"
        value="맛있는 반찬을 배달해드립니다."
      />
      <br />
      <TemplateTitle>COLORS</TemplateTitle>
      <Text size="BASE" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text size="BASE" color="GREY1" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text size="BASE" color="GREY2" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text size="BASE" color="GREY3" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text size="BASE" color="GREY4" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <Text
        size="BASE"
        color="OFF_WHITE"
        value="맛있는 반찬을 배달해드립니다."
      />
      <TemplateTitle>LABELS</TemplateTitle>
      <Tag type="이벤트특가" />
      <Tag type="런칭특가" />
      <TemplateTitle>BUTTONS</TemplateTitle>
      <MoreButton value="모든 카테고리 보기" />
      <TabButton value="풍성한 고기 반찬" />
    </div>
  );
}

export default Template;
