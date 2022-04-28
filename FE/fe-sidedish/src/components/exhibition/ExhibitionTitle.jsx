import * as S from './Exhibition.style';

const ExhibitionTitle = ({ badge, title }) => {
  return (
    <S.TitleContainer>
      <S.Badge>{badge}</S.Badge>
      <S.Title>{title}</S.Title>
    </S.TitleContainer>
  );
};

export default ExhibitionTitle;
