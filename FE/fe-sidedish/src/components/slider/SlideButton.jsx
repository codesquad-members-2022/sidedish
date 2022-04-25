import { ButtonContent } from '../../constants/slider'
import * as S from './Slider.style';

const SlideButton = ({ buttonType }) => {
  return (
    <S.Button type={buttonType}>
      {ButtonContent[buttonType].text}
      {ButtonContent[buttonType].img}
    </S.Button>
  )
}

export default SlideButton;
