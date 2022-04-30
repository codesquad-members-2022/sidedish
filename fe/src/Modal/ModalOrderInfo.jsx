import { useRef, useState } from 'react';
import styled, { css } from 'styled-components';
import { ReactComponent as MinusIcon } from 'image/minus.svg';
import { ReactComponent as PlusIcon } from 'image/plus.svg';
import { setPrice } from 'util';
import { FlexDiv } from 'common/FlexDiv';
import { SERVER_URL } from 'constant';
import axios from 'axios';

const TotalAmount = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 88px;
`;

const TotalCost = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  min-width: 220px;
  color: ${({ theme }) => theme.colors.gray2};

  .total__cost {
    margin-left: 16px;
    ${({ theme }) => theme.fontStyles.largeBold};
    color: ${({ theme }) => theme.colors.black};
  }
`;

const ModalOrderButton = styled.button`
  position: absolute;
  bottom: 0;
  width: 440px;
  height: 58px;
  text-align: center;
  outline: none;
  border: none;
  cursor: ${(props) => {
    return props.disabled ? 'default' : 'pointer';
  }};
  background: ${(props) => {
    return props.disabled
      ? css`
          ${({ theme }) => theme.colors.gray3}
        `
      : css`
          ${({ theme }) => theme.colors.black}
        `;
  }};
  color: ${({ theme }) => theme.colors.white};
  ${({ theme }) => theme.fontStyles.order};
`;

// const OrderModal = styled.div`
//   width: 343px;
//   background: ${({ theme }) => theme.colors.white};

//   p {
//     padding: 16px;
//   }

//   button {
//     width: 100%;
//     background: ${({ theme }) => theme.colors.black};
//     color: ${({ theme }) => theme.colors.white};
//   }
// `;

const ModalOrder = ({ item }) => {
  const [stock, setStock] = useState(0);
  const [order, setOrder] = useState(true);

  const onIncrease = () => {
    if (stock >= item.stock) return;
    setOrder('');
    setStock(stock + 1);
  };

  const onDecrease = () => {
    if (stock <= 0) return;

    if (stock - 1 !== 0) {
      setStock(stock - 1);
    } else {
      setOrder(true);
      setStock(stock - 1);
    }
  };

  const totalCost = useRef();
  const onClick = async () => {
    const orderUserEmail = localStorage.getItem('userEmail');
    if (totalCost.current.innerText === '0원') {
      setOrder(true);
    }

    if (!orderUserEmail) {
      alert('로그인을 해주세요.');
      return;
    } else {
      await axios.post(
        `${SERVER_URL}orders/${item.id}`,
        {
          userEmail: orderUserEmail,
          quantity: stock,
        },
        {
          headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            userEmail: orderUserEmail,
          },
        }
      );

      alert(`상품을 주문했습니다.`);
      window.location.replace('/');
    }
  };

  return (
    <>
      <FlexDiv row={'space-between'} column={'center'}>
        <TotalAmount>
          <MinusIcon onClick={onDecrease} />
          <span>{stock}</span>
          <PlusIcon onClick={onIncrease} />
        </TotalAmount>
        <TotalCost>
          <span>총 주문금액</span>
          <span className="total__cost" ref={totalCost}>
            {setPrice(item.discountPrice * stock)}원
          </span>
        </TotalCost>
      </FlexDiv>
      <ModalOrderButton disabled={order} onClick={onClick}>
        {item.stock ? '주문하기' : '품절'}
      </ModalOrderButton>
    </>
  );
};

export default ModalOrder;
