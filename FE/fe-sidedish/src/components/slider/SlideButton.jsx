import { BUTTON_CONTENT } from '../../constants/slide';
import * as S from './Slide.style';

const SlideButton = ({ buttonType }) => {
  return (
    <S.Button type={buttonType}>
      {BUTTON_CONTENT[buttonType].text}
      {BUTTON_CONTENT[buttonType].img}
    </S.Button>
  );
};

export default SlideButton;
