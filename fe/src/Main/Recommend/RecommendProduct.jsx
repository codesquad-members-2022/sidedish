import styled from 'styled-components';
import RecommendTab from './RecommendTab';

const RecommendWrapper = styled.div`
  margin-top: 56px;
`;

const RecommendInner = styled.div`
  padding: 0 80px;
  margin-bottom: 24px;
  display: flex;
  align-items: flex-start;

  p {
    margin-right: 16px;
    padding: 8px 16px;
    border: 2px solid ${({ theme }) => theme.colors.black};
    border-radius: 999px;
    ${({ theme }) => theme.fontStyles.mediumBold};
    color: ${({ theme }) => theme.colors.black};
    background-color: ${({ theme }) => theme.colors.offWhite};
  }

  h1 {
    ${({ theme }) => theme.fontStyles.display};
    color: ${({ theme }) => theme.colors.black};
  }
`;

const RecommendProduct = () => {
  return (
    <RecommendWrapper>
      <RecommendInner>
        <p>기획전</p>
        <h1>한 번 주문하면 두 번 반하는 반찬</h1>
      </RecommendInner>
      <RecommendTab></RecommendTab>
    </RecommendWrapper>
  );
};

export default RecommendProduct;
