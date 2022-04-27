import styled from 'styled-components';

const FlexWrapper = styled.div`
  display: flex;
  justify-content: ${(props) => props.row};
  align-items: ${(props) => props.column};
`;

export const FlexDiv = ({ row, column, children }) => {
  return (
    <FlexWrapper row={row} column={column}>
      {children}
    </FlexWrapper>
  );
};
