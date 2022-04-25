import * as S from './Card.style';

const Badges = ({ badges }) => {
  return (
    <S.BadgeContainer>
      {badges.map((badge, index) => <S.Badge key={index} type={`${badge}`}>{badge}</S.Badge>)}
    </S.BadgeContainer>
  )
}

export default Badges;
