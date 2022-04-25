import { ReactComponent as Prev } from '../asset/icons/left.svg';
import { ReactComponent as Next } from '../asset/icons/right.svg';

export const ButtonType = {
  PREV: 'prev',
  NEXT: 'next',
};

export const ButtonContent = {
  [ButtonType.PREV]: {
    text: '이전',
    img: <Prev />,
  },
  [ButtonType.NEXT]: {
    text: '다음',
    img: <Next />
  }
}
