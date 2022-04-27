import PropTypes from "prop-types";
import { useState } from "react";
import { CardImage, CardFlag } from "./Card.styled";

const CardImageAndFlag = ({
  props: { name, saveFileName, dawnDeliveryFlag, wholeNationDeliveryFlag },
}) => {
  const [isHover, setIsHover] = useState(false);
  const handleMouseEvent = () => {
    setIsHover(!isHover);
  };

  return (
    <div onMouseEnter={handleMouseEvent} onMouseLeave={handleMouseEvent}>
      <CardImage
        src={`http://3.36.89.161/${saveFileName}`}
        alt={name}
        isHover={isHover}
      />
      <CardFlag
        isHover={isHover}
        flag={{ dawnDeliveryFlag, wholeNationDeliveryFlag }}
      >
        <div>새벽배송</div>
        <div>전국배송</div>
      </CardFlag>
    </div>
  );
};

CardImageAndFlag.propTypes = {
  props: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.string, PropTypes.bool])
  ).isRequired,
};

export default CardImageAndFlag;
