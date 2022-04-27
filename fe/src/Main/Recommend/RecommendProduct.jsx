import styled from 'styled-components';
import RecommendTab from 'Main/Recommend/RecommendTab';

const RecommendWrapper = styled.div`
  margin-top: 56px;
`;

const RecommendInner = styled.div`
  margin-bottom: 24px;
  ${({ theme }) => theme.flexLayout.default};
  align-items: flex-start;

  span {
    margin-right: 16px;
    padding: 8px 16px;
    border: 2px solid ${({ theme }) => theme.colors.black};
    border-radius: 999px;
    color: ${({ theme }) => theme.colors.black};
    background-color: ${({ theme }) => theme.colors.offWhite};
    ${({ theme }) => theme.fontStyles.mediumBold};
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
        <span>기획전</span>
        <h1>한 번 주문하면 두 번 반하는 반찬</h1>
      </RecommendInner>
      <RecommendTab />
    </RecommendWrapper>
  );
};

export default RecommendProduct;
