import { BUTTON_CONTENT } from '../../constants/slide';
import * as S from './Slide.style';

const SlideButton = ({ isButtonDisabled, buttonType, changeCurrentPage }) => {
  return (
    <S.Button type={buttonType} disabled={isButtonDisabled(buttonType)} onClick={changeCurrentPage}>
      {BUTTON_CONTENT[buttonType].text}
      {BUTTON_CONTENT[buttonType].img}
    </S.Button>
  );
};

export default SlideButton;
