import styled from "styled-components";
import PopupDetail from "./PopupDetail";
import RelatedList from "./RelatedLists";

const Popup = ({ cardClickState, setCardClickState, cardInfoState }) => {
  return (
    <>
      <PopupBackground cardClickState={cardClickState}>
        <PopupContainer>
          <PopupDetail {...{ cardClickState, setCardClickState, cardInfoState }}></PopupDetail>
          <RelatedList />
        </PopupContainer>
      </PopupBackground>
    </>
  );
};

const PopupBackground = styled.div`
  display: flex;
  ${(props) => (props.cardClickState === true ? "position: fixed" : "display: none")};
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  z-index: 100;
  justify-content: center;
  align-items: center;
`;

const PopupContainer = styled.div`
  width: 960px;
  height: 992px;
  background-color: white;
`;

export default Popup;
