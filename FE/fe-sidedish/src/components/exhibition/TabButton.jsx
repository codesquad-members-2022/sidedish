import * as S from './Exhibition.style';

const TapButton = ({ title, isActive }) => {
  return (
    <S.Button type='button' className={isActive ? 'active' : ''}>
      {title}
    </S.Button>
  );
};

export default TapButton;
