import { Container, Wrapper } from './Slider.style';
import { ButtonType } from '../../constants/slider';
import SlideButton from './SlideButton';

const Slider = ({ children }) => {
  return (
    <Container>
      <Wrapper>
        {children}
      </Wrapper>
      <SlideButton buttonType={ButtonType.PREV} />
      <SlideButton buttonType={ButtonType.NEXT} />
    </Container>
  );
};

export default Slider;
