import styled from "styled-components";
import PopupImageContents from "./PopupImageContents";
import PopupOrderContents from "./PopupOrderContents";

const PopupDetail = ({ cardClickState, setCardClickState }) => {
  const data = {
    images: [
      "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
      "http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg",
    ],
    title: "오리 주물럭_반조리",
    description: "감칠맛 나는 매콤한 양념",
    n_price: "15,800원",
    s_price: "12,640원",
    badge: ["런칭특가"],
  };

  const closePopup = (event) => {
    setCardClickState(!cardClickState);
  };

  return (
    <>
      <Contents>
        <CloseButton onClick={closePopup}>닫기</CloseButton>
        <ContentsDetailContainer>
          <PopupImageContents images={data.images}></PopupImageContents>
          <PopupOrderContents title={data.title} normalPrice={data.n_price} salePrice={data.s_price} badge={data.badge}></PopupOrderContents>
        </ContentsDetailContainer>
      </Contents>
    </>
  );
};

const Contents = styled.div`
  box-sizing: border-box;
  height: 596px;
  padding: 32px 48px;
  border-bottom: 1px solid #777;
`;

const CloseButton = styled.div`
  text-align: right;
  color: #777777;
  padding-bottom: 18px;
  cursor: pointer;
`;

const ContentsDetailContainer = styled.div`
  display: flex;
`;

export default PopupDetail;
