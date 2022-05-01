import styled from 'styled-components';

const MainWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-bottom: 100px;
`;

const AllCategoryBtn = styled.button`
  width: 203px;
  height: 62px;
  font-size: ${({ theme: { fontSize } }) => fontSize.large};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.regular};
  color: ${({ theme: { colors } }) => colors.grey1};
  border: 1px solid ${({ theme: { colors } }) => colors.grey4};
`;

export { MainWrapper, AllCategoryBtn };
