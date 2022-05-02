import { StyledOrderBtn } from './orderBtn.styled';

export function OrderBtn({ onClick }) {
  function handleClick() {
    onClick(true);
  }

  return (
    <StyledOrderBtn flex justify="center" align="center" onClick={handleClick}>
      주문하기
    </StyledOrderBtn>
  );
}
