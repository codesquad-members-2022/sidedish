import colors from '../../constants/colors';

const LeftArrowIcon = ({ isStartPage }) => (
  <svg
    xmlns="http://www.w3.org/2000/svg"
    width="11"
    height="20"
    viewBox="0 0 11 20"
    fill="none"
  >
    <path
      d="M9 18L1 10L9 2"
      stroke={isStartPage ? colors.greyThree : colors.black}
      strokeWidth="2"
      strokeLinecap="square"
      strokeLinejoin="round"
    />
  </svg>
);

export default LeftArrowIcon;
