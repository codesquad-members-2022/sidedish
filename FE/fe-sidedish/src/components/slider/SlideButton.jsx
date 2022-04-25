import { ButtonContent } from '../../constants/slider'
import { Button } from './Slider.style';

const SlideButton = ({ buttonType }) => {
  return (
    <Button type={buttonType}>
      {ButtonContent[buttonType].text}
      {ButtonContent[buttonType].img}
    </Button>
  )
}

export default SlideButton;
