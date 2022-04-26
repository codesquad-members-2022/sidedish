import styled from "styled-components";

const OrderBtn = () => {
  return (
    <>
      <Button>주문하기</Button>
    </>
  );
};

const Button = styled.div`
  background-color: black;
  color: white;
  font-weight: 700;
  line-height: 26px;
  text-align: center;
  font-size: 18px;
  padding: 16px;
  cursor: pointer;
`;

export default OrderBtn;
