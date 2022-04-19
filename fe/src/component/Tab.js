import List from "./List";
import "./Tab.css";
import React, { useState } from "react";

const Tab = () => {
  const arr = [
    { id: 1, title: "풍성한 고기반찬" },
    { id: 2, title: "편리한 반찬세트" },
    { id: 3, title: "맛있는 제철요리" },
    { id: 4, title: "우리 아이 영향 반찬" },
  ];
  const [isClicked, setIsClicked] = useState(false);
  const [clickedId, setClickedId] = useState(1);
  const onClickHandler = () => {
    setIsClicked(true);
  };
  return (
    <div>
      <ul className="tab-list">
        {arr.map((v) => {
          return (
            <List
              title={v.title}
              key={v.id}
              id={v.id}
              onClick={onClickHandler}
            />
          );
        })}
      </ul>
    </div>
  );
};

export default Tab;
