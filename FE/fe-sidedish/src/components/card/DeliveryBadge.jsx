import * as S from './Card.style';

const DevlieryBadge = ({ children }) => {
  return (
    <S.RoundBadgeBackground>
      <S.RoundBadge>
        {children}
      </S.RoundBadge>
    </S.RoundBadgeBackground>
  )
}

export default DevlieryBadge;
