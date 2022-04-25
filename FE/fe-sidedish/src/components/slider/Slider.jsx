import * as S from './Slider.style';
import { ButtonType } from '../../constants/slider';
import SlideButton from './SlideButton';

const Slider = ({ children }) => {
  return (
    <S.Container>
      <S.Wrapper>
        {children}
      </S.Wrapper>
      <SlideButton buttonType={ButtonType.PREV} />
      <SlideButton buttonType={ButtonType.NEXT} />
    </S.Container>
  );
};

export default Slider;
