import PropTypes from "prop-types";
import { CardImage, CardFlag } from "./Card.styled";

const CardImageAndFlag = ({
  props: { name, saveFileName, dawnDeliveryFlag, wholeNationDeliveryFlag },
  isHover,
}) => {
  return (
    <div>
      <CardImage
        src={`http://3.36.89.161/${saveFileName}`}
        alt={name}
        isHover={isHover}
      />
      {isHover && (dawnDeliveryFlag || wholeNationDeliveryFlag) && (
        <CardFlag
          isHover={isHover}
          flag={{ dawnDeliveryFlag, wholeNationDeliveryFlag }}
        >
          <div>새벽배송</div>
          <div>전국배송</div>
        </CardFlag>
      )}
    </div>
  );
};

CardImageAndFlag.propTypes = {
  props: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.string, PropTypes.bool])
  ).isRequired,
  isHover: PropTypes.bool.isRequired,
};

export default CardImageAndFlag;
