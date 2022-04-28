import React, {useState, useRef} from "react";
import {SideDishContentsList} from "components";
import {StyledSideDishContents, ShowAllCategoryButton} from "./SideDishContents.styled";

function SideDishContents({openModal}) {
  const [showAllCategory, setShowAllCategory] = useState(false);
  const [buttonText, setButtonText] = useState("모든 카테고리 보기");
  const button = useRef();

  const handleShowAllCategory = () => {
    setShowAllCategory(!showAllCategory);
    setButtonText(showAllCategory ? "모든 카테고리 보기" : "카테고리 닫기");
  };

  return (
    <StyledSideDishContents>
      <ul>
        <SideDishContentsList showAllCategory={showAllCategory} openModal={openModal} />
        <ShowAllCategoryButton
          onClick={() => handleShowAllCategory()}
          showAllCategory={showAllCategory}
          ref={button}
        >
          <p>{buttonText}</p>
        </ShowAllCategoryButton>
      </ul>
    </StyledSideDishContents>
  );
}

export {SideDishContents};
