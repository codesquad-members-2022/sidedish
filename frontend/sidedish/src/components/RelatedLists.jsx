import { useState } from "react";
import styled from "styled-components";
import Blank from "../core/Blank";
import LeftArrowBtn from "../core/LeftArrowBtn";
import RightArrowBtn from "../core/RightArrowBtn";
import RelatedContents from "./RelatedContents";

const RelatedList = ({ relatedListState, setRelatedListState }) => {
  const data = [{}, {}];
  const [listNum, setListNum] = useState(1);
  const handleListNumDown = () => {
    if (listNum > 1) {
      setListNum(listNum - 1);
    }
  };
  const handleListNumUp = () => {
    if (listNum < data.length) {
      setListNum(listNum + 1);
    }
  };
  return (
    <>
      <RelatedListContainer>
        <RelatedListHeader>
          <RelatedTitle>함께하면 더욱 맛있는 식품</RelatedTitle>
          <Blank />
          <PageContainer>
            <LeftArrowBtn clickEventHandler={handleListNumDown} />
            <Pages>
              {listNum} / {data.length}
            </Pages>
            <RightArrowBtn clickEventHandler={handleListNumUp} />
          </PageContainer>
        </RelatedListHeader>
        <RelatedContents relatedListState={relatedListState} setRelatedListState={setRelatedListState}></RelatedContents>
      </RelatedListContainer>
    </>
  );
};

const RelatedListContainer = styled.div`
  box-sizing: border-box;
  height: 396px;
  padding: 48px;
`;

const RelatedListHeader = styled.div`
  display: flex;
`;

const RelatedTitle = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
`;

const PageContainer = styled.div`
  display: flex;
  align-items: center;
`;

const Pages = styled.div`
  display: flex;
  padding: 0 1rem;
  font-weight: 500;
  font-size: 14px;
  line-height: 24px;
`;

const RelatedListSlide = styled.div``;

export default RelatedList;
