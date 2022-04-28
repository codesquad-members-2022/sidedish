import { useContext } from "react";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import PropTypes from "prop-types";
import DetailPageDescDiv from "./DetailPageDesc.styled";
import CloseBtnArea from "./CloseBtnArea/CloseBtnArea";
import Explaination from "./Explaination/Explaination";

const DetailPageDesc = ({ onClose }) => {
  const { id } = useContext(DetailInfoContext);
  if (!id) return null;

  return (
    <DetailPageDescDiv>
      <CloseBtnArea onClose={onClose} />
      <Explaination />
    </DetailPageDescDiv>
  );
};

DetailPageDesc.propTypes = {
  onClose: PropTypes.func.isRequired,
};

export default DetailPageDesc;
