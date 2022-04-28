import { AlertPortal } from "Portal/Portal";
import { useState } from "react";
import ExplainationDiv from "./Explanation.styled";
import Images from "./Images/Images";
import Alert from "./Order/Alert/Alert";
import Order from "./Order/Order";

const Explaination = () => {
  const [isAlertShow, setIsAlertShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");

  const handleAlert = () => {
    setIsAlertShow(!isAlertShow);
  };

  return (
    <>
      <ExplainationDiv>
        <Images />
        <Order handler={{ handleAlert, setAlertMessage }} />
      </ExplainationDiv>
      <AlertPortal>
        {isAlertShow && <Alert handler={handleAlert} message={alertMessage} />}
      </AlertPortal>
    </>
  );
};

export default Explaination;
