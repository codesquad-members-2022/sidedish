import List from "./List";
import "./Tab.css";
import React, { useState } from "react";

const Tab = () => {
  const [infor, setInfor] = useState([
    { id: 1, title: "풍성한 고기반찬", active: true },
    { id: 2, title: "편리한 반찬세트", active: false },
    { id: 3, title: "맛있는 제철요리", active: false },
    { id: 4, title: "우리 아이 영향 반찬", active: false },
  ]);

  const [activeTab, setActiveTab] = useState(1);

  // [0] , [1]
  const onChangeInfor = (clickedId) => {
    // const newInfor = infor.map((v) => {
    //   return Object.assign(v, { active: false });
    // });
    // const newnew = newInfor.map((v) =>
    //   v.id.toString() === clickedId
    //     ? (v = Object.assign(v, { active: true }))
    //     : v
    // );
    // setInfor(newnew);
    setActiveTab(clickedId);
  };

  return (
    <div>
      <ul className="tab-list">
        {infor.map((v) => {
          return (
            <List
              title={v.title}
              key={v.id}
              id={v.id}
              className={v.id.toString() === activeTab ? "active" : ""}
              onSaveClickedID={onChangeInfor}
            />
          );
        })}
      </ul>
    </div>
  );
};

export default Tab;
