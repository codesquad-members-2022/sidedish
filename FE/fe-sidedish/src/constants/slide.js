import { ReactComponent as Prev } from '../asset/icons/left.svg';
import { ReactComponent as Next } from '../asset/icons/right.svg';

export const FIRST_PAGE = 1;

export const MARGIN = {
  small: 16,
  medium: 24,
  large: 24,
};

export const SLIDES_PER_VIEW = {
  small: 5,
  medium: 4,
  large: 4,
};

export const BUTTON_TYPE = {
  PREV: 'prev',
  NEXT: 'next',
};

export const BUTTON_CONTENT = {
  [BUTTON_TYPE.PREV]: {
    text: '이전',
    img: <Prev />,
  },
  [BUTTON_TYPE.NEXT]: {
    text: '다음',
    img: <Next />,
  },
};
