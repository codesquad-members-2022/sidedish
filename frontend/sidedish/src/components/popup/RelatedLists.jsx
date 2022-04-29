import { useEffect, useState } from "react";
import styled from "styled-components";
import { URL } from "../../consts/constants";
import Blank from "../../core/Blank";
import LeftArrowBtn from "../../core/LeftArrowBtn";
import RightArrowBtn from "../../core/RightArrowBtn";
import fetchData from "../../util/fetchData";
import RelatedContents from "./RelatedContents";

const RelatedList = () => {
  const [listNum, setListNum] = useState(1);
  const [totalNum, setTotalNum] = useState();
  const [relatedListState, setRelatedListState] = useState({ dishes: [] });
  const fetchRelatedData = async () => {
    const relatedList = await fetchData(`${URL}/recommand?page=${listNum}`);
    setTotalNum(() => relatedList.totalPages);
    setRelatedListState(relatedList);
  };
  const handleListNumDown = () => {
    if (listNum > 1) {
      setListNum((num) => num - 1);
    }
  };
  const handleListNumUp = () => {
    if (listNum < totalNum) {
      setListNum((num) => num + 1);
    }
  };
  useEffect(() => {
    fetchRelatedData();
  }, [listNum]);

  return (
    <>
      <RelatedListContainer>
        <RelatedListHeader>
          <RelatedTitle>함께하면 더욱 맛있는 식품</RelatedTitle>
          <Blank />
          <PageContainer>
            <LeftArrowBtn clickEventHandler={handleListNumDown} />
            <Pages>
              {listNum} / {totalNum}
            </Pages>
            <RightArrowBtn clickEventHandler={handleListNumUp} />
          </PageContainer>
        </RelatedListHeader>
        <RelatedContents relatedListState={relatedListState} />
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
  padding-bottom: 28px;
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
