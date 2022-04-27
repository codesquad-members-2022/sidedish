export const LeftArrowIcon = ({ isEndPage }) => (
  <svg width="11" height="20" viewBox="0 0 11 20" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path
      d="M9 18L1 10L9 2"
      stroke={isEndPage ? "#BCBCBC" : "#1B1B1B"}
      strokeWidth="2"
      strokeLinecap="square"
      strokeLinejoin="round"
    />
  </svg>
);
