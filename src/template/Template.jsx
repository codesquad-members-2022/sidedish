import React from "react";
import styled from "styled-components";
import Text from "../components/Text";
import Button from "../components/Button";
import MoreButton from "../components/MoreButton";
import Tag from "../components/Tag";
import TabButton from "../components/TabButton";
import TabBar from "../components/TabBar";
import Card from "../components/Card";

export default function Template() {
  return (
    <div className="Template">
      <TemplateTitle>LOGOTYPE</TemplateTitle>
      <TemplateSubTitle>Basic</TemplateSubTitle>
      <TemplateTitle>TYPOGRAPHY</TemplateTitle>
      <TemplateSubTitle>Small Regular</TemplateSubTitle>
      <Text size="SMALL" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Base Regular</TemplateSubTitle>
      <Text size="BASE" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Medium Regular</TemplateSubTitle>
      <Text size="MEDIUM" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Large Medium</TemplateSubTitle>
      <Text
        size="LARGE"
        weight="MEDIUM"
        color="BLACK"
        value="맛있는 반찬을 배달해드립니다."
      />
      <TemplateSubTitle>X_LARGE Medium</TemplateSubTitle>
      <Text
        size="X_LARGE"
        weight="MEDIUM"
        color="BLACK"
        value="맛있는 반찬을 배달해드립니다."
      />
      <TemplateSubTitle>TITLE_3</TemplateSubTitle>
      <Text
        size="TITLE_3"
        weight="BOLD"
        color="BLACK"
        value="맛있는 반찬을 배달해드립니다."
      />
      <TemplateTitle>COLORS</TemplateTitle>
      <TemplateSubTitle>Black</TemplateSubTitle>
      <Text size="BASE" color="BLACK" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray1</TemplateSubTitle>
      <Text size="BASE" color="GREY1" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray2</TemplateSubTitle>
      <Text size="BASE" color="GREY2" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray3</TemplateSubTitle>
      <Text size="BASE" color="GREY3" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Gray4</TemplateSubTitle>
      <Text size="BASE" color="GREY4" value="맛있는 반찬을 배달해드립니다." />
      <br />
      <TemplateSubTitle>Off-White</TemplateSubTitle>
      <Text
        size="BASE"
        color="OFF_WHITE"
        value="맛있는 반찬을 배달해드립니다."
      />
      <TemplateTitle>LABELS</TemplateTitle>
      <TemplateSubTitle>Event</TemplateSubTitle>
      <Tag type="이벤트특가" />
      <TemplateSubTitle>New</TemplateSubTitle>
      <Tag type="런칭특가" />
      <TemplateTitle>BUTTONS</TemplateTitle>
      <TemplateSubTitle>Button</TemplateSubTitle>
      <Button value="주문하기" />
      <Button value="주문하기" disabled="true" />
      <TemplateSubTitle>More Button</TemplateSubTitle>
      <MoreButton value="모든 카테고리 보기" />
      <TemplateSubTitle>Tab button</TemplateSubTitle>
      <TabButton value="Text" />
      <TabButton isSelected value="Text" />
      <TemplateSubTitle>Tab Bar</TemplateSubTitle>
      <TabBar
        tabNames={[
          "훌륭한 고기 반찬",
          "편리한 반찬 세트",
          "맛있는 제철 요리",
          "우리 아이 영양 반찬",
        ]}
      />
      <TemplateSubTitle>Card</TemplateSubTitle>
      <Row>
        <Card
          size="LARGE"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={["이벤트특가", "런칭특가"]}
        />
        <Card
          size="MEDIUM"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={["이벤트특가", "런칭특가"]}
        />
        <Card
          size="SMALL"
          imageURL="http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg"
          title="오리 주물럭_반조리"
          desc="감질맛 나는 매콤한 양념"
          curPrice="12,640원"
          prevPrice="15,800원"
          tags={["이벤트특가", "런칭특가"]}
        />
      </Row>
    </div>
  );
}

const TemplateTitle = styled.h3({
  margin: "20px 0 -5px",
  "font-size": "30px",
  "font-family": "Outfit",
});

const TemplateSubTitle = styled.span({
  margin: "15px 0 5px",
  display: "block",
  color: "#777",
});

const Row = styled.div({
  display: "flex",
  gap: "30px",
});
