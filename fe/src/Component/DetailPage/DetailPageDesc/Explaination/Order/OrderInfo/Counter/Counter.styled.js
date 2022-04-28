import styled from "styled-components";

const CounterDiv = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 26px;
  line-height: 32px;
`;

const ResultPriceDiv = styled.div`
  > :first-child {
    margin-right: 16px;
  }
`;

const CounterButtonDiv = styled.div`
  display: flex;

  div {
    width: 40px;
    height: 26px;
    text-align: center;
  }

  button {
    width: 32px;
    height: 32px;
  }
`;

export { CounterDiv, ResultPriceDiv, CounterButtonDiv };
