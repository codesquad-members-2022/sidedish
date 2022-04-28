import * as S from './ProductDetailModal.style';

const Badges = ({ badges }) => {
  return (
    <>
      {badges.map((badge, index) => (
        <S.Badge key={index} type={`${badge}`}>
          {badge}
        </S.Badge>
      ))}
    </>
  );
};

export default Badges;
