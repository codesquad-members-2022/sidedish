import * as S from './ProductDetailModal.style';

const CostItem = ({ size, name, cost }) => {
  return (
    <S.CostItem>
      <S.CostName size={size}>{name}</S.CostName>
      <S.CostPrice size={size}>{cost}원</S.CostPrice>
    </S.CostItem>
  );
};

export default CostItem;
