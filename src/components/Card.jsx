import React from "react";
import styled from "styled-components";
import Tag from "./Tag";
import Text from "./Text";

export default function Card(props) {
  const { size, imageURL, title, desc, curPrice, prevPrice, tags } = props;
  return (
    <Wrap size={size}>
      <img src={imageURL} alt="반찬" />
      {getSpaceBySize()}
      {getTitle()}
      {getDescription()}
      <Prices>
        <Text size="MEDIUM" weight="MEDIUM" value={curPrice} />
        <Text
          size="BASE"
          weight="REGULAR"
          color="GREY3"
          value={prevPrice}
          line
        />
      </Prices>
      <Tags>{getTags()}</Tags>
    </Wrap>
  );

  function getTitle() {
    if (size === "SMALL") {
      return <Text value={title} />;
    }
    return <Text size="MEDIUM" weight="MEDIUM" value={title} />;
  }

  function getSpaceBySize() {
    if (size === "SMALL") {
      return "";
    }
    return <Space />;
  }

  function getDescription() {
    if (size === "SMALL") {
      return "";
    }
    return <Text size="BASE" weight="REGULAR" color="GREY2" value={desc} />;
  }

  function getTags() {
    if (size === "SMALL") {
      return "";
    }
    return tags.map((tag) => <Tag type={tag} />);
  }
}

Card.defaultProps = {
  size: "MEDIUM",
};

const Wrap = styled.div({
  width: (props) => getWidthBySize(props.size),
  display: "flex",
  flexDirection: "column",
  gap: "8px",
});

const Prices = styled.div({
  display: "flex",
  gap: "8px",
  alignItems: "center",
});

const Tags = styled.div({
  display: "flex",
  gap: "8px",
  marginTop: "8px",
});

const Space = styled.div({});

function getWidthBySize(size) {
  if (size === "LARGE") {
    return "411px";
  }
  if (size === "MEDIUM") {
    return "302px";
  }
  if (size === "SMALL") {
    return "160px";
  }
  throw new Error("카드의 사이즈가 올바르지 않습니다.");
}
