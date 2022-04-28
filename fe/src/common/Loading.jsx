import styled from 'styled-components';
import { FlexDiv } from 'common/FlexDiv';

const LoadingWrapper = styled.div`
  height: 200px;
  @keyframes spinner {
    0% {
      transform: rotate(0deg);
    }
    100% {
      transform: rotate(360deg);
    }
  }

  .loading-spinner {
    text-align: center;
    width: 50px;
    height: 50px;
    border: 10px solid #f3f3f3;
    border-top: 10px solid #383636;
    border-radius: 50%;
    animation: spinner 1.5s linear infinite;
  }
`;

const Loading = () => {
  return (
    <LoadingWrapper>
      <FlexDiv row={'center'}>
        <div className="loading-spinner"></div>
      </FlexDiv>
    </LoadingWrapper>
  );
};

export default Loading;
