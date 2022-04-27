import styled from 'styled-components';
import { Color } from '../Assets/CommonStyle';

const Button = styled.button`
  position: absolute;
  top: 50%;
  font-size: 0;

  &.prev {
    right: calc(100% + 24px);
  }

  &.next {
    left: calc(100% + 24px);
  }
`;

export default function SlideButton({ direction }) {
  const dir = direction === 'prev' ? 'M20 24L12 16L20 8' : 'M12 24L20 16L12 8';
  return (
    <Button className={direction}>
      <svg
        width="32"
        height="32"
        viewBox="0 0 32 32"
        fill="none"
        xmlns="http://www.w3.org/2000/svg">
        <path
          d={dir}
          stroke={Color.black}
          strokeWidth="2"
          strokeLinecap="square"
          strokeLinejoin="round"
        />
      </svg>
    </Button>
  );
}
