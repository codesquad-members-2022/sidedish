import { StyledBtn } from './closeBtn.styled';

export function CloseBtn({ onClick }) {
  function handleClick() {
    onClick(null);
  }
  return <StyledBtn onClick={handleClick}>닫기</StyledBtn>;
}
