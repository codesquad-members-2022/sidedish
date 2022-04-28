import deliveryType1 from "@/assets/image/deliveryType1.svg";
import deliveryType2 from "@/assets/image/deliveryType2.svg";
import deliveryType3 from "@/assets/image/deliveryType3.svg";
import "./DeliveryLabel.scss";

export function DeliveryLabel({ deliveryID, isHovered, setIsHovered }) {
  const deliveryType = getDeliveryType(deliveryID);
  return (
    <>
      {isHovered && (
        <label className="menu-article__delivery">
          <img
            src={deliveryType}
            alt={deliveryType}
            onMouseEnter={() => {
              setIsHovered(true);
            }}
          />
        </label>
      )}
    </>
  );
}

function getDeliveryType(deliveryID) {
  let type;
  if (deliveryID === 1) type = deliveryType1;
  else if (deliveryID === 2) type = deliveryType2;
  else if (deliveryID === 3) type = deliveryType3;

  return type;
}
