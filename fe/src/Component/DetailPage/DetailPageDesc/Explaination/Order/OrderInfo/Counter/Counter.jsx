import { useContext } from "react";
import PropTypes from "prop-types";
import getPriceType from "Util/util";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import { plusMinusButtons } from "MockData/MockData";
import { CounterDiv, ResultPriceDiv, CounterButtonDiv } from "./Counter.styled";

const Counter = ({ state: { count, setCount } }) => {
  const { discountRate, price } = useContext(DetailInfoContext);
  const resultPrice = getPriceType(price * count, discountRate);

  const handleButtonClick = (direction) => {
    const calculating = {
      plus: () => count + 1,
      minus: () => (count > 1 ? count - 1 : count),
    };
    const nextCount = calculating[direction];

    if (count !== nextCount) setCount(calculating[direction]);
  };

  return (
    <CounterDiv>
      <CounterButtonDiv>
        <button type="button" onClick={() => handleButtonClick("minus")}>
          {plusMinusButtons.minus}
        </button>
        <div>{count}</div>
        <button type="button" onClick={() => handleButtonClick("plus")}>
          {plusMinusButtons.plus}
        </button>
      </CounterButtonDiv>
      <ResultPriceDiv>
        <span>총 주문금액</span>
        <span>{resultPrice}</span>
      </ResultPriceDiv>
    </CounterDiv>
  );
};

Counter.propTypes = {
  state: PropTypes.objectOf(
    PropTypes.oneOfType([PropTypes.func, PropTypes.number])
  ).isRequired,
};

export default Counter;
