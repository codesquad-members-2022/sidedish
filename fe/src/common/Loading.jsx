import styled from 'styled-components';
import LoadingImage from 'image/loading.gif';

const LoadingWrapper = styled.div`
  text-align: center;

  img {
    width: 80px;
    height: 80px;
  }
`;

const Loading = () => {
  return (
    <LoadingWrapper>
      <img src={LoadingImage} alt="Loading..." />
    </LoadingWrapper>
  );
};

export default Loading;
