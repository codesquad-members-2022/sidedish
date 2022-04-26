import { ReactComponent as Prev } from '../asset/icons/left.svg';
import { ReactComponent as Next } from '../asset/icons/right.svg';

export const FIRST_PAGE = 1;

export const SLIDES_PER_VIEW = 4;
export const SMALL_SLIDES_PER_VIEW = 5;

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
