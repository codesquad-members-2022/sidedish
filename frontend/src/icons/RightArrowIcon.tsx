export const RightArrowIcon = ({ isEndPage }: { isEndPage: boolean }) => (
  <svg
    width="11"
    height="20"
    viewBox="0 0 11 20"
    fill="none"
    xmlns="http://www.w3.org/2000/svg"
  >
    <path
      d="M2 18L10 10L2 2"
      stroke={isEndPage ? "#BCBCBC" : "#1B1B1B"}
      strokeWidth="2"
      strokeLinecap="square"
      strokeLinejoin="round"
    />
  </svg>
);
