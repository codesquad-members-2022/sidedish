import styled from 'styled-components';
import { Color } from '../Assets/CommonStyle';
import { useEffect, useRef } from 'react';

const Button = styled.button`
  position: absolute;
  top: 50%;
  font-size: 0;

  &[disabled] {
    cursor: default;
  }

  &.prev {
    right: calc(100% + 24px);
  }

  &.next {
    left: calc(100% + 24px);
  }
`;

export default function SlideButton({
  direction,
  disabled,
  setBtnDisabled,
  Start,
  End,
  viewItemCount,
  TOTAL_CARD_COUNT,
  INIT_SLIDER_NUM,
}) {
  const dir = direction === 'prev' ? 'M20 24L12 16L20 8' : 'M12 24L20 16L12 8';
  const sliderButton = useRef(null);
  const LAST_INDEX = TOTAL_CARD_COUNT - 1;

  const slideButtonClickHandler = () => {
    const targetButton = sliderButton.current.dataset.direction;

    switch (targetButton) {
      case 'prev':
        goToPrev();
        break;
      case 'next':
        goToNext();
        break;
    }
  };

  const goToPrev = () => {
    const PrevItemCount = End.num - viewItemCount;

    if (PrevItemCount < viewItemCount) {
      Start.set(INIT_SLIDER_NUM.start);
      End.set(INIT_SLIDER_NUM.end);
      return;
    }

    Start.set(Start.num - viewItemCount);
    End.set(End.num - viewItemCount);
  };

  const goToNext = () => {
    const NextItemCount = LAST_INDEX - End.num;
    const moveItemCount =
      NextItemCount < viewItemCount ? NextItemCount : viewItemCount;

    Start.set(Start.num + moveItemCount);
    End.set(End.num + moveItemCount);
  };

  const setDisabled = () => {
    if (setBtnDisabled.prev) {
      Start.num === 0 ? setBtnDisabled.prev(true) : setBtnDisabled.prev(false);
    }

    if (setBtnDisabled.next) {
      End.num === LAST_INDEX
        ? setBtnDisabled.next(true)
        : setBtnDisabled.next(false);
    }
  };

  useEffect(() => {
    setDisabled();
  }, [Start.num, End.num]);

  return (
    <Button
      className={direction}
      data-direction={direction}
      onClick={slideButtonClickHandler}
      disabled={disabled}
      ref={sliderButton}>
      <svg
        width="32"
        height="32"
        viewBox="0 0 32 32"
        fill="none"
        xmlns="http://www.w3.org/2000/svg">
        <path
          d={dir}
          stroke={disabled ? Color.gray3 : Color.black}
          strokeWidth="2"
          strokeLinecap="square"
          strokeLinejoin="round"
        />
      </svg>
    </Button>
  );
}
